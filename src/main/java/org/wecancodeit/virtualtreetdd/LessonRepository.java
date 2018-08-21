package org.wecancodeit.virtualtreetdd;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository //Lesson repository
public interface LessonRepository extends CrudRepository<Lesson, Long> {}
