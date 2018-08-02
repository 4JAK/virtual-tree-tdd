package org.wecancodeit.virtualtreetdd;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class LessonTest {
  private Lesson testLesson;

  @Test
  public void shouldBeAbleToInstantiateClass() {
    testLesson = new Lesson();
    assertNotNull(testLesson);
  }
}
