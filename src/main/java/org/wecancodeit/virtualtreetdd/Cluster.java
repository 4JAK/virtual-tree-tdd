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
  private boolean clusterCompleted;

  // a collection of questions
  @OneToMany(mappedBy = "cluster")
  private Collection<Bean> beans;

  /**
   * @param name | String
   * @param branch - Branch of which the cluster is owned by | Branch
   */
  public Cluster(String name, Branch branch) {
    this.name = name;
    this.branch = branch;
    this.clusterCompleted = false;
  }

  public Bean getBean(int questionNum) {
    Bean correctBean = null;
    for (Bean bean : beans) {
      if (bean.getQuestionNum() == questionNum) {
        correctBean = bean;
      }
    }
    return correctBean;
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

  public Collection<Bean> getBeans() {
    return beans;
  }

  public boolean isClusterCompleted() {
    return clusterCompleted;
  }

  public void setClusterCompleted() {
    this.clusterCompleted = true;
  }

  public boolean checkCompletedBeans() {
    for (Bean bean : beans) {
      if (!bean.isCompletedQuestion()) {
        return false;
      }
    }
    return true;
  }

  public boolean isLastBean(Bean beanToCheck) {
    if (beanToCheck != beans.toArray()[beans.size() - 1]) {
      return false;
    }
    return true;
  }

  public Cluster() {}
}
