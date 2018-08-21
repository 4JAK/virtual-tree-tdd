package org.wecancodeit.virtualtreetdd.EntityTests;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.Matchers.greaterThan;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.wecancodeit.virtualtreetdd.entity.Bean;
import org.wecancodeit.virtualtreetdd.entity.Cluster;
import org.wecancodeit.virtualtreetdd.entity.QuestionType;

public class BeanTest {

  private Bean testBean;
  Cluster testCluster = new Cluster();

  @Before //makes a cluster with bean
  public void setUp() {
    testBean = new Bean(testCluster, null, 0, QuestionType.TrueOrFalse, "a question", null, null);
//        new Bean(testCluster, null, null, QuestionType.TrueOrFalse, "a question", 42, null);
  }

  @Test //Instantiation check != null
  public void shouldBeAbleToInstaniate() {
    Bean underTestBean = new Bean();
    assertNotNull(underTestBean);
  }

  @Test //Checks to see if testBean has a testCluster
  public void beanShouldHaveCluster() {
    assertNotNull(testBean.getCluster());
  }

  @Test //Checks to see if a bean has a question
  public void beanShouldHaveSingleQuestion() {
    String underTestBeanQuestion = testBean.getQuestion();
    assertNotNull(underTestBeanQuestion);
  }

  @Test //check should return that the question type is TrueOrFalse
  public void beanQuestionTypeShouldBeTrueOrFalse() {
    assertThat(testBean.getQuestionType(), is("TrueOrFalse"));
  }

  @Test //check should return that the question type is FillInTheBlanks
  public void beanQuestionTypeShouldNotBeTrueOrFalse() {
    assertThat(testBean.getQuestionType(), is(not("FillInTheBlanks")));
  }

  @Test //Checks to see if a bean contains multiple answers (1 Correct ,  1:many not correct)
  public void beanQuestionShouldHaveMultipleAnswers() {
    String answer1 = "answer1";
    String answer2 = "answer2";
    String correctAnswer = "this is correct";
    Collection<String> answerCollection = Arrays.asList(answer1, answer2, correctAnswer);

    Bean underTestBean = new Bean(testCluster, null, 0, QuestionType.Drag_n_Drop, "answer to life", "42", answerCollection);

    assertThat(underTestBean.getAnswers().size(), is(greaterThan(1)));
  }
}
