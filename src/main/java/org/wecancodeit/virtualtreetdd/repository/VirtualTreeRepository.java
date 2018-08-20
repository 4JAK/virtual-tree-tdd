package org.wecancodeit.virtualtreetdd.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.wecancodeit.virtualtreetdd.entity.VirtualTree;
//Tree repository (Java is a single tree)
@Repository 
public interface VirtualTreeRepository extends CrudRepository<VirtualTree, Long> {
  // Search by the name of the tree
  VirtualTree findByName(String treeName);
}
