package user.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class GetKakaoUserInfoRes {
	private String nickname;
	private String email;
}
