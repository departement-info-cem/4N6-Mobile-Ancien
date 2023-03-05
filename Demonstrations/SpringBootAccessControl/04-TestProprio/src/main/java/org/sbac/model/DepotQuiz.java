package org.sbac.model;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DepotQuiz extends PagingAndSortingRepository<MQuiz, Long> {

    // Cherche dans la collections Questions, par le champ id de la classe MQuestion
    Optional<MQuiz> findByQuestionsId(Long id);
}
