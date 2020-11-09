package org.bbtracker.server.repo;

import org.bbtracker.server.model.MBaby;
import org.bbtracker.server.model.MBabyEvent;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MBabyEventRepository extends PagingAndSortingRepository<MBabyEvent, Long> { }
