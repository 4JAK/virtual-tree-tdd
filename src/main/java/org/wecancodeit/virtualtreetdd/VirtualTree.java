package org.wecancodeit.virtualtreetdd;

import java.util.Collection;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class VirtualTree {

  @Id @GeneratedValue private Long id;
  public String name;
  // growth is increased per correct question answered
  private int growth;
  private boolean completedTree;

  @ElementCollection private Collection<String> treeImages;

  // branches mapping
  @OneToMany(mappedBy = "virtualTree")
  private Collection<Branch> branches;

  public VirtualTree(String name, Collection<String> treeImages) {
    this.name = name;
    this.growth = 0;
    this.completedTree = false;
    this.treeImages = treeImages;
  }

  protected VirtualTree() {}

  public Collection<String> getTreeImages() {
    return treeImages;
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

  public void setBranches(Collection<Branch> branches) {
    this.branches = branches;
  }

  public boolean isAllBranchesCompleted() {
    for (Branch branch : branches) {
      if (!branch.isBranchCompleted()) {
        this.completedTree = false;
        return false;
      }
    }
    this.completedTree = true;
    return true;
  }
}
