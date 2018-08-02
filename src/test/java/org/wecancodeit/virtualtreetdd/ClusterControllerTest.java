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
@WebMvcTest(ClusterController.class)
public class ClusterControllerTest {

  @Autowired MockMvc mvc;

  @MockBean private ClusterRepository clusterRepo;
  @Mock private Cluster cluster;

  @Test
  public void clusterMappingShouldReturn2xxSuccessful() throws Exception {
    mvc.perform(get("/cluster/1")).andExpect(status().isOk()).andExpect(status().is2xxSuccessful());
  }

  @Test
  public void clusterMappingShouldReturn4xxError() throws Exception {
    mvc.perform(get("/clustr/1")).andExpect(status().is4xxClientError());
  }

  @Test
  public void clusterMappingAttributeShouldHaveHaveCluster() throws Exception {
    given(clusterRepo.findOne(1L)).willReturn(cluster);
    mvc.perform(get("/cluster/1")).andExpect(model().attribute("cluster", is(cluster)));
  }

  @Test
  public void clusterMappingViewNameShouldBeCluster() throws Exception {
    mvc.perform(get("/cluster/1")).andExpect(view().name(is("cluster")));
  }

  @Test
  public void clustersMappingShouldReturn2xxSuccessful() throws Exception {
    mvc.perform(get("/clusters")).andExpect(status().isOk()).andExpect(status().is2xxSuccessful());
  }

  @Test
  public void clustersMappingShouldReturn4xxError() throws Exception {
    mvc.perform(get("/clustrs")).andExpect(status().is4xxClientError());
  }

  @Test
  public void clustersMappingAttributeShouldHaveHaveClusters() throws Exception {
    mvc.perform(get("/clusters"))
        .andExpect(model().attribute("clusters", is(clusterRepo.findAll())));
  }

  @Test
  public void clustersMappingViewNameShouldBeClusters() throws Exception {
    mvc.perform(get("/clusters")).andExpect(view().name(is("clusters")));
  }
}
