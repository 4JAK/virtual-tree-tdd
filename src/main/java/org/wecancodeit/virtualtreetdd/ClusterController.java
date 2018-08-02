package org.wecancodeit.virtualtreetdd;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ClusterController {
  @Autowired private ClusterRepository clusterRepo;

  @RequestMapping(value = "/clusters")
  public String getClusters(Model model) {
    model.addAttribute("clusters", clusterRepo.findAll());
    return "clusters";
  }

  @RequestMapping(value = "/cluster/{id}")
  public String getCluster(@PathVariable(name = "id") Long id, Model model) {
    model.addAttribute("cluster", clusterRepo.findOne(id));
    return "cluster";
  }
}
