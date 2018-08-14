package org.wecancodeit.virtualtreetdd;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Branch {
	
	@Id
	@GeneratedValue
	private Long id;
	private String name;
	private boolean branchCompleted;
	
	@JsonIgnore
	@ManyToOne
	private VirtualTree virtualTree;
	
	@JsonIgnore
	@OneToMany(mappedBy = "branch")
	private Collection<Cluster> clusters;
	
	public Branch (String name, VirtualTree virtualTree) {
		this.name = name;
		this.virtualTree = virtualTree;
		this.branchCompleted = false;
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

	public Collection<Cluster> getClusters() {
		
		return clusters;
	}

	public boolean isBranchCompleted() {
		return branchCompleted;
	}

	public void setBranchCompleted() {
		this.branchCompleted = true;
	}
	
	public boolean checkCompletedClusters() {
		for(Cluster cluster : clusters) {
			if(!cluster.isClusterCompleted()) {
				return false;
			}
		}
		return true;
	}
	
	public Cluster getNextCluster( Long currentClusterId) {
		Cluster cluster = null;
		for( Cluster currentCluster: clusters) {
			if(currentCluster.getId()==currentClusterId+1L) {
				cluster=currentCluster;
			}
			
		}
		return cluster;
	}
	
	
}
