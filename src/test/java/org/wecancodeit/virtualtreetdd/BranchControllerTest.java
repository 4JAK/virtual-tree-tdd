package org.wecancodeit.virtualtreetdd;

import static org.hamcrest.CoreMatchers.is;
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
  @Autowired MockMvc mvc;
  
  @MockBean private VirtualTreeRepository vTreeRepo;
  @MockBean private BranchRepository branchRepo;

  @Mock VirtualTree virtualTree;

  @Test //Branch mapping should return 2xx successful
  public void branchMappingShouldReturn2xxSuccessful() throws Exception {
    mvc.perform(get("/branch/1")).andExpect(status().isOk()).andExpect(status().is2xxSuccessful());
  }

  @Test //Grammatical error should return 4xx client error
  public void branchMappingShouldReturn4xxError() throws Exception {
    mvc.perform(get("/brances/1")).andExpect(status().is4xxClientError());
  }

  @Test //Branch mapping attribute should have branch
  public void branchMappingAttributeShouldHaveHaveBranch() throws Exception {
    mvc.perform(get("/branch/1")).andExpect(model().attribute("branch", is(branchRepo.findAll())));
  }

  @Test //View name should be "branch"
  public void branchMappingViewNameShouldBeBranch() throws Exception {
    mvc.perform(get("/branch/1")).andExpect(view().name(is("branch")));
  }

  @Test //"branches" should return "Ok" and 2xx status
  public void branchesMappingShouldReturn2xxSuccessful() throws Exception {
    mvc.perform(get("/branches")).andExpect(status().isOk()).andExpect(status().is2xxSuccessful());
  }

  @Test //grammatical error should return 4xx client error
  public void branchesMappingShouldReturn4xxError() throws Exception {
    mvc.perform(get("/brances")).andExpect(status().is4xxClientError());
  }

  @Test //branches mapping attribute should return all branches
  public void branchesMappingAttributeShouldHaveHaveBranches() throws Exception {
    mvc.perform(get("/branches"))
        .andExpect(model().attribute("branches", is(branchRepo.findAll())));
  }

  @Test //view name should be "branches"
  public void branchesMappingViewNameShouldBeBranches() throws Exception {
    mvc.perform(get("/branches")).andExpect(view().name(is("branches")));
  }
}
