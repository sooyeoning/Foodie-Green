package recipes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DiaryServiceImpl implements DiaryService {
	@Autowired
	DiaryDAO dao;

	@Override
	public void saveDiary(DiaryDTO dto) {
		dao.saveDiary(dto);
	}

	@Override
	public List<DiaryDTO> getRecentDiaries() {
		return dao.getRecentDiaries();
	}

	@Override
	public List<DiaryDTO> getPopularDiaries() {
		return dao.getPopularDiaries();
	}
	
	
}
