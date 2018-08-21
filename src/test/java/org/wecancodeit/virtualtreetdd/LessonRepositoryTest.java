package org.wecancodeit.virtualtreetdd;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.junit.Assert.assertThat;

import javax.annotation.Resource;
import javax.persistence.EntityManager;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.wecancodeit.virtualtreetdd.Bean;
import org.wecancodeit.virtualtreetdd.BeanRepository;
import org.wecancodeit.virtualtreetdd.Lesson;
import org.wecancodeit.virtualtreetdd.LessonRepository;
import org.wecancodeit.virtualtreetdd.QuestionType;

@RunWith(SpringJUnit4ClassRunner.class)
@DataJpaTest
public class LessonRepositoryTest {

  @Autowired private LessonRepository lessonRepo;
  @Autowired private BeanRepository beanRepo;
  @Resource private EntityManager em;

  @Mock private Bean testBeanType;

  @Test // shows that a lesson is able to be saved to lesson repo
  public void shouldBeAbleToSaveLessonToRepo() {
    Lesson underTestLesson = lessonRepo.save(new Lesson("Example test", "A test image"));

    Long lessonId = underTestLesson.getId();

    em.flush();
    em.clear();

    Lesson resultLesson = lessonRepo.findOne(lessonId);

    assertThat(lessonRepo.findOne(lessonId), is(resultLesson));
  }

  @Test // shows that a lesson can have more than one bean
  public void lessonShouldEstablishRelationshipToBeans() {
    Lesson underTestLesson = lessonRepo.save(new Lesson("Example test", "A test image"));
    Bean testBean1 =
        beanRepo.save(new Bean(null, underTestLesson, 1, QuestionType.Drag_n_Drop, "a question", "2", null));
    Bean testBean2 =
        beanRepo.save(new Bean(null, underTestLesson, 2, QuestionType.TrueOrFalse, "a question", "3", null));

    Long lessonId = underTestLesson.getId();
    Long testBean1Id = testBean1.getId();
    Long testBean2Id = testBean2.getId();

    em.flush();
    em.clear();

    Lesson resultLesson = lessonRepo.findOne(lessonId);
    Bean resultBean1 = beanRepo.findOne(testBean1Id);
    Bean resultBean2 = beanRepo.findOne(testBean2Id);

    assertThat(resultLesson.getBeans(), containsInAnyOrder(resultBean1, resultBean2));
  }
}
