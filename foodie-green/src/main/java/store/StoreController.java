package store;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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
}
