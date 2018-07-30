package org.wecancodeit.virtualtreetdd;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class VirtualTree {

  @Id @GeneratedValue private Long id;
  public String name;
  // growth is increased per correct question answered
  private int growth = 0;

  public VirtualTree(String name) {
    this.name = name;
  }

  protected VirtualTree() {}

  public Long getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public int getGrowth() {
    return growth;
  }

  public void water() {
    this.growth += 5;
  }
}
