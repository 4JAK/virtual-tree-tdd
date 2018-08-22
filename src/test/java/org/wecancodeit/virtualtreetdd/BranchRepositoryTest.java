package org.wecancodeit.virtualtreetdd;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.Collection;

import javax.annotation.Resource;
import javax.persistence.EntityManager;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@DataJpaTest
public class BranchRepositoryTest {

  @Autowired private BranchRepository branchRepo;

  @Autowired private VirtualTreeRepository vTreeRepo;

  @Autowired private ClusterRepository clusterRepo;

  // The entity manager is used so that we can clear out any memory from JPA
  // so that the entity that we are testing for IS the entity we want to grab
  @Resource private EntityManager em;

  @Mock private Branch testBranch;

  @Mock private Cluster testCluster;

  @Mock private VirtualTree testTree;

  @Before
  public void setup() {
    testTree = vTreeRepo.save(new VirtualTree("tree1", null));
    testBranch = branchRepo.save(new Branch("Java Branch", testTree));
    testCluster = clusterRepo.save(new Cluster("Java Cluster", testBranch));
  }

  @Test // Checks to see if a branch is saved in repo
  public void shouldBeAbleToSaveBranchToRepo() {
    Long branchId = testBranch.getId();

    em.flush(); // save and synchronize the database
    em.clear(); // any entity that is not saved will be cleared from memory,
    // like closing an application

    assertNotNull(branchRepo.exists(branchId));
  }

  @Test // Checks to see if branch has a generated Id
  public void branchShouldHaveGeneratedId() {
    Long branchId = testBranch.getId();

    em.flush();
    em.clear();

    Long expectedId = branchRepo.findOne(branchId).getId();

    assertThat(expectedId, is(equalTo(branchId)));
  }

  @Test // Checks branch for a tree
  public void shouldHaveVirtualTree() {
    Long branchId = testBranch.getId();

    em.flush();
    em.clear();

    Branch underTestBranch = branchRepo.findOne(branchId);
    VirtualTree underTestTree = underTestBranch.getVirtualTree();

    assertThat(underTestBranch.getVirtualTree(), is(underTestTree));
  }

  @Test // Checks for a cluster
  public void shouldHaveClusters() {
    Long branchId = testBranch.getId();

    em.flush();
    em.clear();

    Collection<Cluster> underTestBranchClusters = branchRepo.findOne(branchId).getClusters();

    assertThat(underTestBranchClusters.size(), is(greaterThan(0)));
  }

  @Test
  public void shouldBeAbleToGetNextClusterOnBranch() {
    Cluster testCluster2 = clusterRepo.save(new Cluster("cluster2", testBranch));

    Long branchId = testBranch.getId();
    Long testClusterId = testCluster.getId();
    Long testCluster2Id = testCluster2.getId();

    em.flush();
    em.clear();

    Branch resultBranch = branchRepo.findOne(branchId);
    Cluster resultCluster1 = clusterRepo.findOne(testClusterId);
    Cluster resultCluster2 = clusterRepo.findOne(testCluster2Id);

    Cluster nextCluster = resultBranch.getNextCluster(resultCluster1.getId());
    assertThat(nextCluster.getId(), is(equalTo(resultCluster2.getId())));
  }

  @Test
  public void shouldReturnFalseForIsCompleted() {
    testCluster.setClusterCompleted();
    // Now save the cluster again because we needed to set the boolean value
    // for whether or not it was completed
    clusterRepo.save(testCluster);
    Cluster testCluster2 = clusterRepo.save(new Cluster("cluster1", testBranch));
    Long branchId = testBranch.getId();

    em.flush();
    em.clear();

    Branch resultBranch = branchRepo.findOne(branchId);
    assertFalse(resultBranch.isBranchCompleted());
  }

  @Test
  public void shouldReturnTrueForIsCompleted() {
    testCluster.setClusterCompleted();
    clusterRepo.save(testCluster);
    Cluster testCluster2 = new Cluster("cluster1", testBranch);
    testCluster2.setClusterCompleted();
    clusterRepo.save(testCluster2);
    Long branchId = testBranch.getId();

    em.flush();
    em.clear();

    Branch resultBranch = branchRepo.findOne(branchId);
    assertTrue(resultBranch.isBranchCompleted());
  }
  
  @Test
  public void shouldReturnTrueIfClusterIsLastInBranch() {
    Cluster testCluster2 = clusterRepo.save(new Cluster("cluster2", testBranch));
    Cluster testCluster3 = clusterRepo.save(new Cluster("cluster3", testBranch));
    
    Long branchId = testBranch.getId();
    Long testClusterId = testCluster.getId();
    Long testCluster2Id = testCluster2.getId();
    Long testCluster3Id = testCluster3.getId();
    
    em.flush();
    em.clear();

    Branch resultBranch = branchRepo.findOne(branchId);
    Cluster resultCluster1 = clusterRepo.findOne(testClusterId);
    Cluster resultCluster2 = clusterRepo.findOne(testCluster2Id);
    Cluster resultCluster3 = clusterRepo.findOne(testCluster3Id);
    
    Boolean isLastCluster = resultBranch.isLastCluster(resultCluster3);
    assertTrue(isLastCluster);
  }
}
