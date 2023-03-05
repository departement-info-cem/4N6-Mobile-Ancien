package org.sbac.model;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DepotUtilisateur extends PagingAndSortingRepository<MUtilisateur, Long> {

    Optional<MUtilisateur> findByNomUtilisateur(String nomUtilisateur);
}
