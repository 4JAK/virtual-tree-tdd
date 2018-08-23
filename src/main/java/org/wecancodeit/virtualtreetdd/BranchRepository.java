package org.wecancodeit.virtualtreetdd;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository // Branch Repository
public interface BranchRepository extends CrudRepository<Branch, Long> {}
