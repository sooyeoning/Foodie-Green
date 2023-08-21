package recipes;

import java.util.List;

public interface DiaryDAO {
	void saveDiary(DiaryDTO dto);
	List<DiaryDTO> getRecentDiaries();
	List<DiaryDTO> getPopularDiaries();
	DiaryDTO getDiaryById(int id);
	
}
