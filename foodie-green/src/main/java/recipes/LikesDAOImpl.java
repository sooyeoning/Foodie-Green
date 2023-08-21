package recipes;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class LikesDAOImpl implements LikesDAO {

    @Autowired
    private SqlSession sqlSession;

    @Override
    public void addLike(LikesDTO likes) {
        sqlSession.insert("addLike", likes);
    }

    @Override
    public void removeLike(LikesDTO likes) {
        sqlSession.delete("removeLike", likes);
    }

    @Override
    public int checkLike(LikesDTO likes) {
        return sqlSession.selectOne("checkLike", likes);
    }
}
