package com.exam.model;

import com.exam.model.exam.Question;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/**
 * @author Mohit Verma
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class EvalReq {
    private Long quiz_id;
    private Long user_id;
    private List<Question> questions;
}
