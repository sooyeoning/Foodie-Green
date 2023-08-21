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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import jakarta.servlet.http.HttpSession;
import user.UserDTO;

@Controller
public class DiaryController {

	@Autowired
	DiaryService ds;

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
	public ResponseEntity<String> saveDiary(@RequestParam("title") String title, @RequestParam("contents") String contents,
			@RequestParam("recipes") String recipes,
			@RequestParam("photo") MultipartFile file,HttpSession session) {
	    UserDTO userdto = (UserDTO) session.getAttribute("user"); // 세션에서 로그인한 사용자 정보 가져오기
	    if (userdto == null) {
	        return new ResponseEntity<>("Not logged in", HttpStatus.UNAUTHORIZED); // 로그인하지 않은 경우 오류 반환
	    }

	    String writer = userdto.getNickname(); // UserDTO에서 닉네임 가져오기
		
		DiaryDTO diary = new DiaryDTO();
	    diary.setTitle(title);
	    diary.setContents(contents);
	    diary.setRecipes(recipes);
	    diary.setWriter(writer);
	    

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
	        String uploadDir = "/Users/shin-yeongyun/git/Foodie-Green2/foodie-green/src/main/resources/static/img/recipes";
	        		// "c:/kdt/upload/";
	                // "/Users/shin-yeongyun/git/Foodie-Green2/foodie-green/src/main/resources/static/img/recipes";
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

	@GetMapping("diarydetail/{id}")
	public String diarydetail(@PathVariable int id, Model model) {
		DiaryDTO diary = ds.getDiaryById(id);
		model.addAttribute("diary",diary);
		return "recipes/diarydetail";
	}

    @PostMapping("/toggleLike/{diary_id}")
    public ResponseEntity<String> toggleLike(@PathVariable int diary_id, HttpSession session) {
        UserDTO userDTO = (UserDTO) session.getAttribute("user");
        if (userDTO == null) {
            return new ResponseEntity<>("You must log in first", HttpStatus.UNAUTHORIZED);
        }
        ds.toggleLike(userDTO.getId(), diary_id);
        return new ResponseEntity<>("Success", HttpStatus.OK);
    }
  


}
