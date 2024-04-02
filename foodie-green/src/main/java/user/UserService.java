package user;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import recipes.DiaryDTO;
import user.dto.UserDTO;
import user.dto.UserDiaryDTO;
import user.model.FindIdReq;
import user.model.FindPwReq;
import user.model.LoginReq;
import user.model.NicknameDuplicateReq;
import user.model.SignInReq;

@Service
@RequiredArgsConstructor
public class UserService{

	private final UserMapper usermapper;
	
	public void signin(SignInReq req) {
		usermapper.signin(req);
	}

	public int checkEmail(String email) {
		return usermapper.checkEmail(email);
	}

	public UserDTO login_kakao(String email) {
		return usermapper.login_kakao(email);
	}

	public int checkNickname(String nickname) {
		return usermapper.checkNickname(nickname);
	}
	
	public boolean checkPw(String pw, String checkPw) {
		boolean result = false;
		if (pw.equals(checkPw)) {
			result = true;
		}
		return result;
	}

	public void editUser(UserDTO userdto) {
		usermapper.editUser(userdto);
	}

	public String findId(FindIdReq findIdReq) {
		return usermapper.findId(findIdReq);
	}

	public String findPw(FindPwReq findPwReq) {
		return usermapper.findPw(findPwReq);
	}

	public UserDTO login(LoginReq loginReq) {
		return usermapper.login(loginReq);
	}

	public void deleteUser(String email) {
		usermapper.deleteUser(email);
	}

	public List<UserDiaryDTO> getDiary(String email) {
		return usermapper.getDiary(email);
	}

	public List<Integer> getUserLikes(int user_id) {
		return usermapper.getUserLikes(user_id);
	}

	public DiaryDTO getLikedDiaryInfo(int id) {
		return usermapper.getLikedDiaryInfo(id);
	}

	public int checkPrevNickname(NicknameDuplicateReq req) {
		return usermapper.checkPrevNickname(req);
	}

	public UserDTO getUserInfo(String email) {
		return usermapper.getUserInfo(email);
	}
	
	

}
