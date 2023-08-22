package recipes;

import java.util.List;

public interface DiaryService {
	public void saveDiary(DiaryDTO dto);
	List<DiaryDTO> getRecentDiaries();
	List<DiaryDTO> getPopularDiaries();
	boolean toggleLike(int userId, int diaryId);
	boolean deleteDiary(int diary_id, String loggedInUserNickname);
	DiaryDTO getDiaryById(int id);
	int updateDiary(DiaryDTO diary);
}
