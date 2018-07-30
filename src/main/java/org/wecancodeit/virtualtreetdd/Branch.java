package org.wecancodeit.virtualtreetdd;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Branch {
	
	@Id
	@GeneratedValue
	private Long id;
	private String name;
	
	@ManyToOne
	private VirtualTree virtualTree;
	
	public Branch (String name, VirtualTree virtualTree) {
		this.name = name;
		this.virtualTree = virtualTree;
	}
	
	public Branch() {
		
	}

	public Long getId() {
		return id;
	}
	
	public String getName() {
		
		return name;
	}

	public VirtualTree getVirtualTree() {
		
		return virtualTree;
	}
	
}
