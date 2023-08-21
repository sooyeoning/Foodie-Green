package store;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class StoreDAOImpl implements StoreDAO {

	@Autowired
	public SqlSession sqlSession;
	
	@Override
	public List<StoreDTO> getStorelist() {
		return sqlSession.selectList("getStorelist");
	}

	@Override
	public StoreDTO getDetail(int id) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("getDetail",id);
	}

}
