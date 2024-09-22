package dev.vishal.productservice;

import dev.vishal.productservice.models.tablePerClass.Mentors;
import dev.vishal.productservice.models.tablePerClass.Users;
import dev.vishal.productservice.repositories.CreateMentor;
import dev.vishal.productservice.repositories.CreateMentorMS;
import dev.vishal.productservice.repositories.CreateUser;
import dev.vishal.productservice.repositories.CreateUserMS;
import org.apache.catalina.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ProductServiceApplicationTests {

    @Autowired
    private CreateUser createUser;
    @Autowired
    private CreateUserMS createUserMS;
    @Autowired
    private CreateMentorMS createMentorMS;
    @Autowired
    private CreateMentor createMentor;


    @Test
    void contextLoads() {
    }

    @Test
    void testCreateUser(){
        Users user = new Users();
        user.setAge(24);
        user.setName("vishal bhalla");
        user.setEmail("nvjon@gmail.com");

        createUser.save(user);

    }

    @Test
    void testCreateMentor(){
        Mentors user = new Mentors();
        user.setAge(24);
        user.setName("vishal bhalla");
        user.setEmail("nvjon@gmail.com");
        user.setSessions(23);

        createMentor.save(user);

    }




}
