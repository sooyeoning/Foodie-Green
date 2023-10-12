package recipes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {
	@Autowired
	CommentDAO dao;

	@Override
	public void addComment(CommentDTO comment) {
		dao.insertComment(comment);
	}

	@Override
	public List<CommentDTO> getCommentsByDiaryId(int diary_id) {
		return dao.getCommentsByDiaryId(diary_id);
	}

	@Override
	public boolean deleteComment(int id, String loggedInUserNickname) {
		return false;
	}

	
	
	
}
