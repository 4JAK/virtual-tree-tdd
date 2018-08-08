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

  @Test //shows that mapping is correct
  public void clusterMappingShouldReturn2xxSuccessful() throws Exception {
    mvc.perform(get("/cluster/1")).andExpect(status().isOk()).andExpect(status().is2xxSuccessful());
  }

  @Test // shows that misspelling cluster gives back error
  public void clusterMappingShouldReturn4xxError() throws Exception {
    mvc.perform(get("/clustr/1")).andExpect(status().is4xxClientError());
  }

  @Test //shows that cluster/1 returns proper cluster
  public void clusterMappingAttributeShouldHaveHaveCluster() throws Exception {
    given(clusterRepo.findOne(1L)).willReturn(cluster);
    mvc.perform(get("/cluster/1")).andExpect(model().attribute("cluster", is(cluster)));
  }

  @Test //shows that cluster mapping name is cluster
  public void clusterMappingViewNameShouldBeCluster() throws Exception {
    mvc.perform(get("/cluster/1")).andExpect(view().name(is("cluster")));
  }

  @Test //shows that clusters mapping to correct
  public void clustersMappingShouldReturn2xxSuccessful() throws Exception {
    mvc.perform(get("/clusters")).andExpect(status().isOk()).andExpect(status().is2xxSuccessful());
  }

  @Test //shows that misspelling of cluster gives back error
  public void clustersMappingShouldReturn4xxError() throws Exception {
    mvc.perform(get("/clustrs")).andExpect(status().is4xxClientError());
  }

  @Test //shows that clusters shows more than one cluster
  public void clustersMappingAttributeShouldHaveHaveClusters() throws Exception {
    mvc.perform(get("/clusters"))
        .andExpect(model().attribute("clusters", is(clusterRepo.findAll())));
  }

  @Test //shows that  clusters path has name of clusters
  public void clustersMappingViewNameShouldBeClusters() throws Exception {
    mvc.perform(get("/clusters")).andExpect(view().name(is("clusters")));
  }
}
