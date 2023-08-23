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
	@RequestMapping("/faq/01")
	public String faq01() {
		return "/home/faqs/faq01"; 
	}
	@RequestMapping("/faq/02")
	public String faq02() {
		return "/home/faqs/faq02"; 
	}
	@RequestMapping("/faq/03")
	public String faq03() {
		return "/home/faqs/faq03"; 
	}
	@RequestMapping("/faq/04")
	public String faq04() {
		return "/home/faqs/faq04"; 
	}
	@RequestMapping("/faq/05")
	public String faq05() {
		return "/home/faqs/faq05"; 
	}


	
}
