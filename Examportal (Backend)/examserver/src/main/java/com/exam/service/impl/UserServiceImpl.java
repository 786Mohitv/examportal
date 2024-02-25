package com.exam.service.impl;

import com.exam.helper.UserFoundException;
import com.exam.helper.UserNotFoundException;
import com.exam.model.Role;
import com.exam.model.User;
import com.exam.model.UserRole;
import com.exam.model.email.MailRequest;
import com.exam.model.email.MailResponse;
import com.exam.repo.RoleRepository;
import com.exam.repo.UserRepository;
import com.exam.service.EmailService;
import com.exam.service.UserService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.mail.AuthenticationFailedException;
import java.util.*;

/**
 * @author Mohit Verma
 */
@Service
@Log4j2
public class UserServiceImpl implements UserService {


    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private EmailService emailService;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    //creating user
    @Override
    public User createUser(User user, Set<UserRole> userRoles) throws AuthenticationFailedException,Exception {


        User local = this.userRepository.findByUsername(user.getUsername());
        if (local != null) {
            System.out.println("User is already there !!");
            throw new UserFoundException();
        } else {
            //user create
            for (UserRole ur : userRoles) {
                roleRepository.save(ur.getRole());
            }

            user.getUserRoles().addAll(userRoles);

            MailRequest mailRequest = new MailRequest();
            mailRequest.setTo(user.getEmail());
            mailRequest.setSubject("EXAMPORTAL | WELCOME ONBOARD");
            String link = "http://localhost:4200/login";
            String password = user.getPassword();
            Map<String, Object> mailMap = new HashMap<>();
            mailMap.put("name", user.getFirstName().toUpperCase()+" "+user.getLastName());
            mailMap.put("Username", user.getUsername());
            mailMap.put("Password", password);
            mailMap.put("link", link);
            MailResponse mailResponse = emailService.sendEmail(mailRequest, mailMap,"email-template-newUser.ftl");
            log.info("Mail Response = " + mailResponse);
            if (null != mailResponse) {
                log.info(mailResponse.getMessage());
                log.info(mailResponse.isStatus());
            }
            user.setPassword(this.bCryptPasswordEncoder.encode(user.getPassword()));
            local = this.userRepository.save(user);
        }



        return local;
    }

    //getting user by username
    @Override
    public User getUser(String username) {
        return this.userRepository.findByUsername(username);
    }

    @Override
    public void deleteUser(Long userId) {
        this.userRepository.deleteById(userId);
    }

    @Override
    public List<User> getAllUsers() {
        return this.userRepository.findAll();
    }

    @Override
    public User updateUser(User user) {


//        User toUpdate = this.userRepository.findById(user.getId()).get();
//        Optional<User> temp = Optional.of(this.userRepository.findByUsername(user.getUsername()));
//        if(temp.isPresent()){
//            System.out.println("A user with this userName already exist !");
//            return null;
//        }
//        toUpdate.setFirstName(user.getFirstName());
//        toUpdate.setLastName(user.getLastName());
//        toUpdate.setPhone(user.getPhone());
//        toUpdate.setEmail(user.getEmail());
//        toUpdate.setUsername(user.getUsername());
//        return this.userRepository.save(toUpdate);
        return this.userRepository.save(user);
    }


}
