package user;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import recipes.DiaryDTO;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserMapper usermapper;

	@Override
	public void signin(UserDTO UserDTO) {
		usermapper.signin(UserDTO);
	}

	@Override
	public int checkEmail(String email) {
		return usermapper.checkEmail(email);
	}

	@Override
	public UserDTO login_kakao(String email) {
		return usermapper.login_kakao(email);
	}

	@Override
	public int checkNickname(String nickname) {
		return usermapper.checkNickname(nickname);
	}

	@Override
	public void editUser(UserDTO userdto) {
		usermapper.editUser(userdto);
	}

	@Override
	public String findId(HashMap<String, String> map) {
		return usermapper.findId(map);
	}

	@Override
	public String findPw(HashMap<String, String> map) {
		return usermapper.findPw(map);
	}

	@Override
	public UserDTO login(HashMap<String, String> map) {
		return usermapper.login(map);
	}

	@Override
	public void deleteUser(String email) {
		usermapper.deleteUser(email);
	}

	@Override
	public  List<UserDiaryDTO> getDiary(String email) {
		return usermapper.getDiary(email);
	}

	@Override
	public List<Integer> getUserLikes(int user_id) {
		return usermapper.getUserLikes(user_id);
	}

	@Override
	public DiaryDTO getLikedDiaryInfo(int id) {
		return usermapper.getLikedDiaryInfo(id);
	}

	@Override
	public int checkPrevNickname(HashMap<String, String> map) {
		return usermapper.checkPrevNickname(map);
	}

	@Override
	public UserDTO getUserInfo(String email) {
		return usermapper.getUserInfo(email);
	}
	
	

}
