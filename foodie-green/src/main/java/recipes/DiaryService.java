package recipes;

import java.util.List;

public interface DiaryService {
	public void saveDiary(DiaryDTO dto);
	List<DiaryDTO> getRecentDiaries();
	List<DiaryDTO> getPopularDiaries();
}
