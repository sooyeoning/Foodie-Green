package recipes;

import java.util.List;

public interface RecipeService {
	List<RecipesDTO> getAllRecipes();

	RecipesDTO getRecipeById(int id);
}
