package org.wecancodeit.virtualtreetdd;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.wecancodeit.virtualtreetdd.Bean.QuestionType;

public class BeanTest {

  @Test
  public void shouldBeAbleToInstaniate() {
    Bean testBean = new Bean();
    assertNotNull(testBean);
  }

  @Test
  public void beanShouldHaveSingleQuestion() {
    Bean testBean = new Bean(null, "Java Bean Example", "1", "a single question?", null, null);

    String underTestBeanQuestion = testBean.getQuestion();
    assertNotNull(underTestBeanQuestion);
  }

  @Test
  public void beanQuestionTypeShouldBeTrueOrFalse() {
	  Bean testBean = new Bean(QuestionType.TrueOrFalse, null, null, null, "1", null);
	  
	  assertThat(testBean.getQuestionType(), is(QuestionType.TrueOrFalse));
  }
  
  @Test public void beanQuestionTypeShouldNotBeTrueOrFalse() {
	  Bean testBean = new Bean(QuestionType.TrueOrFalse, null, null, null, "1", null);
	  
	  assertThat(testBean.getQuestionType(), is(not(QuestionType.FillInTheBlanks)));
  }
}
