package org.wecancodeit.virtualtreetdd;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.wecancodeit.virtualtreetdd.Branch;
import org.wecancodeit.virtualtreetdd.Cluster;

public class ClusterTest {

  @Mock private Cluster testCluster;

  @Before 
  public void clusterSetup() {
    testCluster = new Cluster("Java Cluster", new Branch());
  }

  @Test //  test shows that a new cluster can be created 
  public void shouldBeAbleToCreateNewCluster() {
    assertNotNull(testCluster);
  }

  @Test //shows that cluster has name and that the getter for name works
  public void shouldHaveName() {
    assertThat(testCluster.getName(), is(equalTo("Java Cluster")));
  }

  @Test // shows that cluster should have a branch
  public void clusterShouldHaveBranch() {
    assertNotNull(testCluster.getBranch());
  }
}
