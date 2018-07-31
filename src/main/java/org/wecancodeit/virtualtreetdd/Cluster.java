package org.wecancodeit.virtualtreetdd;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Cluster {

  @Id @GeneratedValue private Long id;
  private String name;

  @ManyToOne private Branch branch;

  @OneToMany(mappedBy = "cluster")
  private Collection<Bean> beans;

  public Cluster(String name, Branch branch) {
    this.name = name;
    this.branch = branch;
  }

  public Cluster() {}

  public Collection<Bean> getBeans() {
    return beans;
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
