package ru.job4j.userservlet;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class ValidateServiceTest {

    User user1 = new User.UserBuilder("Artem").build();
    User user2 = new User.UserBuilder("Egor").build();
    User user3 = new User.UserBuilder("Semen").build();

    @Test
    public void whenAddThreeUsersThenCorrect(){
        ValidateService validateService = ValidateService.getInstance();
        validateService.add(user1);
        validateService.add(user2);
        validateService.add(user3);
        assertThat(user1, is(validateService.findById(user1.getId())));
        assertThat(user2, is(validateService.findById(user2.getId())));
        assertThat(user3, is(validateService.findById(user3.getId())));
    }

    @Test
    public void whenUpdateUserThenCorrect(){
        ValidateService validateService = ValidateService.getInstance();
        validateService.add(user1);
        user1 = user2;
        validateService.update(user1);
        assertThat(user1, is(validateService.findById(user2.getId())));
    }
//todo delete method
    @Test
    public void whenDeleteUserThenCorrect(){
        ValidateService validateService = ValidateService.getInstance();
        validateService.add(user1);
        assertThat(validateService.delete(user1), is(true));
        System.out.println(validateService.findAll().size());
    }

}