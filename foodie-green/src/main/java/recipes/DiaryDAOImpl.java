package recipes;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DiaryDAOImpl implements DiaryDAO {

	@Autowired
	public SqlSession sqlSession;

	@Override
	public void saveDiary(DiaryDTO dto) {
		sqlSession.insert("saveDiary", dto);
	}

	@Override
	public List<DiaryDTO> getRecentDiaries() {
		return sqlSession.selectList("getRecentDiaries");
	}

	@Override
	public List<DiaryDTO> getPopularDiaries() {
		return sqlSession.selectList("getPopularDiaries");
	}

	@Override
	public DiaryDTO getDiaryById(int id) {
		return sqlSession.selectOne("getDiaryById",id);
	}
	
}
