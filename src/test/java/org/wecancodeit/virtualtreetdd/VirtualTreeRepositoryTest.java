package org.wecancodeit.virtualtreetdd;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

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
public class VirtualTreeRepositoryTest {

  @Autowired private VirtualTreeRepository vTreeRepo;

  @Autowired private BranchRepository branchRepo;

  // The entity manager is used so that we can clear out any memory from JPA
  // so that the entity that we are testing for IS the entity we want to grab
  @Resource private EntityManager em;

  @Mock private VirtualTree testTree;

  @Before
  public void treeSetup() {
    testTree = vTreeRepo.save(new VirtualTree("Java", null));
  }

  @Test // shows that a tree can be saved to tree repo
  public void shouldBeAbleToSaveVirtualTreeToRepo() {
    Long treeId = testTree.getId();

    em.flush();
    em.clear();

    assertTrue(vTreeRepo.exists(treeId));
  }

  @Test // shows that tree has a generated id
  public void virtualTreeShouldHaveGeneratedId() {
    Long treeId = testTree.getId();

    em.flush();
    em.clear();

    VirtualTree underTestTree = vTreeRepo.findOne(treeId);
    Long expectedId = underTestTree.getId();
    assertNotNull(vTreeRepo.findOne(expectedId));
  }

  @Test // shows that tree has a name and that the getter for name works
  public void virtualTreeFromRepoShouldHaveName() {
    Long treeId = testTree.getId();
    String treeName = testTree.getName();

    em.flush();
    em.clear();

    VirtualTree underTestTree = vTreeRepo.findOne(treeId);
    String underTestTreeName = underTestTree.getName();

    assertThat(underTestTreeName, is(treeName));
  }

  @Test
  public void shouldReturnTrueIfAllBranchesAreComplete() {
    Branch testBranch1 = branchRepo.save(new Branch("testBranch1", testTree));
    testBranch1.setBranchCompleted();
    Branch testBranch2 = branchRepo.save(new Branch("testBranch2", testTree));
    testBranch2.setBranchCompleted();
    branchRepo.save(testBranch1);
    branchRepo.save(testBranch2);
    Long treeId = testTree.getId();

    em.flush();
    em.clear();
    
    VirtualTree underTestTree = vTreeRepo.findOne(treeId);
    Boolean allBranchesAreComplete = underTestTree.isAllBranchesCompleted();
    assertTrue(allBranchesAreComplete);
    assertTrue(underTestTree.isCompletedTree());
  }
  
  @Test
  public void shouldReturnFalseIfSingleBranchIsNotComplete() {
    Branch testBranch1 = branchRepo.save(new Branch("testBranch1", testTree));
    testBranch1.setBranchCompleted();
    Branch testBranch2 = branchRepo.save(new Branch("testBranch2", testTree));
    branchRepo.save(testBranch1);
    branchRepo.save(testBranch2);
    Long treeId = testTree.getId();

    em.flush();
    em.clear();
    
    VirtualTree underTestTree = vTreeRepo.findOne(treeId);
    Boolean allBranchesAreComplete = underTestTree.isAllBranchesCompleted();
    assertFalse(allBranchesAreComplete);
    assertFalse(underTestTree.isCompletedTree());
  }
}
