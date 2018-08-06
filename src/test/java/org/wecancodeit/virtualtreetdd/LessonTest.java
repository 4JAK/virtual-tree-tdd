package org.wecancodeit.virtualtreetdd;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class LessonTest {
  private Lesson testLesson;

  @Test // test shows that test created new class of Lesson
  public void shouldBeAbleToInstantiateClass() {
    testLesson = new Lesson();
    assertNotNull(testLesson);
  }
}
