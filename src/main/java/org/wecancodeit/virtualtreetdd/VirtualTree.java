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
	private int growth = 0;
	
	//branches mapping
	@OneToMany(mappedBy = "virtualTree")
	private Collection<Branch> branches;

	public VirtualTree(String name) {
		this.name = name;
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
}
