package user;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import recipes.DiaryDTO;
import user.model.FindIdReq;
import user.model.LoginReq;

@Service
@RequiredArgsConstructor
public class UserService{

	private final UserMapper usermapper;
	
	public void signin(UserDTO UserDTO) {
		usermapper.signin(UserDTO);
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

	public void editUser(UserDTO userdto) {
		usermapper.editUser(userdto);
	}

	public String findId(FindIdReq findIdReq) {
		return usermapper.findId(findIdReq);
	}

	public String findPw(HashMap<String, String> map) {
		return usermapper.findPw(map);
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

	public int checkPrevNickname(HashMap<String, String> map) {
		return usermapper.checkPrevNickname(map);
	}

	public UserDTO getUserInfo(String email) {
		return usermapper.getUserInfo(email);
	}
	
	

}
