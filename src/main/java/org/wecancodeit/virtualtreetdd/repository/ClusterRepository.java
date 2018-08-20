package org.wecancodeit.virtualtreetdd.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.wecancodeit.virtualtreetdd.entity.Cluster;

@Repository //Cluster repository
public interface ClusterRepository extends CrudRepository<Cluster, Long> {

}
