package org.sbac.model;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepotQuestion extends PagingAndSortingRepository<MQuestion, Long> { }
