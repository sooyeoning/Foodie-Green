package user;

import java.util.HashMap;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper // 매퍼 파일이야, @MapperScan 필요
@Repository // 객체 생성, @ComponentScan 필요
public interface UserMapper {
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
