package com.exam.service;

import com.exam.model.exam.Quiz;
import com.exam.model.exam.QuizLog;
import com.exam.repo.QuizLogRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.mail.Quota;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Mohit Verma
 */
@Service
public class QuizLogService {
    @Autowired
    private QuizLogRepository repo;
    public void addLog(QuizLog log){
        repo.save(log);
    }

    public List<QuizLog> getUserAttempts(String qid) {
        return  repo.findByQuizId(qid);
    }

    public List<QuizLog> getQuizAttempts(String uid) {
        return repo.findByUserId(uid);
    }
}
