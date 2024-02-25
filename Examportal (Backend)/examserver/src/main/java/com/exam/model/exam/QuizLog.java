package com.exam.model.exam;

import com.exam.model.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * @author Mohit Verma
 */
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class QuizLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long LogId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id")
    private User user;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "qId")
    private Quiz quiz;

    private int qAttempted;
    private int correctAns;
    private double marksGot;
    private LocalDateTime date;
}
