package home;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
	
	@Autowired
	HomeService homeService;
	

	@RequestMapping("/")
	public String index() {
		return "/index"; 
	}
	
	@RequestMapping("/vision")
	public String vision() {
		return "/home/vision"; 
	}
	
	@RequestMapping("/faq")
	public String faq() {
		return "/home/faq"; 
	}


	
}
