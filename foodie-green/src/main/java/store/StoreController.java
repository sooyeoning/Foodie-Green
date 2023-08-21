package store;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class StoreController {

	@Autowired
	StoreService service;
	
	@RequestMapping("/store")
	public String store(Model model) {
		
		List<StoreDTO> getStorelist = service.getStorelist();
		model.addAttribute("getStorelist",getStorelist);
		return "store/storelist";
	}
	
	@GetMapping("/detail")
	public ModelAndView getDetail(int id) {
		StoreDTO dto =service.getDetail(id);
		ModelAndView mv = new ModelAndView();
		mv.addObject("getDetail",dto);
		mv.setViewName("/store/detail");
		return mv;
	}
}
