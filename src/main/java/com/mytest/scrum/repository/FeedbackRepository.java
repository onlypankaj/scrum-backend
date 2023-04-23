package com.mytest.scrum.repository;

import com.mytest.scrum.model.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FeedbackRepository extends JpaRepository<Feedback, Long> {
    @Query(value = "select a.* from Feedback a where a.retro_Id = :id", nativeQuery = true)
    List<Feedback> findByRetroId(Long id);
}
