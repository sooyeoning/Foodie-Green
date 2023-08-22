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
	public String getWriterbyDiaryId(int diary_id) {
		return sqlSession.selectOne("getWriterbyDiaryId",diary_id);
	}

	@Override
	public int deleteDiary(int diary_id) {
		return sqlSession.delete("deleteDiary", diary_id);
	}
	@Override
	public DiaryDTO getDiaryById(int id) {
		return sqlSession.selectOne("getDiaryById",id);
	}

	@Override
	public int updateDiary(DiaryDTO diary) {
		return sqlSession.update("updateDiary",diary);
	}
	
}
