package recipes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class RecipeController {
	@Autowired
	public RecipeService service;

	@RequestMapping("/recipes")
	public String recipes(Model model) {
		List<RecipesDTO> recipes = service.getAllRecipes();

		model.addAttribute("recipes", recipes);
		return "recipes/recipes";
	}
	@GetMapping("/api/recipes")
	@ResponseBody
	public List<RecipesDTO> getRecipesJson() {
	    return service.getAllRecipes();
	}
	
	@GetMapping("recipesdetail/{id}")
	public String recipesdetail(@PathVariable int id, Model model) {
		RecipesDTO recipes = service.getRecipeById(id);
		System.out.println(recipes); // 로깅
		model.addAttribute("recipes",recipes);
		return "recipes/recipesdetail";
	}
}
