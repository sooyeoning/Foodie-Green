package user;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import recipes.DiaryDTO;
import user.dto.UserDTO;
import user.dto.UserDiaryDTO;

@Controller
@RequiredArgsConstructor
@RequestMapping("/mypage")
@Slf4j
public class MypageController {

	private final HttpSession session;
	private final UserService userService;
	private final LoginService loginService;
	
	@GetMapping
	public String mypage() {		
		return "/user/mypage";
	}
	
	@GetMapping("/delete")
	@ResponseBody
	public void deleteUser() {
		UserDTO user =(UserDTO)session.getAttribute("user");
		String email = user.getEmail();
		userService.deleteUser(email);
		session.invalidate();
	}
	
	@GetMapping("/kakaounlink")
	public String unlink() {	
		loginService.unlink((String)session.getAttribute("accessToken"));
		session.invalidate();
		return "redirect:/";
	}
	
	@GetMapping("/edit")
	public String editUser() {
		return "/user/mypage";
	}
	
	@PostMapping("/edit")
	@ResponseBody
	public void editUser(UserDTO userdto) {
		userService.editUser(userdto);
		UserDTO user= userService.getUserInfo(userdto.getEmail());
		session.setAttribute("user", user);
	}
	
	@PostMapping("/userDiary")
	@ResponseBody
	public List<UserDiaryDTO> getUserDiary() {
		UserDTO user =(UserDTO)session.getAttribute("user");
		List<UserDiaryDTO> list=userService.getDiary(user.getEmail());
		for(UserDiaryDTO one:list) {
			log.info(one.getContents());
		}
		return userService.getDiary(user.getEmail());
	}
	
	@PostMapping("/likes")
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
