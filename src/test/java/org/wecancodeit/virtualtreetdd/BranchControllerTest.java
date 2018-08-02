package org.wecancodeit.virtualtreetdd;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringJUnit4ClassRunner.class)
@WebMvcTest(BranchController.class)
public class BranchControllerTest {

	@Autowired
	MockMvc mvc;

	@MockBean
	private VirtualTreeRepository vTreeRepo;
	
	@MockBean
	private BranchRepository branchRepo;
	
	@Mock
	VirtualTree virtualTree;

	@Test
	public void branchMappingShouldReturn2xxSuccessful() throws Exception {
		mvc.perform(get("/branch")).andExpect(status().isOk()).andExpect(status().is2xxSuccessful());
	}

	@Test
	public void branchMappingShouldReturn4xxError() throws Exception {
		mvc.perform(get("/brances")).andExpect(status().is4xxClientError());
	}

	@Test
	public void branchMappingAttributeShouldHaveHaveBranch() throws Exception {
		mvc.perform(get("/branch")).andExpect(model().attribute("branch", is(branchRepo.findAll())));
	}

	@Test
	public void branchMappingViewNameShouldBeBranch() throws Exception {
		mvc.perform(get("/branch")).andExpect(view().name(is("branch")));
	}
	
	@Test
	public void branchesMappingShouldReturn2xxSuccessful() throws Exception {
		mvc.perform(get("/branches")).andExpect(status().isOk()).andExpect(status().is2xxSuccessful());
	}

	@Test
	public void branchesMappingShouldReturn4xxError() throws Exception {
		mvc.perform(get("/brances")).andExpect(status().is4xxClientError());
	}

	@Test
	public void branchesMappingAttributeShouldHaveHaveBranches() throws Exception {
		given(vTreeRepo.findOne(1L)).willReturn(virtualTree);
		mvc.perform(get("/branches")).andExpect(model().attribute("branches", is(vTreeRepo.findOne(1L).getBranches())));
	}

	@Test
	public void branchesMappingViewNameShouldBeBranches() throws Exception {
		mvc.perform(get("/branches")).andExpect(view().name(is("branches")));
	}

}
