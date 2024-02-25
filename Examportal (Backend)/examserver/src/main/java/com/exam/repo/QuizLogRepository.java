package com.exam.repo;

import com.exam.model.exam.QuizLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Mohit Verma
 */
@Repository
public interface QuizLogRepository extends JpaRepository<QuizLog,Long> {
    @Query(value = "Select * from quiz_log where q_id=?1",nativeQuery = true)
    List<QuizLog> findByQuizId(String qid);
    @Query(value = "Select * from quiz_log where id=?1",nativeQuery = true)
    List<QuizLog> findByUserId(String uid);
}
