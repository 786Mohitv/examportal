package com.exam.service;

import com.exam.model.User;
import com.exam.model.UserRole;

import java.util.List;
import java.util.Set;
/**
 * @author Mohit Verma
 */
public interface UserService {

    //creating user
    public User createUser(User user, Set<UserRole> userRoles) throws Exception;

    //get user by username
    public User getUser(String username);

    //delete user by id
    public void deleteUser(Long userId);

    public List<User> getAllUsers();

    User updateUser(User user);
}
