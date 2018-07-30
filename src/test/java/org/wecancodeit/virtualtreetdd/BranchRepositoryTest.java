package org.wecancodeit.virtualtreetdd;

import static org.junit.Assert.assertNotNull;
import static org.mockito.BDDMockito.*;

import javax.annotation.Resource;

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
	
	@Resource
	BranchRepository branchRepo;
	
	@Resource
	VirtualTreeRepository vTreeRepo;

	@Mock
	Branch branch;
	
	@Mock
	VirtualTree tree;
	

	@Before
	public void saveBranchSetup() {		
		tree = vTreeRepo.save(new VirtualTree("Java Tree"));
		branch = branchRepo.save(new Branch("Java Branch", tree));
	}

	@Test
	public void shouldBeAbleToSaveBranchToRepo() throws Exception {
		assertNotNull(branchRepo.exists(1L));
	}

	@Test
	public void branchShouldHaveGeneratedId() throws Exception {
		assertNotNull(branchRepo.findOne(2L));
	}

}
