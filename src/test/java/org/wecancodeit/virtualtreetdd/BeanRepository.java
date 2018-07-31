package org.wecancodeit.virtualtreetdd;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BeanRepository extends CrudRepository<Bean, Long> {}
