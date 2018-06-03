package com.modulenotfound.flyway;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UserRepositoryIT {

    @Autowired
    private UserRepository repository;

    @Test
    public void testSaveUser() {
        User user1 = User.builder()
                .name("user1")
                .point(10)
                .build();
        User savedUser = repository.save(user1);

        int id = savedUser.getId();

        Optional<User> userOptional = repository.findById(id);
        assertThat(userOptional.get().getName(), is("user1"));
    }
}