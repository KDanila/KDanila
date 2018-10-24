package ru.job4j.userservlet;

import org.junit.Test;

import java.time.Clock;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class UserTest {

    @Test
    public void whenAddNewUserThenCorrectlyDataInObject(){
        Clock clock = Clock.system(ZoneId.of("Europe/Moscow"));
        //ZonedDateTime zdt = ZonedDateTime.now(clock);
        ZonedDateTime zdt2 = ZonedDateTime.of(2015, 1, 10, 15, 0, 0, 0, ZoneId.of("Europe/Moscow"));
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yy HH:mm:dd z", Locale.forLanguageTag("RU"));
        //System.out.println(zdt2.format(formatter));
        User user = new User.UserBuilder("FirstPlayer").email("sas@asd.ru").login("sldas").createDate(zdt2).build();
        System.out.println();
        assertThat(user.getCreateDate(), is(zdt2));
        assertThat(user.getEmail(), is("sas@asd.ru"));
        assertThat(user.getName(), is("FirstPlayer"));
    }

}