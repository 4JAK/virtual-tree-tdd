package org.wecancodeit.virtualtreetdd;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.wecancodeit.virtualtreetdd.Bean.QuestionType;

public class BeanTest {

  private Bean testBean;

  @Before
  public void setUp() {
    Cluster testCluster = new Cluster();
    testBean = new Bean(QuestionType.TrueOrFalse, "What is 42?", "The answer to life", testCluster);
  }

  @Test
  public void shouldBeAbleToInstaniate() {
    Bean underTestBean = new Bean();
    assertNotNull(underTestBean);
  }

  @Test
  public void beanShouldHaveSingleQuestion() {
    String underTestBeanQuestion = testBean.getQuestion();
    assertNotNull(underTestBeanQuestion);
  }

  @Test
  public void beanQuestionTypeShouldBeTrueOrFalse() {
    assertThat(testBean.getQuestionType(), is(QuestionType.TrueOrFalse));
  }

  @Test
  public void beanQuestionTypeShouldNotBeTrueOrFalse() {
    assertThat(testBean.getQuestionType(), is(not(QuestionType.FillInTheBlanks)));
  }

  @Test
  public void beanShouldHaveCluster() {
    assertNotNull(testBean.getCluster());
  }
}
