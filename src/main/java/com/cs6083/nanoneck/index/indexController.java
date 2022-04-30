package com.cs6083.nanoneck.index;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class indexController {
	@RequestMapping({"/","/indx"})
	public String toIndex(Model model){
		model.addAttribute("msg", "hello,shiro");
		return "views/index";
	}
}
