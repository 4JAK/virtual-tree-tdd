package org.wecancodeit.virtualtreetdd;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Cluster {

	@Id
	@GeneratedValue
	private Long id;
	private String name;
	
	@ManyToOne
	private Branch branch;

	public Cluster(String name, Branch branch) {
		this.name = name;
		this.branch = branch;
	} 
	
	public Cluster() {
		
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Branch getBranch() {
		return branch;
	}

	

}
