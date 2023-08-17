package user;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper // 매퍼 파일이야, @MapperScan 필요
@Repository // 객체 생성, @ComponentScan 필요
public interface UserMapper {
	public void signin(UserDTO UserDTO);
	public UserDTO login(String email, String pw);
	public String findId(String name, String phone);
	public String findPw(String email, String phone);
	public int checkEmail(String email);
}
