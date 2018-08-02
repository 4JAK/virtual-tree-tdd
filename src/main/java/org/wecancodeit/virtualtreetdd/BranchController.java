package org.wecancodeit.virtualtreetdd;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BranchController {

	@Autowired
	private BranchRepository branchRepo;
	
	@Autowired
	private VirtualTreeRepository vTreeRepo;
	
	
	
	@RequestMapping (value = "branch")
	public String branch(Model model) {
		model.addAttribute("branch", branchRepo.findAll());
		return "branch";
	}

	@RequestMapping (value = "branches")
	public String branches(Model model) {
		model.addAttribute("branches", vTreeRepo.findOne(1L).getBranches());
		return "branches";
	}

}
