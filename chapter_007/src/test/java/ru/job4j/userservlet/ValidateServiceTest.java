package ru.job4j.userservlet;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * ValidateServiceTest class.
 *
 * @author Kuzmin Danila (mailto:bus1d0@mail.ru)
 * @version $Id$
 * @since 0.1.0
 */
public class ValidateServiceTest {
    /**
     * user1.
     */
    private User user1 = new User.UserBuilder("Artem").build();
    /**
     * user2.
     */
    private User user2 = new User.UserBuilder("Egor").build();
    /**
     * user3.
     */
    private User user3 = new User.UserBuilder("Semen").build();

    /**
     * whenAddThreeUsersThenCorrect.
     */
    @Test
    public void whenAddThreeUsersThenCorrect() {
        ValidateService validateService = ValidateService.getInstance();
        validateService.add(user1);
        validateService.add(user2);
        validateService.add(user3);
        assertThat(user1, is(validateService.findById(user1.getId())));
        assertThat(user2, is(validateService.findById(user2.getId())));
        assertThat(user3, is(validateService.findById(user3.getId())));
    }

    /**
     * whenUpdateUserThenCorrect.
     */
    @Test
    public void whenUpdateUserThenCorrect() {
        ValidateService validateService = ValidateService.getInstance();
        validateService.add(user1);
        validateService.add(user2);
        user1.setEmail("1");
        user1.setLogin("1");
        System.out.println(user1);
        System.out.println(user2);
        user2.setEmail("2");
        user2.setLogin("2");
        validateService.update(String.valueOf(user1.getId()),user2);
        System.out.println(user1);
        System.out.println(user2);
        assertThat(user1.getName(), is(validateService.findById(user2.getId()).getName()));
    }

    @Test
    public void whenUserNotUniqueThenReturnFalse() {
        ValidateService validateService = ValidateService.getInstance();
        validateService.add(user1);
        //validateService.add(user2);
        user1.setEmail("1");
        user1.setLogin("1");
        user2.setEmail("1");
        user2.setLogin("1");
        user2.setName(user1.getName());
        boolean bb = true;
        String login = user1.getLogin();
        String email = user1.getEmail();
        if(login==null||email==null){
            bb = false;
        }
        bb = validateService.findAll().values().stream().anyMatch(u-> u.equals(user2));
        assertThat(bb,is(true));
    }

        /**
         * whenDeleteUserThenCorrect.
         */
    @Test
    public void whenDeleteUserThenCorrect() {
        ValidateService validateService = ValidateService.getInstance();
        validateService.add(user1);
        assertThat(validateService.delete(user1), is(true));
    }

    /**
     * whenUseFindAllThenReturnAllUsers.
     */
    @Test
    public void whenUseFindAllThenReturnAllUsers() {
        ValidateService validateService = ValidateService.getInstance();
        validateService.add(user1);
        validateService.add(user2);
        validateService.add(user3);
        assertThat(validateService.findAll().get(user1.getId()).getName(), is("Artem"));
        assertThat(validateService.findAll().get(user2.getId()).getName(), is("Egor"));
        assertThat(validateService.findAll().get(user3.getId()).getName(), is("Semen"));
    }
    /**
     *
     */
    @Test
    public void whenUserNotUniqueThanFalse() {
        ValidateService validateService = ValidateService.getInstance();
        validateService.add(user1);
        validateService.add(user2);
        validateService.add(user3);
        assertThat(validateService.findAll().get(user1.getId()).getName(), is("Artem"));
        assertThat(validateService.findAll().get(user2.getId()).getName(), is("Egor"));
        assertThat(validateService.findAll().get(user3.getId()).getName(), is("Semen"));
    }

    @Test
    public void whenCreateValidateServiceShouldCreateDefaultAdminUser() {
        ValidateService validateService = ValidateService.getInstance();
        User admin = validateService.findAll().values().stream().findFirst().get();
        assertThat(admin.getName(), is("admin"));
        assertThat(admin.getPassword(), is("admin"));
    }

    @Test
    public void whenisAccessAllowedForAdminShouldReturnTrue() {
        ValidateService validateService = ValidateService.getInstance();
        assertThat(validateService.isAccessAllowed("admin", "admin"), is(true));
    }
}