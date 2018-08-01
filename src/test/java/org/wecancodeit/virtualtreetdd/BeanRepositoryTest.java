package org.wecancodeit.virtualtreetdd;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import javax.annotation.Resource;
import javax.persistence.EntityManager;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
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
  @Mock private Bean testBean;

  @Test
  public void shouldBeAbleToSaveBeanToRepo() throws Exception {
    testBean = beanRepo.save(new Bean(null, "Java Bean Example", null, null, null, null));
    Long beanId = testBean.getId();

    em.flush();
    em.clear();

    Bean underTestBean = beanRepo.findOne(beanId);
    assertNotNull(underTestBean);
  }

  @Test
  public void beanShouldHaveRelationshipToCluster() throws Exception {
    Cluster testCluster = clusterRepo.save(new Cluster("Java Bean Cluster", null));
    testBean = beanRepo.save(new Bean(null, "Java Bean Example", null, null, null, testCluster));
    Long beanId = testBean.getId();

    em.flush();
    em.clear();

    Bean underTestBean = beanRepo.findOne(beanId);
    assertNotNull(underTestBean.getCluster());
    assertThat(underTestBean.getCluster().getName(), is("Java Bean Cluster"));
  }

  @Test
  public void clusterShouldHaveRelationshipToBean() throws Exception {
    Cluster testCluster = clusterRepo.save(new Cluster("Java Bean Cluster", null));
    testBean = beanRepo.save(new Bean(null, "Java Bean Example", null, null, null, testCluster));
    Long beanId = testBean.getId();
    Long clusterId = testCluster.getId();

    em.flush();
    em.clear();

    Cluster underTestCluster = clusterRepo.findOne(clusterId);
    Bean underTestBean = beanRepo.findOne(beanId);

    assertTrue(underTestCluster.getBeans().contains(underTestBean));
  }

  @Test
  public void shouldBeAbleToDeleteBeanFromRepo() throws Exception {
    testBean = beanRepo.save(new Bean(null, "Java Bean Example", null, null, null, null));
    Long beanId = testBean.getId();

    em.flush();
    em.clear();

    beanRepo.delete(beanId);
    assertNull(beanRepo.findOne(beanId));
  }
  
  @Test
  public void shouldBeAbleToQueryAllBeansOfQuestionTypeTrueOrFalse() throws Exception {
	  testBean = beanRepo.save(new Bean(QuestionType.TrueOrFalse, "Java Bean Example", null, null, null, null));
	  Bean testBean2 = beanRepo.save(new Bean(QuestionType.TrueOrFalse, "Java Bean Example 2", null, null, null, null));
	  Bean testBean3 = beanRepo.save(new Bean(QuestionType.FillInTheBlanks, "Java Bean Example 3", null, null, null, null));
	  
	  em.flush();
	  em.clear();
	  
	  assertThat(beanRepo.findAllByQuestionType(QuestionType.TrueOrFalse).size(), is(equalTo(2)));
  }
}
