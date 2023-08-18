package recipes;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

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
	public String diary(Model model) {
		List<DiaryDTO> recentDiaries = ds.getRecentDiaries();
		List<DiaryDTO> popularDiaries = ds.getPopularDiaries();
		model.addAttribute("recentDiaries", recentDiaries);
		model.addAttribute("popularDiaries", popularDiaries);
		return "recipes/diary";
	}


	@GetMapping("/diarywrite")
	public String diarywrite() {
	    return "recipes/diarywrite"; // diarywrite.jsp 페이지를 반환
	}

	@PostMapping("/diarywrite")
	public ResponseEntity<String> saveDiary(@RequestParam("title") String title, @RequestParam("contents") String contents,@RequestParam("recipes") String recipes, @RequestParam("photo") MultipartFile file) {
	    DiaryDTO diary = new DiaryDTO();
	    diary.setTitle(title);
	    diary.setContents(contents);
	    diary.setRecipes(recipes);

	    // 이미지 파일 처리를 위한 로직 (예: 저장 경로 설정)
	    String photo = saveImage(file); // 이미지 저장 로직 (세부 구현은 필요에 따라)
	    diary.setPhoto(photo); // 저장된 파일 경로를 DTO에 설정

	    // 나머지 로직
	    ds.saveDiary(diary); // 예시
	    return new ResponseEntity<>("Success", HttpStatus.OK);
	}

	private String saveImage(MultipartFile file) {
	    try {
	        // 저장할 디렉터리 경로
	        String uploadDir = "/Users/shin-yeongyun/git/Foodie-Green/foodie-green/src/main/resources/static/img/recipes";
	        
	        // 파일의 원래 이름
	        String originalFileName = file.getOriginalFilename();

	        // 저장될 파일 경로
	        String filePath = uploadDir + File.separator + originalFileName;

	        // 파일 객체 생성
	        File destFile = new File(filePath);

	        // MultipartFile의 내용을 파일에 기록
	        file.transferTo(destFile);

	        // 저장된 파일의 경로 반환
	        return "/img/recipes/"+originalFileName;
	    } catch (IOException e) {
	        // 파일 저장 중 오류 발생 시 처리 로직
	        e.printStackTrace();
	        return null;
	    }
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
