package recipes;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RecipeDAOImpl implements RecipeDAO {
	@Autowired
	public SqlSession sqlSession;

	@Override
	public List<RecipesDTO> getAllRecipes() {
		return sqlSession.selectList("getAllRecipes");
	}

	@Override
	public RecipesDTO getRecipeById(int id) {
		return sqlSession.selectOne("getRecipeById");
	}


}
