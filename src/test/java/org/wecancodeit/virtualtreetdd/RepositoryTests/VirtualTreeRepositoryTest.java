package org.wecancodeit.virtualtreetdd.RepositoryTests;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import javax.annotation.Resource;
import javax.persistence.EntityManager;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.wecancodeit.virtualtreetdd.entity.VirtualTree;
import org.wecancodeit.virtualtreetdd.repository.VirtualTreeRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@DataJpaTest
public class VirtualTreeRepositoryTest {

	@Autowired
	private VirtualTreeRepository vTreeRepo;
	
	// The entity manager is used so that we can clear out any memory from JPA
	// so that the entity that we are testing for IS the entity we want to grab
	@Resource
	private EntityManager em;

	@Mock
	private VirtualTree testTree;

	@Test //shows that a tree can be saved to tree repo
	public void shouldBeAbleToSaveVirtualTreeToRepo() {
		testTree = vTreeRepo.save(new VirtualTree("Java", null));
		Long treeId = testTree.getId();
		
		em.flush();
		em.clear();
		
		assertTrue(vTreeRepo.exists(treeId));
	}

	@Test //shows that tree has a generated id
	public void virtualTreeShouldHaveGeneratedId() {
		testTree = vTreeRepo.save(new VirtualTree("Java", null));
		Long treeId = testTree.getId();
		
		em.flush();
		em.clear();

		VirtualTree underTestTree = vTreeRepo.findOne(treeId);
		Long expectedId = underTestTree.getId();
		assertNotNull(vTreeRepo.findOne(expectedId));
	}
	
	@Test  //shows that tree has a name and that the getter for name works 
	public void virtualTreeFromRepoShouldHaveName() {
		testTree = vTreeRepo.save(new VirtualTree("Java", null));
		Long treeId = testTree.getId();
		String treeName = testTree.getName();
		
		em.flush();
		em.clear();
		
		VirtualTree underTestTree = vTreeRepo.findOne(treeId);
		String underTestTreeName = underTestTree.getName();
		
		assertThat(underTestTreeName, is(treeName));
	}
}
