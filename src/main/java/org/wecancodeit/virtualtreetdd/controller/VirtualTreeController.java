package org.wecancodeit.virtualtreetdd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.wecancodeit.virtualtreetdd.repository.VirtualTreeRepository;

@Controller // Controller for virtual tree
public class VirtualTreeController {
		
	@Autowired private VirtualTreeRepository vTreeRepo;
	
	@RequestMapping(value = "/")
	public String index() {
		return "index";
	}
	
	@RequestMapping(value = "/home")
	public String home(Model model) {
		model.addAttribute("virtualTree", vTreeRepo.findAll());
		return "home";
	}
	@RequestMapping(value = "/about")
	public String about() {
		return "about";
	}
}
