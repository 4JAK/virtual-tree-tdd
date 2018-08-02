package org.wecancodeit.virtualtreetdd;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.Matchers.greaterThan;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.wecancodeit.virtualtreetdd.Bean.QuestionType;

public class BeanTest {

  private Bean testBean;

  @Before
  public void setUp() {
    Cluster testCluster = new Cluster();
    testBean =
        new Bean(testCluster, null, null, QuestionType.TrueOrFalse, "a question", "42", null);
  }

  @Test
  public void shouldBeAbleToInstaniate() {
    Bean underTestBean = new Bean();
    assertNotNull(underTestBean);
  }

  @Test
  public void beanShouldHaveCluster() {
    assertNotNull(testBean.getCluster());
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
  public void beanQuestionShouldHaveMultipleAnswers() {
    String answer1 = "answer1";
    String answer2 = "answer2";
    String correctAnswer = "this is correct";
    Collection<String> answerCollection = Arrays.asList(answer1, answer2, correctAnswer);

    Bean underTestBean = new Bean(null, null, null, null, null, null, answerCollection);

    assertThat(underTestBean.getAnswers().size(), is(greaterThan(1)));
  }
}
