package org.wecancodeit.virtualtreetdd;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ApiController {
	
	@Autowired
	VirtualTreeRepository vTreeRepo;
	
	@Autowired
	BranchRepository branchRepo;
	
	@Autowired
	ClusterRepository clusterRepo;
	
	@Autowired
	BeanRepository beanRepo;
	
	@RequestMapping ("/virtualtrees")
	public Collection<VirtualTree> getVirtualTrees() {
		return (Collection<VirtualTree>) vTreeRepo.findAll();
	}
	
	@RequestMapping ("/virtualtrees/{id}/branches")
	public Collection<Branch> getBranches(@PathVariable(name = "id") Long id) {
		return vTreeRepo.findOne(id).getBranches();

	}
}
