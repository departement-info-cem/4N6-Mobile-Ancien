package org.depinfo.omnisus.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MUserRepository extends JpaRepository<MUser, Long> {

    // this is magical, it is generated if your respect some name conventions
    // https://docs.spring.io/spring-data/data-commons/docs/1.6.1.RELEASE/reference/html/repositories.html
    Optional<MUser> findByUsername(String username);

    @Query("SELECT u.publicName, u.username, g.id, g.grade, g.name FROM MUser u INNER JOIN u.grades g ORDER BY g.grade DESC, g.editDate ASC")

    List<Object[]> findAllOrdered();
}
