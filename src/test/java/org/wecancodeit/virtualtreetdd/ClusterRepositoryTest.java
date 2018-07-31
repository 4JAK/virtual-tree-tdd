package org.wecancodeit.virtualtreetdd;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

import javax.annotation.Resource;
import javax.persistence.EntityManager;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@DataJpaTest
public class ClusterRepositoryTest {
	
	@Autowired
	private ClusterRepository clusterRepo;
	
	@Autowired
	private BranchRepository branchRepo;
	
	// The entity manager is used so that we can clear out any memory from JPA
	// so that the entity that we are testing for IS the entity we want to grab
	@Resource
	private EntityManager em;
	
	@Mock
	private Cluster testCluster;
	
	@Mock
	private Branch testBranch;

	
	@Test
	public void shouldBeAbleToSaveClusterToRepo() throws Exception {
		testCluster = clusterRepo.save(new Cluster("Java Cluster", null));
		Long clusterId = testCluster.getId();
		
		em.flush();
		em.clear();
		
		assertNotNull(clusterRepo.exists(clusterId));
	}
	
	@Test
	public void clusterShouldHaveGeneratedId() throws Exception {
		testCluster = clusterRepo.save(new Cluster("Java Cluster", null));
		Long clusterId = testCluster.getId();
		
		em.flush();
		em.clear();
		
		assertThat(clusterId, is(equalTo(1L)));
	}
	
	@Test
	public void clusterFromRepoShouldHaveBranch () {
		testBranch = branchRepo.save(new Branch("Java Branch", null));
		testCluster = clusterRepo.save(new Cluster("Java Cluster", testBranch));
		
		em.flush();
		em.clear();
		
		assertNotNull(testCluster.getBranch());
	}

}
