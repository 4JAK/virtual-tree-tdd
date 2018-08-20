package org.wecancodeit.virtualtreetdd.EntityTests;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.wecancodeit.virtualtreetdd.entity.Lesson;

public class LessonTest {
  private Lesson testLesson;

  @Test // test shows that test created new class of Lesson
  public void shouldBeAbleToInstantiateClass() {
    testLesson = new Lesson();
    assertNotNull(testLesson);
  }
}
