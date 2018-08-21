package org.wecancodeit.virtualtreetdd;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import javax.annotation.Resource;
import javax.persistence.EntityManager;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@DataJpaTest
public class BeanRepositoryTest {
  @Autowired private BeanRepository beanRepo;
  @Autowired private ClusterRepository clusterRepo;
  @Resource private EntityManager em;
  private Bean testBean;
  private Cluster testCluster;

  @Before // Creates Cluster and Bean for each individual test, flushes & clears
  public void setUp() {
    testCluster = clusterRepo.save(new Cluster("Java Bean Cluster", null));
    testBean =
        beanRepo.save(
            new Bean(testCluster, null, 0, QuestionType.Drag_n_Drop, "a question", null, null));
  }

  @Test // Saves bean to repo
  public void shouldBeAbleToSaveBeanToRepo() {
    Long beanId = testBean.getId();

    em.flush();
    em.clear();

    Bean underTestBean = beanRepo.findOne(beanId);
    assertNotNull(underTestBean);
  }

  @Test // Checks bean's relationship or "name" to Cluster
  public void beanShouldHaveRelationshipToCluster() {
    Long beanId = testBean.getId();

    em.flush();
    em.clear();

    Bean underTestBean = beanRepo.findOne(beanId);
    assertNotNull(underTestBean.getCluster());
    assertThat(underTestBean.getCluster().getName(), is("Java Bean Cluster"));
  }

  @Test // Checks to see if Cluster contains a linked bean
  public void clusterShouldHaveRelationshipToBean() {
    Long beanId = testBean.getId();
    Long clusterId = testCluster.getId();

    em.flush();
    em.clear();

    Cluster underTestCluster = clusterRepo.findOne(clusterId);
    Bean underTestBean = beanRepo.findOne(beanId);

    assertTrue(underTestCluster.getBeans().contains(underTestBean));
  }

  @Test // Checks to see if deleted bean is now == null
  public void shouldBeAbleToDeleteBeanFromRepo() {
    Long beanId = testBean.getId();

    em.flush();
    em.clear();

    beanRepo.delete(beanId);
    assertNull(beanRepo.findOne(beanId));
  }

  @Test // Checks to see if searching by "QuestionType" return's results "TrueOrFalse"
  public void shouldBeAbleToQueryAllBeansOfQuestionTypeTrueOrFalse() {
    Bean testBean2 =
        beanRepo.save(
            new Bean(null, null, 1, QuestionType.TrueOrFalse, "This is a question?", "true", null));
    Bean testBean3 =
        beanRepo.save(
            new Bean(
                null, null, 2, QuestionType.TrueOrFalse, "This is a question? 2", "true", null));

    Long testBeanId = testBean.getId();
    Long testBean2Id = testBean2.getId();
    Long testBean3Id = testBean3.getId();

    em.flush();
    em.clear();

    Bean resultTestBean = beanRepo.findOne(testBeanId);
    Bean resultTestBean2 = beanRepo.findOne(testBean2Id);
    Bean resultTestBean3 = beanRepo.findOne(testBean3Id);

    assertThat(
        beanRepo.findAllByQuestionType(QuestionType.TrueOrFalse),
        containsInAnyOrder(resultTestBean2, resultTestBean3));
  }
}
