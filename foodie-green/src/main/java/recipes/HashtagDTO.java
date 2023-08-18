package recipes;

import org.springframework.stereotype.Component;

@Component
public class HashtagDTO {
	int id;
	int diary_id;
	String hashtag;

	public HashtagDTO() {

	}

	public HashtagDTO(int id, int diary_id, String hashtag) {
		super();
		this.id = id;
		this.diary_id = diary_id;
		this.hashtag = hashtag;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getDiary_id() {
		return diary_id;
	}

	public void setDiary_id(int diary_id) {
		this.diary_id = diary_id;
	}

	public String getHashtag() {
		return hashtag;
	}

	public void setHashtag(String hashtag) {
		this.hashtag = hashtag;
	}

}
