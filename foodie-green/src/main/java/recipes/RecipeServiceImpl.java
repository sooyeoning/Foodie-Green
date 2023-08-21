package recipes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RecipeServiceImpl implements RecipeService {
	@Autowired
	public RecipeDAO dao;

	@Override
	public List<RecipesDTO> getAllRecipes() {
		return dao.getAllRecipes();
	}

	@Override
	public RecipesDTO getRecipeById(int id) {
		return dao.getRecipeById(id);
	}

}
