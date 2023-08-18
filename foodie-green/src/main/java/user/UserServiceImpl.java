package user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserMapper usermapper;

	@Override
	public void signin(UserDTO UserDTO) {
		usermapper.signin(UserDTO);
	}

	@Override
	public UserDTO login(String email, String pw) {
		return usermapper.login(email, pw);
	}

	@Override
	public String findId(String name, String phone) {
		return usermapper.findId(name, phone);
	}

	@Override
	public String findPw(String email, String phone) {
		return usermapper.findPw(email, phone);
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
	
	

}
