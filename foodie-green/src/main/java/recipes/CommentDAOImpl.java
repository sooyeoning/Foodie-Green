package recipes;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CommentDAOImpl implements CommentDAO {

	@Autowired
	SqlSession sqlSession;

	@Override
	public void insertComment(CommentDTO comment) {
		sqlSession.insert("insertComment", comment);

	}

	@Override
	public List<CommentDTO> getCommentsByDiaryId(int diary_id) {
		return sqlSession.selectList("getCommentsByDiaryId", diary_id);
	}

	@Override
	public int deleteComment(int id, String writer) {
		Map<String, Object> params = new HashMap<>();
		params.put("id", id);
		params.put("writer", writer);
		return sqlSession.delete("deleteComment", params);
	}

}
