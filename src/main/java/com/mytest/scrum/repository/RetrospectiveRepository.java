package com.mytest.scrum.repository;

import com.mytest.scrum.model.Retrospective;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface RetrospectiveRepository extends JpaRepository<Retrospective, Long> {

    @Query("select a from Retrospective a where a.createDate = :creationDate")
    List<Retrospective> getAllByDate(@Param("creationDate") LocalDate creationDate);
}
