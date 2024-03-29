package user;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import recipes.DiaryDTO;
import user.model.FindIdReq;
import user.model.LoginReq;

@Controller
@RequiredArgsConstructor
@Slf4j
public class UserController {

	private final JavaMailSender mailSender;
	private final LoginService loginService;
	private final UserService userService;
	private final HttpSession session;

	@GetMapping("/login")
	public String login() {
		return "/user/login";
	}

	@GetMapping("/logout")
	public String logout() {		
		session.invalidate();
		
		return "redirect:/";
	}
	
	@GetMapping("/login_kakao")
	public String login_kakao(@RequestParam(required = false) String code) {
		try {
			// URL에 포함된 code를 이용하여 액세스 토큰 발급
			String accessToken = loginService.getKakaoAccessToken(code);
			log.info(accessToken);

			// 액세스 토큰을 이용하여 카카오 서버에서 유저 정보(닉네임, 이메일) 받아오기
			HashMap<String, Object> userInfo = loginService.getUserInfo(accessToken);
			log.info("login Controller {} ", userInfo);
			log.info("login Controller {} ",userInfo.get("nickname"));
			log.info("login Controller {} ", userInfo.get("email"));
			
			//이메일 중복체크
			int checkEmail = userService.checkEmail(String.valueOf(userInfo.get("email")));
			
			String email = String.valueOf(userInfo.get("email"));
			
			UserDTO userdto = new UserDTO();
			
			if(checkEmail==0) {
				String pw = "K1" + loginService.tempPassword(10) + "!";
				//임의 비밀번호 확인: System.out.println(pw);
				userdto.setEmail(String.valueOf(userInfo.get("email")));
				userdto.setName(String.valueOf(userInfo.get("nickname")));
				userdto.setNickname(String.valueOf(userInfo.get("nickname")));
				userdto.setPw(pw);
				userdto.setLogintype("kakao");
				userdto.setKakaoId(String.valueOf(userInfo.get("kakaoId")));
				userdto.setPhone("010-0000-0000");
				userService.signin(userdto);
			} else {
				userdto = userService.login_kakao(email);
			}
			session.setAttribute("user", userdto);
			session.setAttribute("login", "ok");
			session.setAttribute("nickname", userdto.getNickname());
			session.setAttribute("accessToken", accessToken);
			log.info("accessToken {}",accessToken);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "/user/mypage";
	}

	@GetMapping("/logout_kakao")
	public String logout_kakao() {	
		loginService.logout((String)session.getAttribute("accessToken"));
		session.invalidate();
		
		return "redirect:/";
	}
	
	@GetMapping("/callback")
	public String callback() {
		return "/user/callback";
	}

	@GetMapping("/signin_email")
	public String signin_email() {
		return "/user/signin_email";
	}
	
	@GetMapping("/signin")
	public String signin(@RequestParam("email") String email) {
		return "/user/signin";
	}

	@PostMapping("/signin_request")
	@ResponseBody
	public void signin(UserDTO userDTO) {
		log.info(userDTO.toString());
		userService.signin(userDTO);
	}

	@PostMapping("/userlogin")
	public String userLogin(@ModelAttribute LoginReq loginReq) {
		
		UserDTO userdto = userService.login(loginReq);
		if (userdto != null) {
			session.setAttribute("user", userdto);
			session.setAttribute("login", "ok");
			session.setAttribute("nickname", userdto.getNickname());

			//alert
			return "redirect:/";
		} else {
			// alert
			return "/user/signin";
		}
		
	}

	@GetMapping("/findId")
	public String findId() {
		return "/user/findId";
	}

	@PostMapping("/findId")
	public String findId(@ModelAttribute FindIdReq findIdReq, Model model) {
		String response = "해당 정보와 맞는 이메일 주소가 없습니다.";
		if (userService.findId(findIdReq) != null) {
			response = "아이디: "+userService.findId(findIdReq);
		}
		model.addAttribute("response", response);
		return "/user/findIdResult";
	}

	@GetMapping("/findPw")
	public String findPw() {
		return "/user/findPw";
	}

	@ResponseBody
	@PostMapping(value = "/findPw")
	public String findPw(String email, String phone) {
		String response = "null";
		HashMap<String, String> map = new HashMap<>();
		map.put("email", email);
		map.put("phone", phone);

		response = userService.findPw(map);
		return response;
	}
	
	@ResponseBody
	@PostMapping(value = "/pwAuth")
	public HashMap<String, Object> pwAuth(String email, String phone) {
		String response = "null";
		HashMap<String, String> map = new HashMap<>();
		map.put("email", email);
		map.put("phone", phone);

		HashMap<String, Object> result = new HashMap<>();

		if (userService.findPw(map) == null) {
			response = "회원가입시 기입했던 이메일, 핸드폰 번호 다시 한번 확인하여 기입 바랍니다.";
			result.put("response", response);
		} else {
			//String pw = userService.findPw(map);
			Random random = new Random();
			int checkNum = random.nextInt(888888) + 111111;
			
			result.put("secretkey", checkNum);

			String setFrom = "foodiengreen@gmail.com";
			String toMail = email;
			String title = "비밀번호 인증 이메일 입니다.";
			String content = "홈페이지를 방문해주셔서 감사합니다." + "<br><br>" + "인증번호는 " + checkNum + "입니다.";

			try {

				jakarta.mail.internet.MimeMessage message = mailSender.createMimeMessage();
				MimeMessageHelper helper = new MimeMessageHelper(message, true, "utf-8");
				helper.setFrom(setFrom);
				helper.setTo(toMail);
				helper.setSubject(title);
				helper.setText(content, true);
				mailSender.send(message);

			} catch (Exception e) {
				e.printStackTrace();
			}
			response = "인증번호가 입력하신 이메일 주소로 전달되었습니다.";
			result.put("response", response);

		}

		return result;
	}

	@ResponseBody
	@PostMapping(value = "/emailAuth")
	public String emailAuth(String email) {

		Random random = new Random();
		int checkNum = random.nextInt(888888) + 111111;

		String setFrom = "foodiengreen@gmail.com";
		String toMail = email;
		String title = "이메일 인증 이메일 입니다.";
		String content = "홈페이지를 방문해주셔서 감사합니다." + "<br><br>" + "인증 번호는 " + checkNum + "입니다." + "<br>"
				+ "해당 인증번호를 인증번호 확인란에 기입하여 주세요.";

		try {

			jakarta.mail.internet.MimeMessage message = mailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(message, true, "utf-8");
			helper.setFrom(setFrom);
			helper.setTo(toMail);
			helper.setSubject(title);
			helper.setText(content, true);
			mailSender.send(message);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return Integer.toString(checkNum);
	}
	
	@PostMapping("/emailCheck")
	@ResponseBody
	public String emailCheck(String email) {
		String response = "";
		if(userService.checkEmail(email)==1) {
			response = "이미 가입된 회원입니다.";
		} else {
			response = "가입 가능한 회원입니다.";
		}
		return response;
	}
	
	@PostMapping("/nickCheck")
	@ResponseBody
	public String nickCheck(@RequestParam Map<String, Object> map) {
		String response = "";
		String nickname = (String)map.get("nickname");
		String email = (String)map.get("email");
		
		HashMap<String, String> param = new HashMap<>();
		param.put("nickname", nickname);
		param.put("email", email);
		
		if(userService.checkNickname(nickname)==1 && userService.checkPrevNickname(param)==0) {//닉네임사용중+다른사람이 사용중(0)
			response = "이미 사용중인 닉네임입니다.";
		} else {
			response = "사용 가능한 닉네임입니다.";
		}
		return response;
	}
	
	@GetMapping("/mypage")
	public String mypage() {		
		return "/user/mypage";
	}
	
	@GetMapping("/mypage/delete")
	@ResponseBody
	public void deleteUser() {
		UserDTO user =(UserDTO)session.getAttribute("user");
		String email = user.getEmail();
		userService.deleteUser(email);
		session.invalidate();
	}
	
	@GetMapping("/mypage/kakaounlink")
	public String unlink() {	
		loginService.unlink((String)session.getAttribute("accessToken"));
		session.invalidate();
		return "redirect:/";
	}
	
	@GetMapping("/mypage/edit")
	public String editUser() {
		return "/user/mypage";
	}
	
	@PostMapping("/mypage/edit")
	@ResponseBody
	public void editUser(UserDTO userdto) {
		userService.editUser(userdto);
		UserDTO user= userService.getUserInfo(userdto.getEmail());
		session.setAttribute("user", user);
	}
	
	@PostMapping("/mypage/userDiary")
	@ResponseBody
	public List<UserDiaryDTO> getUserDiary() {
		UserDTO user =(UserDTO)session.getAttribute("user");
		List<UserDiaryDTO> list=userService.getDiary(user.getEmail());
		for(UserDiaryDTO one:list) {
			log.info(one.getContents());
		}
		return userService.getDiary(user.getEmail());
	}
	
	@PostMapping("/mypage/likes")
	@ResponseBody
	public ArrayList<DiaryDTO> getUserLikes() {
		UserDTO user =(UserDTO)session.getAttribute("user");
		List<Integer> likedlist = userService.getUserLikes(user.getId());

		for(int i=0; i<likedlist.size(); i++) {
			log.info(""+likedlist.get(i));
		}
		ArrayList<DiaryDTO> list = new ArrayList<>();
		for(int id: likedlist) {
			//System.out.println(id);
			
			DiaryDTO diarydto = userService.getLikedDiaryInfo(id);
			list.add(diarydto);
		}
		return list;
	}
}
