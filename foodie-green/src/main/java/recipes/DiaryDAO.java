package recipes;

import java.util.List;

public interface DiaryDAO {
	void saveDiary(DiaryDTO dto);
	List<DiaryDTO> getRecentDiaries();
	List<DiaryDTO> getPopularDiaries();
	String getWriterbyDiaryId(int diary_id);
	int deleteDiary(int diary_id);
	DiaryDTO getDiaryById(int id);
	int updateDiary(DiaryDTO diary);
}
