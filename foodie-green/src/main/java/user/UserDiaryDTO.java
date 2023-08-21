package user;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class UserDiaryDTO {

	int id;
	String title, contents;
	String writer,writing,recipes;
	String photo;
	int likecnt, count;
	
	public UserDiaryDTO() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getWriting() {
		return writing;
	}

	public void setWriting(String writing) {
		this.writing = writing;
	}

	public String getRecipes() {
		return recipes;
	}

	public void setRecipes(String recipes) {
		this.recipes = recipes;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public int getLikecnt() {
		return likecnt;
	}

	public void setLikecnt(int likecnt) {
		this.likecnt = likecnt;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public UserDiaryDTO(int id, String title, String contents, String writer, String writing, String recipes, String photo,
			int likecnt, int count) {
		this.id = id;
		this.title = title;
		this.contents = contents;
		this.writer = writer;
		this.writing = writing;
		this.recipes = recipes;
		this.photo = photo;
		this.likecnt = likecnt;
		this.count = count;
	}
	

}