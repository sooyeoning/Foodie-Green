package recipes;

import java.util.List;

public interface RecipeDAO {
	List<RecipesDTO> getAllRecipes();
	RecipesDTO getRecipeById(int id);
}
