package org.bbtracker.server.model;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends PagingAndSortingRepository<TestEntity, Long> {

    // this is magical, it is generated if your respect some name conventions
    // https://docs.spring.io/spring-data/data-commons/docs/1.6.1.RELEASE/reference/html/repositories.html
    List<TestEntity> findByPipo(String pipo);
}
