package user;

import java.util.HashMap;


public interface UserService {
	public void signin(UserDTO UserDTO);
	public UserDTO login(HashMap<String, String> map);
	public UserDTO login_kakao(String email);

	public String findId(HashMap<String, String> map);
	public String findPw(HashMap<String, String> map);
	public int checkEmail(String email);
	public int checkNickname(String nickname);
	public void editUser(UserDTO userdto);
	public void deleteUser(String email);

}
