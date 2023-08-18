package home;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
	
	@Autowired
	HomeService homeservice;
	

	@RequestMapping("/")
	public String index() {
		return "/home/index"; 
	}

	
}
