package recipes;

import java.util.List;

public interface CommentDAO {

	void insertComment(CommentDTO comment);

	List<CommentDTO> getCommentsByDiaryId(int diary_id);

	int deleteComment(int id, String writer);
}
