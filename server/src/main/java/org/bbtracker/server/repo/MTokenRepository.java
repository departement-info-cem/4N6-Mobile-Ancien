package org.bbtracker.server.repo;

import org.bbtracker.server.model.MToken;
import org.bbtracker.server.model.MUser;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

// TODO trouver un exemple de transaction
// https://www.baeldung.com/transaction-configuration-with-jpa-and-spring

@Repository
public interface MTokenRepository extends PagingAndSortingRepository<MToken, Long> {

    // this is magical, it is generated if your respect some name conventions
    // https://docs.spring.io/spring-data/data-commons/docs/1.6.1.RELEASE/reference/html/repositories.html
    Optional<MToken> findBySecret(String secret);
}


