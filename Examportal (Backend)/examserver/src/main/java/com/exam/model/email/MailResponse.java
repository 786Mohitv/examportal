package com.exam.model.email;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * @author Mohit Verma
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MailResponse {
    private String message;
    private boolean status;

}
