package org.bbtracker.server.repo;

import org.bbtracker.server.model.MUser;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MUserRepository extends PagingAndSortingRepository<MUser, Long> {

    // this is magical, it is generated if your respect some name conventions
    // https://docs.spring.io/spring-data/data-commons/docs/1.6.1.RELEASE/reference/html/repositories.html
    Optional<MUser> findByUsername(String username);
}
