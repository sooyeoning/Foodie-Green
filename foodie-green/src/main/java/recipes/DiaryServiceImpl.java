package recipes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

	@Transactional
	@Override
	public boolean deleteDiary(int diary_id, String loggedInUserNickname) {
		String writer = dao.getWriterbyDiaryId(diary_id);
		if(writer.equals(loggedInUserNickname)) {
			return dao.deleteDiary(diary_id) > 0;
		}
		return false;
	}

	@Override
	public DiaryDTO getDiaryById(int id) {
		return dao.getDiaryById(id);
	}
	@Override
	public int updateDiary(DiaryDTO diary) {
		return dao.updateDiary(diary);
	}

	
	
}
