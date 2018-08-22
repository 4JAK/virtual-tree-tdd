package org.wecancodeit.virtualtreetdd;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

public class BranchTest {

  private Branch testBranch;
  private Cluster testCluster;

  @Before
  public void branchSetup() { // shows that a branch is apart of a tree
    testBranch = new Branch("Java Branch", new VirtualTree("Java Tree", null));

    // Create clusters and set their isCompleted value to true
    testCluster = new Cluster("cluster1", testBranch);
    testCluster.setClusterCompleted();
  }

  @Test // should show that creating a new branch yields a new branch
  public void shouldBeAbleToCreateNewBranch() {
    assertNotNull(testBranch);
  }

  @Test // test to show that each branch has a name and is able to get that name
  public void shouldHaveName() {
    assertThat(testBranch.getName(), is(equalTo("Java Branch")));
  }

  @Test // test shows that a branch should have a virtual tree it is apart of
  public void shouldHaveVirtualTree() {
    assertNotNull(testBranch.getVirtualTree());
  }

  @Test
  public void shouldReturnTrueIfAllClustersAreComplete() {
    Cluster testCluster2 = new Cluster("cluster2", testBranch);
    testCluster2.setClusterCompleted();
    // Set clusters to the branch
    testBranch.setClusters(Arrays.asList(testCluster, testCluster2));
    Boolean allClustersInBranchAreComplete = testBranch.isAllClustersComplete();
    assertTrue(allClustersInBranchAreComplete);
    assertTrue(testBranch.isBranchCompleted());
  }

  @Test
  public void shouldReturnFalseIfAllClustersAreComplete() {
    Cluster testCluster2 = new Cluster("cluster2", testBranch);
    testBranch.setClusters(Arrays.asList(testCluster, testCluster2));
    Boolean allClustersInBranchAreComplete = testBranch.isAllClustersComplete();
    assertFalse(allClustersInBranchAreComplete);
    assertFalse(testBranch.isBranchCompleted());
  }

  @Test
  public void shouldReturnTrueIfClusterIsLastInBranch() {
    Cluster testCluster2 = new Cluster("cluster2", testBranch);
    Cluster testCluster3 = new Cluster("cluster3", testBranch);
    testBranch.setClusters(Arrays.asList(testCluster, testCluster2, testCluster3));
    Boolean isLastCluster = testBranch.isLastCluster(testCluster3);
    assertTrue(isLastCluster);
  }

  @Test
  public void shouldReturnFalseIfClusterIsLastInBranch() {
    Cluster testCluster2 = new Cluster("cluster2", testBranch);
    Cluster testCluster3 = new Cluster("cluster3", testBranch);
    testBranch.setClusters(Arrays.asList(testCluster, testCluster2, testCluster3));
    Boolean isLastCluster = testBranch.isLastCluster(testCluster);
    assertFalse(isLastCluster);
  }
}
