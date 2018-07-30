package org.wecancodeit.virtualtreetdd;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VirtualTreeRepository extends CrudRepository<VirtualTree, Long> {
	
}