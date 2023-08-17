package recipes;

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
}
