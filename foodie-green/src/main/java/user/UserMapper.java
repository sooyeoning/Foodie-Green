package user;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import recipes.DiaryDTO;
import user.model.FindIdReq;
import user.model.LoginReq;

@Mapper // 매퍼 파일이야, @MapperScan 필요
@Repository // 객체 생성, @ComponentScan 필요
public interface UserMapper {
	public void signin(UserDTO UserDTO);
	public UserDTO login(LoginReq loginReq);
	public UserDTO login_kakao(String email);

	public String findId(FindIdReq findIdReq);
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
