package org.depinfo.omnisus.grade;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface MGradeRepository extends JpaRepository<MGrade, Long> {
}
