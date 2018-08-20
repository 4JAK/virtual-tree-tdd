package org.wecancodeit.virtualtreetdd;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringJUnit4ClassRunner.class)
@WebMvcTest(VirtualTreeController.class)
public class VirtualTreeControllerTest {

  @Autowired MockMvc mvc;

  @MockBean private VirtualTreeRepository vTreeRepo;

  @Test //shows that index mapping path is good
  public void indexMappingShouldReturn2xxSuccessful() throws Exception {
    mvc.perform(get("/")).andExpect(status().is2xxSuccessful());
  }

  @Test //shows that home mapping path is good
  public void homeMappingShouldReturn2xxSuccessful() throws Exception {
    mvc.perform(get("/home")).andExpect(status().isOk()).andExpect(status().is2xxSuccessful());
  }

  @Test //shows that homes is not a good mapping path to home
  public void homeMappingShouldReturn4xxError() throws Exception {
    mvc.perform(get("/homes")).andExpect(status().is4xxClientError());
  }

  @Test //shows that home page should have a virtual tree
  public void homeMappingAttributeShouldHaveHaveVirtualTree() throws Exception {
    mvc.perform(get("/home")).andExpect(model().attribute("virtualTree", is(vTreeRepo.findAll())));
  }

  @Test //shows that home mapping name is home
  public void homeMappingViewNameShouldBeVirtualTree() throws Exception {
    mvc.perform(get("/home")).andExpect(view().name(is("home")));
  }
  @Test //shows the about page mapping is good
  public void aboutPageMappingShouldReturn2xxSuccessfull() throws Exception {
	  mvc.perform(get("/about")).andExpect(status().is2xxSuccessful());
  }
}
