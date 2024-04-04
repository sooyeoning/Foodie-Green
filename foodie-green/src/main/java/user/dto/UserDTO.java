package user.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
	private String name;
	private String nickname;
	private String email; 
	private String pw;
	private String phone;
	private int id;
	private String logintype;
	
}
