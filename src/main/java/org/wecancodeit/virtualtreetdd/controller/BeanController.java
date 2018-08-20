package org.wecancodeit.virtualtreetdd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.wecancodeit.virtualtreetdd.repository.BeanRepository;

@Controller
public class BeanController {
	@Autowired private BeanRepository beanRepo;
	
	@RequestMapping(value = "/beans")
	public String getBeans(Model model) {
		model.addAttribute("beans", beanRepo.findAll());
		return "beans";
	}
	
	@RequestMapping(value = "/bean/{id}")
	public String getBean(@PathVariable(name = "id") Long id, Model model) {
		model.addAttribute("bean", beanRepo.findOne(id));
		return "bean";
	}
}
