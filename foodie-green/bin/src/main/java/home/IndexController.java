package home;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
	
	@Autowired
	HomeService service;
	
	@RequestMapping("/main")
	public String Main() {
		return "/home/body"; 
	}
	

	
}
