package user.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SignInReq {
	
	@NotBlank(message = "이름은 필수 입력 항목입니다.")
	private String name;
	
	@NotBlank(message = "닉네임은 필수 입력 항목입니다.")
	private String nickname;
	
	@Email
	@NotBlank(message = "이메일은 필수 입력 항목입니다.")
	private String email; 
	
	@NotBlank
	@Pattern(regexp = "^(?=.*[a-zA-Z])(?=.*[!@#$%^*+=-])(?=.*[0-9]).{6,15}", message = "영문+숫자+특수문자로 이루어진 6~15자리 비밀번호를 입력해주세요.")
	private String pw;
	
	@NotBlank(message = "비밀번호 중복 확인은 필수입니다.")
	private String checkpw;
	
	@NotBlank(message = "핸드폰 번호는 필수 입력 항목입니다.")
	@Pattern(regexp = "^01\\d-?\\d{3,4}-?\\d{4}", message = "01x-xxxx-xxxx 형식으로 입력해주세요")
	private String phone;
	
	private String logintype = "normal";
	
	private String kakaoId;

}
