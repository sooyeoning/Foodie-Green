package user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Setter
public class UserDiaryDTO {

	private int id;
	private String title, contents;
	private String writer,writing,recipes;
	private String photo;
	private int likecnt, count;
	
}