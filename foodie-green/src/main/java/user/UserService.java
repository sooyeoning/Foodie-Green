package user;

import java.util.HashMap;
import java.util.List;

import recipes.DiaryDTO;


public interface UserService {
	public void signin(UserDTO UserDTO);
	public UserDTO login(HashMap<String, String> map);
	public UserDTO login_kakao(String email);

	public String findId(HashMap<String, String> map);
	public String findPw(HashMap<String, String> map);
	public int checkEmail(String email);
	public int checkNickname(String nickname);
	public int checkPrevNickname(HashMap<String, String> map);

	public void editUser(UserDTO userdto);
	public UserDTO getUserInfo(String email);

	public void deleteUser(String email);

	public List<UserDiaryDTO> getDiary(String email);
	public List<Integer> getUserLikes(int user_id);
	public DiaryDTO getLikedDiaryInfo(int id);
}
