package user;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.servlet.http.HttpSession;
import recipes.DiaryDTO;

@Controller
public class UserController {

	@Autowired
	JavaMailSender mailSender;

	@Autowired
	LoginService loginService;

	@Autowired
	UserServiceImpl userService;

	@GetMapping("/login")
	public String login() {
		return "/user/login";
	}

	@GetMapping("/logout")
	public String logout(HttpSession session) {		
		session.invalidate();
		
		return "redirect:/";
	}
	
	@GetMapping("/login_kakao")
	public String login_kakao(@RequestParam(required = false) String code,HttpSession session) {
		try {
			// URL에 포함된 code를 이용하여 액세스 토큰 발급
			String accessToken = loginService.getKakaoAccessToken(code);
			System.out.println(accessToken);

			// 액세스 토큰을 이용하여 카카오 서버에서 유저 정보(닉네임, 이메일) 받아오기
			HashMap<String, Object> userInfo = loginService.getUserInfo(accessToken);
			System.out.println("login Controller : " + userInfo);
			System.out.println("login Controller : " + userInfo.get("nickname"));
			System.out.println("login Controller : " + userInfo.get("email"));
			
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
			System.out.println("accessToken: "+accessToken);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "/user/mypage";
	}

	@GetMapping("/logout_kakao")
	public String logout_kakao(HttpSession session) {	
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
		System.out.println(userDTO.toString());
		userService.signin(userDTO);
	}

	// @PostMapping에서 @RequestParam을 써서 받을 수 있는 것은 HTML Form 태그에서 method 가 POST 전송일
	// 때는 @RequestParam으로 값을 받을 수 있다.
	// https://amagrammer91.tistory.com/106, https://dololak.tistory.com/630
	// 아이디 중복?
	@PostMapping("/userlogin")
	public String userLogin(@Param("email") String email, @Param("pw") String pw, HttpSession session) {
		//String result = "null";
		HashMap<String, String> map = new HashMap<>();
		map.put("email", email);
		map.put("pw", pw);
		
		UserDTO userdto = userService.login(map);
		if (userdto != null) {
			session.setAttribute("user", userdto);
			session.setAttribute("login", "ok");
			session.setAttribute("nickname", userdto.getNickname());

			// alert
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
	@ResponseBody
	public String findId(@RequestBody Map<String, String> params) {
		String phone = params.get("phone");
		String name = params.get("name");
		HashMap<String, String> map = new HashMap<>();
		map.put("phone", phone);
		map.put("name", name);

		String response = "입력하신 이름, 번호에 해당하는 이메일이 없습니다.";
		if (userService.findId(map) != null) {
			response = "해당 이메일 주소: " + userService.findId(map);
			System.out.println(response);
		}
		return response;
	}

	@GetMapping("/findPw")
	public String findPw() {
		return "/user/findPw";
	}

	@ResponseBody
	@RequestMapping(value = "/findPw", method = RequestMethod.POST)
	public String findPw(String email, String phone) {
		String response = "null";
		HashMap<String, String> map = new HashMap<>();
		map.put("email", email);
		map.put("phone", phone);

		response = userService.findPw(map);
		return response;
	}
	
	@ResponseBody
	@RequestMapping(value = "/pwAuth", method = RequestMethod.POST)
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
	@RequestMapping(value = "/emailAuth", method = RequestMethod.POST)
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
	
	@RequestMapping(value = "/emailCheck", method = RequestMethod.POST)
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
	
	@RequestMapping(value = "/nickCheck", method = RequestMethod.POST)
	@ResponseBody
	public String nickCheck(@RequestParam Map<String, Object> map) {
		String response = "";
		String nickname = (String)map.get("nickname");
		String email = (String)map.get("email");
		//System.out.println(nickname + ","+email);
		
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
	public String mypage(HttpSession session) {		
		return "/user/mypage";
	}
	
	@GetMapping("/mypage/delete")
	@ResponseBody
	public void deleteUser(HttpSession session) {
		UserDTO user =(UserDTO)session.getAttribute("user");
		String email = user.getEmail();
		userService.deleteUser(email);
		session.invalidate();
	}
	
	@GetMapping("/mypage/kakaounlink")
	public String unlink(HttpSession session) {	
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
	public void editUser(UserDTO userdto, HttpSession session) {
		userService.editUser(userdto);
		UserDTO user= userService.getUserInfo(userdto.getEmail());
		session.setAttribute("user", user);
	}
	
	@PostMapping("/mypage/userDiary")
	@ResponseBody
	public List<UserDiaryDTO> getUserDiary(HttpSession session) {
		UserDTO user =(UserDTO)session.getAttribute("user");
		List<UserDiaryDTO> list=userService.getDiary(user.getEmail());
		for(UserDiaryDTO one:list) {
			System.out.println(one.getContents());
		}
		return userService.getDiary(user.getEmail());
	}
	
	@PostMapping("/mypage/likes")
	@ResponseBody
	public ArrayList<DiaryDTO> getUserLikes(HttpSession session) {
		//System.out.println("post매핑");		
		UserDTO user =(UserDTO)session.getAttribute("user");
		List<Integer> likedlist = userService.getUserLikes(user.getId());
		//System.out.println("for문 전");
		for(int i=0; i<likedlist.size(); i++) {
			System.out.println(likedlist.get(i));
		}
		ArrayList<DiaryDTO> list = new ArrayList<>();
		for(int id: likedlist) {
			System.out.println(id);
			
			DiaryDTO diarydto = userService.getLikedDiaryInfo(id);
			list.add(diarydto);
		}
		return list;
	}
}
