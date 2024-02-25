package com.exam.model;

import org.springframework.security.core.GrantedAuthority;
/**
 * @author Mohit Verma
 */
public class Authority implements GrantedAuthority {

    private String authority;

    public Authority(String authority) {
        this.authority = authority;
    }

    @Override
    public String getAuthority() {
        return this.authority;
    }
}
