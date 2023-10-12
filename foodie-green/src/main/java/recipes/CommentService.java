package recipes;

import java.util.List;

public interface CommentService {
	void addComment(CommentDTO comment);

	List<CommentDTO> getCommentsByDiaryId(int diary_id);
	
	boolean deleteComment(int id, String loggedInUserNickname);
}
