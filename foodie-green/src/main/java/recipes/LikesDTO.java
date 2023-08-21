package recipes;

public class LikesDTO {
	int id;
	int user_id;
	int diary_id;

	public LikesDTO() {

	}

	public LikesDTO(int id, int user_id, int diary_id) {
		super();
		this.id = id;
		this.user_id = user_id;
		this.diary_id = diary_id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public int getDiary_id() {
		return diary_id;
	}

	public void setDiary_id(int diary_id) {
		this.diary_id = diary_id;
	}

}
