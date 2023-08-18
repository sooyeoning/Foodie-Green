package recipes;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class DiaryDTO {

	int id;
	int diaryid;
	String title, contents;
	String writer,writing,recipes;
	String photo;
	MultipartFile file;
	
	public DiaryDTO() {

	}
	
	public DiaryDTO(int id, int diaryid, String title, String contents, String writer, String writing, String photo,
			String recipes) {
		super();
		this.id = id;
		this.diaryid = diaryid;
		this.title = title;
		this.contents = contents;
		this.writer = writer;
		this.writing = writing;
		this.photo = photo;
		this.recipes = recipes;
	}
	
	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getDiaryid() {
		return diaryid;
	}
	public void setDiaryid(int diaryid) {
		this.diaryid = diaryid;
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
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public String getRecipes() {
		return recipes;
	}
	public void setRecipes(String recipes) {
		this.recipes = recipes;
	}


}