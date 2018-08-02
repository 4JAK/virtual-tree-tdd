package org.wecancodeit.virtualtreetdd;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.equalTo;
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
import org.wecancodeit.virtualtreetdd.Bean.QuestionType;

@RunWith(SpringJUnit4ClassRunner.class)
@DataJpaTest
public class BeanRepositoryTest {
  @Autowired private BeanRepository beanRepo;
  @Autowired private ClusterRepository clusterRepo;
  @Resource private EntityManager em;
  private Bean testBean;
  private Cluster testCluster;

  @Before
  public void setUp() {
    testCluster = clusterRepo.save(new Cluster("Java Bean Cluster", null));
    testBean =
        beanRepo.save(new Bean(testCluster, null, "First question", QuestionType.FillInTheBlanks, "This is a question?", "true", null));
  }

  
  @Test
  public void shouldBeAbleToSaveBeanToRepo() {
    Long beanId = testBean.getId();

    em.flush();
    em.clear();

    Bean underTestBean = beanRepo.findOne(beanId);
    assertNotNull(underTestBean);
  }

  @Test
  public void beanShouldHaveRelationshipToCluster() {
    Long beanId = testBean.getId();

    em.flush();
    em.clear();

    Bean underTestBean = beanRepo.findOne(beanId);
    assertNotNull(underTestBean.getCluster());
    assertThat(underTestBean.getCluster().getName(), is("Java Bean Cluster"));
  }

  @Test
  public void clusterShouldHaveRelationshipToBean() {
    Long beanId = testBean.getId();
    Long clusterId = testCluster.getId();

    em.flush();
    em.clear();

    Cluster underTestCluster = clusterRepo.findOne(clusterId);
    Bean underTestBean = beanRepo.findOne(beanId);

    assertTrue(underTestCluster.getBeans().contains(underTestBean));
  }

  @Test
  public void shouldBeAbleToDeleteBeanFromRepo() {
    Long beanId = testBean.getId();

    em.flush();
    em.clear();

    beanRepo.delete(beanId);
    assertNull(beanRepo.findOne(beanId));
  }
  
  @Test
  public void shouldBeAbleToQueryAllBeansOfQuestionTypeTrueOrFalse() {
    Bean testBean2 =
    		beanRepo.save(new Bean(testCluster, null, "First question", QuestionType.TrueOrFalse, "This is a question?", "true", null));
    Bean testBean3 =
    		beanRepo.save(new Bean(testCluster, null, "First question", QuestionType.TrueOrFalse, "This is a question? 2", "true", null));

    Long testBeanId = testBean.getId();
    Long testBean2Id = testBean2.getId();
    Long testBean3Id = testBean3.getId();

    em.flush();
    em.clear();
    
    Bean resultTestBean = beanRepo.findOne(testBeanId);
    Bean resultTestBean2 = beanRepo.findOne(testBean2Id);
    Bean resultTestBean3 = beanRepo.findOne(testBean3Id);

    assertThat(beanRepo.findAllByQuestionType(QuestionType.TrueOrFalse), containsInAnyOrder(resultTestBean2, resultTestBean3));
    assertThat(beanRepo.findAllByQuestionType(QuestionType.TrueOrFalse).size(), is(equalTo(2)));
  }
}
