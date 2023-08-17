package recipes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RecipesController {

	@Autowired
	DiaryService ds;

	@GetMapping("/recipes")
	public String recipes() {
		return "recipes/recipes";
	}

	@GetMapping("/")
	public String main() {
		return "main";
	}

	@GetMapping("fgrecipes")
	public String fgrecipes() {
		return "recipes/fgrecipes";
	}

	@GetMapping("diary")
	public String diary() {
		return "recipes/diary";
	}

	@GetMapping("diarywrite")
	public String diarywrite() {
	    return "recipes/diarywrite";
	}

	@PostMapping("diarywrite")
	public ModelAndView saveDiary(@RequestBody DiaryDTO diary) {
	    ds.saveDiary(diary);

	    ModelAndView mv = new ModelAndView();
	    mv.addObject("diary", diary);
	    mv.setViewName("recipes/diarydetail");
	    return mv;
	}


	@GetMapping("recipeswrite")
	public String recipeswrite() {
		return "recipes/recipeswrite";
	}

	@GetMapping("recipesdetail")
	public String recipesdetail() {
		return "recipes/recipesdetail";
	}

	@GetMapping("diarydetail")
	public String diarydetail() {
		return "recipes/diarydetail";
	}

}
