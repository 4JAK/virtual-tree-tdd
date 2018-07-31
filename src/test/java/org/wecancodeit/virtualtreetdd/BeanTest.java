package org.wecancodeit.virtualtreetdd;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class BeanTest {
	
	@Test
	public void shouldBeAbleToInstaniate() {
		Bean testBean = new Bean();		
		assertNotNull(testBean);
	}
	
	  @Test
	  public void beanShouldHaveSingleQuestion() throws Exception {
	    Bean testBean = new Bean("Java Bean Example", "1", "a single question?", null, null);

	    String underTestBeanQuestion = testBean.getQuestion();
	    assertNotNull(underTestBeanQuestion);
	  }
	
}
