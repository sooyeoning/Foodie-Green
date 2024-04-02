package user.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class FindPwReq {
	
	@NotBlank(message = "회원가입시 입력한 이메일 주소를 입력해주세요.")
	@Email(message = "올바른 형식의 이메일 주소를 입력해주세요.")
	private String email;
	
	@NotBlank(message = "휴대폰 번호를 입력해주세요.")
	private String phone;
	
	@NotBlank(message = "입력하신 이메일 주소로 전달된 인증번호를 입력해주세요.")
	private String inputKey;
	
	//인증번호 전달 
	private boolean hasSentEmailAuth;
	
	//인증번호 확인
	private boolean hasCheckedEmailAuth;
	
	
}
