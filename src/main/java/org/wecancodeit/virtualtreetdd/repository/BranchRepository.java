package org.wecancodeit.virtualtreetdd.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.wecancodeit.virtualtreetdd.entity.Branch;

@Repository //Branch Repository
public interface BranchRepository extends CrudRepository<Branch, Long> {}
