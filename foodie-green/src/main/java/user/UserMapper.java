package user;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import recipes.DiaryDTO;
import user.dto.UserDTO;
import user.dto.UserDiaryDTO;
import user.model.FindIdReq;
import user.model.FindPwReq;
import user.model.LoginReq;
import user.model.NicknameDuplicateReq;
import user.model.SignInReq;

@Mapper // 매퍼 파일이야, @MapperScan 필요
@Repository // 객체 생성, @ComponentScan 필요
public interface UserMapper {
	public void signin(SignInReq req);
	public UserDTO login(LoginReq loginReq);
	public UserDTO login_kakao(String email);

	public String findId(FindIdReq findIdReq);
	public String findPw(FindPwReq findPwReq);
	public int checkEmail(String email);
	public int checkNickname(String nickname);
	public int checkPrevNickname(NicknameDuplicateReq req);

	public void editUser(UserDTO userdto);
	public UserDTO getUserInfo(String email);
	public void deleteUser(String email);
	
	public List<UserDiaryDTO> getDiary(String email);
	public List<Integer> getUserLikes(int user_id);
	public DiaryDTO getLikedDiaryInfo(int id);
}
