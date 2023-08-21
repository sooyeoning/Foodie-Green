package recipes;

import java.util.List;

public interface DiaryService {
	public void saveDiary(DiaryDTO dto);
	List<DiaryDTO> getRecentDiaries();
	List<DiaryDTO> getPopularDiaries();
	DiaryDTO getDiaryById(int id);
	boolean toggleLike(int userId, int diaryId);

}
