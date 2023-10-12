package recipes;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.servlet.http.HttpSession;

@Controller
public class CommentController {

	@Autowired
	CommentService service;
	
	@ResponseBody
	@RequestMapping(value="/commentwrite", method=RequestMethod.POST)
	public Map<String, String> addComment(CommentDTO commentDTO) {
	    Map<String, String> resultMap = new HashMap<>();

	    try {
	        service.addComment(commentDTO);
	        resultMap.put("result", "Success");
	    } catch (Exception e) {
	        e.printStackTrace();
	        resultMap.put("result", "Failure");
	    }

	    return resultMap;
	}

	@GetMapping("/list")
	public List<CommentDTO> listAllComments(@RequestParam int diary_id){
		return service.getCommentsByDiaryId(diary_id);
	}
	
	@DeleteMapping("/deleteComment/{id}")
	public ResponseEntity<String> deleteComment(@PathVariable int id, HttpSession session) {
		String loggedInUserNickname = (String) session.getAttribute("nickname");
		int affectedRows = service.deleteComment(id, loggedInUserNickname);

		if (affectedRows == 1) {
			return ResponseEntity.ok("Success");
		} else {
			return ResponseEntity.status(400).body("Failure");
		}
	}
}
