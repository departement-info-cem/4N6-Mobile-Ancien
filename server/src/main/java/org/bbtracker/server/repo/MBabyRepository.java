package org.bbtracker.server.repo;

import org.bbtracker.server.model.MBaby;
import org.bbtracker.server.model.MUser;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MBabyRepository extends PagingAndSortingRepository<MBaby, Long> { }
