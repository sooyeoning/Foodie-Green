package user;

import java.util.Random;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import user.dto.UserDTO;
import user.model.FindIdReq;
import user.model.FindPwReq;
import user.model.FindPwRes;
import user.model.GetKakaoUserInfoRes;
import user.model.LoginReq;
import user.model.SignInReq;
import user.model.NicknameDuplicateReq;

@Controller
@RequiredArgsConstructor
@Slf4j
public class UserController {

	private final JavaMailSender mailSender;
	private final LoginService loginService;
	private final UserService userService;
	private final HttpSession session;
	private final HttpServletRequest request;
	
	@Value("${oauth.authorize.url}")
	private String authorizeURL;
	
    @Value("${spring.mail.username}")
    private String mailSenderName;
    
	@GetMapping("/login")
	public String login() {
		return "/user/login";
	}

	@GetMapping("/logout")
	public String logout() {		
		session.invalidate();
		
		return "redirect:/";
	}
	
	@GetMapping("/oauth/authorize")
	public String getKakaoAuthorize() {
		return "redirect:"+authorizeURL;
	}
	
	@GetMapping("/login_kakao")
	public String login_kakao(@RequestParam String code) {
		log.info("login_kakao start");
		try {
			// URL에 포함된 code를 이용하여 액세스 토큰 발급
			String accessToken = loginService.getKakaoAccessToken(code);
			log.info(accessToken);

			// 액세스 토큰을 이용하여 카카오 서버에서 유저 정보(닉네임, 이메일) 받아오기
			GetKakaoUserInfoRes userInfo = loginService.getUserInfo(accessToken);
			log.info("login Controller {} ", userInfo);
			log.info("login Controller {} ", userInfo.getNickname());
			log.info("login Controller {} ", userInfo.getEmail());
			
			//이메일 중복체크
			int checkEmail = userService.checkEmail(userInfo.getEmail());
			
			String email = userInfo.getEmail();
			UserDTO userdto = new UserDTO();
			
			if(checkEmail==0) {
				String pw = "K1" + loginService.tempPassword(10) + "!";
				
				userService.signin(SignInReq.builder()
						.email(email)
						.name(userInfo.getNickname())
						.nickname(userInfo.getNickname())
						.phone("010-0000-0000")
						.pw(pw)
						.logintype("kakao")
						.build()
				);
			} 
			userdto = userService.login_kakao(email);
			
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
	public String signin(@RequestParam("email") String email, Model model) {
		SignInReq req = new SignInReq();
		req.setEmail(email);
		model.addAttribute("signInReq", req);
		return "/user/signin";
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
	public String findPw(Model model) {
		model.addAttribute("findPwReq", new FindPwReq());
		return "/user/findPw";
	}

	@PostMapping(value = "/findPw")
	public String findPw(
			@ModelAttribute @Validated FindPwReq findPwReq,
			BindingResult bindingResult) {
		String pw = "null";
		
		//인증번호 전달
		if(!findPwReq.isHasSentEmailAuth()) {
			bindingResult.rejectValue("hasSentEmailAuth", "invalid.hasSentEmailAuth", new Object[]{findPwReq.isHasSentEmailAuth()}, "인증번호 전달 버튼 클릭!");
		}
		//인증번호 확인
		if(!findPwReq.isHasCheckedEmailAuth()) {
			bindingResult.rejectValue("hasCheckedEmailAuth", "invalid.hasCheckedEmailAuth", new Object[]{findPwReq.isHasCheckedEmailAuth()}, "인증번호 확인 버튼 클릭!");
		}
		
		if(bindingResult.hasErrors()) {
			return "user/findPw";
		}

		pw = userService.findPw(findPwReq);
		
		//찾은 비밀번호를 이메일 전달?
		request.setAttribute("pw", pw);
		return "user/findPwResult";
	}
	
	@ResponseBody
	@PostMapping(value = "/pwAuth")
	public FindPwRes pwAuth(@RequestBody FindPwReq findPwReq) {
		FindPwRes res = new FindPwRes();
		String response = "null";

		if (userService.findPw(findPwReq) == null) {
			response = "회원가입시 기입했던 이메일, 핸드폰 번호 다시 한번 확인하여 기입 바랍니다.";
		} else {
			//String pw = userService.findPw(map);
			Random random = new Random();
			int checkNum = random.nextInt(888888) + 111111;
			
			res.setSecretkey(checkNum);

			String title = "비밀번호 인증 이메일 입니다.";
			String content = "홈페이지를 방문해주셔서 감사합니다." + "<br><br>" + "인증번호는 " + checkNum + "입니다.";
			sendMail(findPwReq.getEmail(), title, content);

			response = "인증번호가 입력하신 이메일 주소로 전달되었습니다.";
		}
		res.setResponse(response);

		return res;
	}

	@ResponseBody
	@PostMapping(value = "/emailAuth")
	public String emailAuth(String email) {

		Random random = new Random();
		int checkNum = random.nextInt(888888) + 111111;

		String title = "이메일 인증 이메일 입니다.";
		String content = "홈페이지를 방문해주셔서 감사합니다." + "<br><br>" + "인증 번호는 " + checkNum + "입니다." + "<br>"
				+ "해당 인증번호를 인증번호 확인란에 기입하여 주세요.";
		
		sendMail(email, title, content);

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
	
	@PostMapping("/signin")
	public String signin(@Validated @ModelAttribute SignInReq signInReq,
			BindingResult bindingResult) {
		
		NicknameDuplicateReq req = new NicknameDuplicateReq(signInReq.getNickname(), signInReq.getEmail());
	
		if(userService.checkNickname(signInReq.getNickname())==1) {// 다른사람이 사용중
			bindingResult.rejectValue("nickname", "invalid.nickname", new Object[]{signInReq.getNickname()}, "이미 사용중인 닉네임입니다");
		}
		
		if(!userService.checkPw(signInReq.getPw(), signInReq.getCheckpw())){
			bindingResult.rejectValue("checkpw", "invalid.checkpw", new Object[] {signInReq.getCheckpw()}, "입력하신 비밀번호가 올바르지 않습니다. 비밀번호 확인 후 다시 입력해주세요.");
		}
		
		if (bindingResult.hasErrors()) {
			log.info("bindingResult: {}", bindingResult);
		} else {
			log.info(signInReq.toString());
			userService.signin(signInReq);
			return "redirect:/login";
		}
		
		return "user/signin";
	}
	
	public void sendMail(String email, String titleParam, String contentParam) {
		String setFrom = mailSenderName;
		String toMail = email;
		String title = titleParam;
		String content = contentParam;

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
	}
}
