package org.wecancodeit.virtualtreetdd.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.wecancodeit.virtualtreetdd.entity.Lesson;

@Repository //Lesson repository
public interface LessonRepository extends CrudRepository<Lesson, Long> {}
