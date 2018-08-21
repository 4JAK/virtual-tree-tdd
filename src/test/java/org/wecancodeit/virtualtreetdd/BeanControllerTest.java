package org.wecancodeit.virtualtreetdd;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringJUnit4ClassRunner.class)
@WebMvcTest(BeanController.class)
public class BeanControllerTest {

  @Autowired MockMvc mvc;

  @MockBean private BeanRepository beanRepo;
  
  @Mock private Bean testBean;
  
  @Before public void setup() {
  	given(beanRepo.findOne(1L)).willReturn(testBean);
  	given(testBean.getQuestionType()).willReturn("TrueOrFalse");
  }

  @Test //returns status "Ok" and 2xx successful
  public void beansMappingShouldReturn2xxSuccessful() throws Exception {
    mvc.perform(get("/beans")).andExpect(status().isOk()).andExpect(status().is2xxSuccessful());
  }

  @Test //4xx error due to grammatical error in URL
  public void beansMappingShouldReturn4xxError() throws Exception {
    mvc.perform(get("/beens")).andExpect(status().is4xxClientError());
  }

  @Test //URL should contain attribute "beans" and contain all beans
  public void beansMappingAttributeShouldHaveHaveBeans() throws Exception {
    mvc.perform(get("/beans")).andExpect(model().attribute("beans", is(beanRepo.findAll())));
  }

  @Test //The view name should be "beans"
  public void beansMappingViewNameShouldBeBeans() throws Exception {
    mvc.perform(get("/beans")).andExpect(view().name(is("beans")));
  }
  
  @Test //status should be "Ok" and 2xx successful
  public void beanMappingShouldReturn2xxSuccessful() throws Exception {
    mvc.perform(get("/bean/1")).andExpect(status().isOk()).andExpect(status().is2xxSuccessful());
  }

  @Test //URL Grammatical error should return 4xx Client Error
  public void beanMappingShouldReturn4xxError() throws Exception {
    mvc.perform(get("/been/1")).andExpect(status().is4xxClientError());
  }

  @Test //The Mock bean should be the 1st mapping attribute 
  public void beanMappingAttributeShouldHaveHaveBean() throws Exception {
    mvc.perform(get("/bean/1")).andExpect(model().attribute("bean", is(testBean)));
  }

  @Test //View name should be "bean"
  public void beanMappingViewNameShouldBeBean() throws Exception {
    mvc.perform(get("/bean/1")).andExpect(view().name(is("bean")));
  }
}
