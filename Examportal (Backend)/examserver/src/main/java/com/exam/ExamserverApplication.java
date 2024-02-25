package com.exam;

import com.exam.helper.UserFoundException;
import com.exam.model.Role;
import com.exam.model.User;
import com.exam.model.UserRole;
import com.exam.model.exam.Quiz;
import com.exam.repo.QuizRepository;
import com.exam.repo.UserRepository;
import com.exam.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
/**
 * @author Mohit Verma
 */
@SpringBootApplication
public class ExamserverApplication implements CommandLineRunner {

    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository repo;


    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;


    public static void main(String[] args) {


        SpringApplication.run(ExamserverApplication.class, args);


    }

    @Override
    public void run(String... args) throws Exception {
        try {


            System.out.println("starting code");

            if (repo.findByUsername("mohitv786") == null) {
//
                User user = new User();

                user.setFirstName("Mohit");
                user.setLastName("Verma");
                user.setUsername("mohitv786");
                user.setPassword("mohit123");
                user.setEmail("giftaslife@gmail.com");
                user.setPhone("7340295256");
                user.setProfile("default.png");

                Role role1 = new Role();
                role1.setRoleId(0001L);
                role1.setRoleName("ADMIN");

                Set<UserRole> userRoleSet = new HashSet<>();
                UserRole userRole = new UserRole();

                userRole.setRole(role1);

                userRole.setUser(user);

                userRoleSet.add(userRole);

                User user1 = this.userService.createUser(user, userRoleSet);
                System.out.println(user1.getUsername());
            }

            } catch(UserFoundException e){
                e.printStackTrace();


            }



    }


}
