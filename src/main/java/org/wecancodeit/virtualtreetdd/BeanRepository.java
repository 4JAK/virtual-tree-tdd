package org.wecancodeit.virtualtreetdd;

import java.util.Collection;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository // Bean Repository
public interface BeanRepository extends CrudRepository<Bean, Long> {

  Collection<Bean> findAllByQuestionType(QuestionType typeOfQuestion);

  Bean findByQuestionNum(int currentBeanQuestionNum);

  Bean findFirstByQuestionNum(int beanQuestionNum);
}
