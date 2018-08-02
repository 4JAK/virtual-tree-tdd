package org.wecancodeit.virtualtreetdd;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BranchController {

  @Autowired private BranchRepository branchRepo;

  @RequestMapping(value = "/branches")
  public String getBranches(Model model) {
    model.addAttribute("branches", branchRepo.findAll());
    return "branches";
  }

  @RequestMapping(value = "/branch/{id}")
  public String getBranch(@PathVariable(name = "id") Long id, Model model) {
    model.addAttribute("branch", branchRepo.findOne(id));
    return "branch";
  }
}
