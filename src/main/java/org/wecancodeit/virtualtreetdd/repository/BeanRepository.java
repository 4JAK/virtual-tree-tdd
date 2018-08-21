package org.wecancodeit.virtualtreetdd.repository;

import java.util.Collection;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.wecancodeit.virtualtreetdd.entity.Bean;
import org.wecancodeit.virtualtreetdd.entity.QuestionType;

@Repository //Bean Repository
public interface BeanRepository extends CrudRepository<Bean, Long> {

  Collection<Bean> findAllByQuestionType(QuestionType typeOfQuestion);

  Bean findByQuestionNum(int currentBeanQuestionNum);

  Bean findFirstByQuestionNum(int beanQuestionNum);
}
