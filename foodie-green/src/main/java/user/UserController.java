package user;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
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
				userdto.email = String.valueOf(userInfo.get("email"));
				userdto.name = String.valueOf(userInfo.get("nickname"));
				userdto.nickname = String.valueOf(userInfo.get("nickname"));
				userdto.pw = pw;
				userService.signin(userdto);
			} else {
				userdto = userService.login_kakao(email);
			}
			session.setAttribute("user", userdto);
			session.setAttribute("login", "ok");
			session.setAttribute("nickname", userdto.nickname);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "/user/mypage";
	}

	@GetMapping("/callback")
	public String callback() {
		return "/user/callback";
	}

	@GetMapping("/signin")
	public String signin() {
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
			session.setAttribute("nickname", userdto.nickname);
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
	@RequestMapping(value = "/pwAuth", method = RequestMethod.POST)
	public String pwAuth(String email, String phone) {
		String response = "null";
		HashMap<String, String> map = new HashMap<>();
		map.put("email", email);
		map.put("phone", phone);

		if (userService.findPw(map) == null) {
			response = "회원가입시 기입했던 이메일, 핸드폰 번호 다시 한번 확인하여 기입 바랍니다.";
		} else {
			String pw = userService.findPw(map);

			String setFrom = "foodiengreen@gmail.com";
			String toMail = email;
			String title = "비밀번호 인증 이메일 입니다.";
			String content = "홈페이지를 방문해주셔서 감사합니다." + "<br><br>" + "비밀번호는 " + pw + "입니다.";

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
			response = "비밀번호가 입력하신 이메일 주소로 전달되었습니다.";
		}

		return response;
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
	public String nickCheck(String nickname) {
		String response = "";
		if(userService.checkNickname(nickname)==1) {
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
	
	@GetMapping("/mypage/edit")
	public String editUser() {
		return "/user/mypage";
	}
	
	@PostMapping("/mypage/edit")
	@ResponseBody
	public void editUser(UserDTO userdto, HttpSession session) {
		userService.editUser(userdto);
		session.setAttribute("user", userdto);
	}
	

	/**
	 * 카카오 로그인 API [GET] /app/login/kakao
	 * 
	 * @return BaseResponse<String>
	 * 
	 * @ResponseBody @GetMapping("/kakao") public BaseResponse<PostLoginRes>
	 *               kakaoLogin(@RequestParam(required = false) String code) { try {
	 *               // URL에 포함된 code를 이용하여 액세스 토큰 발급 String accessToken =
	 *               loginService.getKakaoAccessToken(code);
	 *               System.out.println(accessToken);
	 * 
	 *               // 액세스 토큰을 이용하여 카카오 서버에서 유저 정보(닉네임, 이메일) 받아오기 HashMap<String,
	 *               Object> userInfo = loginService.getUserInfo(accessToken);
	 *               System.out.println("login Controller : " + userInfo);
	 * 
	 *               PostLoginRes postLoginRes = null;
	 * 
	 *               // 만일, DB에 해당 email을 가지는 유저가 없으면 회원가입 시키고 유저 식별자와 JWT 반환 // 현재
	 *               카카오 유저의 전화번호를 받아올 권한이 없어서 테스트를 하지 못함.
	 *               if(loginProvider.checkEmail(String.valueOf(userInfo.get("email")))
	 *               == 0) { //PostLoginRes postLoginRes = 해당 서비스; return new
	 *               BaseResponse<>(postLoginRes); } else { // 아니면 기존 유저의 로그인으로 판단하고
	 *               유저 식별자와 JWT 반환 postLoginRes =
	 *               loginProvider.getUserInfo(String.valueOf(userInfo.get("email")));
	 *               return new BaseResponse<>(postLoginRes); } } catch
	 *               (BaseException exception) { return new
	 *               BaseResponse<>((exception.getStatus())); } }
	 */
}
