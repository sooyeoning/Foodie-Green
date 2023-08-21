package recipes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DiaryServiceImpl implements DiaryService {
	@Autowired
	DiaryDAO dao;
	
	@Autowired
	LikesDAO ldao;
	
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

	@Override
	public DiaryDTO getDiaryById(int id) {
		return dao.getDiaryById(id);
	}

	@Override
	public boolean toggleLike(int user_id, int diary_id) {
	    LikesDTO likes = new LikesDTO();
	    likes.setUser_id(user_id);
	    likes.setDiary_id(diary_id);
	    
	    int exists = ldao.checkLike(likes);
	    if (exists > 0) {
	        ldao.removeLike(likes);
	        return false; // 좋아요 취소
	    } else {
	        ldao.addLike(likes);
	        return true; // 좋아요 선택
	    }
	}

	
	
}
