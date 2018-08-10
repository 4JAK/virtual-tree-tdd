package org.wecancodeit.virtualtreetdd;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository //Cluster repository
public interface ClusterRepository extends CrudRepository<Cluster, Long> {

}
