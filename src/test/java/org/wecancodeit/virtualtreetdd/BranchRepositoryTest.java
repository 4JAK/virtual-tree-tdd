package org.wecancodeit.virtualtreetdd;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

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
  
  @Before public void setup() {
	  testTree = vTreeRepo.save(new VirtualTree("tree1", null));
  }

  @Test //Checks to see if a branch is saved in repo
  public void shouldBeAbleToSaveBranchToRepo() {
    testBranch = branchRepo.save(new Branch("Java Branch", null));

    em.flush(); // save and synchronize the database
    em.clear(); // any entity that is not saved will be cleared from memory,
    			// like closing an application

    assertNotNull(branchRepo.exists(1L));
  }

  @Test//Checks to see if branch has a generated Id
  public void branchShouldHaveGeneratedId() {
    testBranch = branchRepo.save(new Branch("Java Branch", null));
    Long branchId = testBranch.getId();

    em.flush();
    em.clear();

    Long expectedId = branchRepo.findOne(branchId).getId();

    assertThat(expectedId, is(equalTo(branchId)));
  }

  @Test //Checks branch for a tree
  public void shouldHaveVirtualTree() {
    testTree = vTreeRepo.save(new VirtualTree("Java Tree", null));
    testBranch = branchRepo.save(new Branch("Java Branch", testTree));
    Long branchId = testBranch.getId();

    em.flush();
    em.clear();

    Branch underTestBranch = branchRepo.findOne(branchId);
    VirtualTree underTestTree = underTestBranch.getVirtualTree();

    assertThat(underTestBranch.getVirtualTree(), is(underTestTree));
  }

  @Test //Checks for a cluster
  public void shouldHaveClusters() {
    testBranch = branchRepo.save(new Branch("Java Branch", null));
    testCluster = clusterRepo.save(new Cluster("Java Cluster", testBranch));

    Long branchId = testBranch.getId();

    em.flush();
    em.clear();

    Collection<Cluster> underTestBranchClusters = branchRepo.findOne(branchId).getClusters();

    assertThat(underTestBranchClusters.size(), is(greaterThan(0)));
  }
  @Test
  public void shouldBeAbleToGetNextClusterOnBranch() {
	 testBranch = branchRepo.save (new Branch("branch1", testTree));
	 testCluster = clusterRepo.save (new Cluster("cluster1", testBranch));
	 Cluster testCluster2 = clusterRepo.save (new Cluster("cluster2", testBranch));
	 
	 Long branchId = testBranch.getId();
	 Long testClusterId = testCluster.getId();
	 Long testCluster2Id = testCluster2.getId();
	 
	 em.flush();
	 em.clear();
	 
	 Branch resultBranch = branchRepo.findOne(branchId);
	 Cluster resultCluster1 = clusterRepo.findOne(testClusterId);
	 Cluster resultCluster2 = clusterRepo.findOne(testCluster2Id);
	
	 Cluster nextCluster = resultBranch.getNextCluster(resultCluster1.getId());
	 assertThat(nextCluster.getId(), is(equalTo(2L)));	 
  }

}
