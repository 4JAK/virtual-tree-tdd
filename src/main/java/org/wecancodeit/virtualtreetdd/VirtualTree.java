package org.wecancodeit.virtualtreetdd;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class VirtualTree {

	@Id
	@GeneratedValue
	private Long id;
	public String name;
	// growth is increased per correct question answered
	private int growth;
	private boolean completedTree;
	
	
	//branches mapping
	@OneToMany(mappedBy = "virtualTree")
	private Collection<Branch> branches;

	public VirtualTree(String name) {
		this.name = name;
		this.growth = 0;
		this.completedTree = false;
	}

	protected VirtualTree() {

	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Collection<Branch> getBranches() {
		return branches;
	}

	public int getGrowth() {
		return growth;
	}

	public void water() {
		this.growth += 5;
	}

	public boolean isCompletedTree() {
		return completedTree;
	}

	public void setCompletedTree() {
		this.completedTree = true;
	}
	
	public boolean checkCompletedBranches() {
		for(Branch branch : branches) {
			if(!branch.isBranchCompleted()) {
				return false;
			}
		}
		return true;
	}
	
}
