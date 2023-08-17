package recipes;

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
	
	
}
