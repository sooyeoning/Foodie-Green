package user;

public interface UserService {
	public void signin(UserDTO UserDTO);
	public UserDTO login(String email, String pw);
	public String findId(String name, String phone);
	public String findPw(String email, String phone);
	public int checkEmail(String email);

}
