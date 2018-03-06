package ru.job4j.userconvert;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * UserConvertTest class.
 */

public class UserConvertTest {
    /**
     * The First Test.
     */
    @Test
    public void processFirstTest() {
        UserConvert uc = new UserConvert();
        HashMap<Integer, User> hm = new HashMap<Integer, User>();
        List<User> users = new ArrayList<User>();
        users.add(new User(1, "Alexey", "Moscow"));
        users.add(new User(2, "Boris", "Bryansk"));
        users.add(new User(3, "Vladislav", "Vladimir"));
        users.add(new User(4, "Genadyi", "Gjel"));
        hm = uc.process(users);
        List<Integer> idResult = new ArrayList<Integer>();
        for (Integer i : hm.keySet()) {
            idResult.add(i);
        }
        List<Integer> idExpected = new ArrayList<Integer>();
        idExpected.add(1);
        idExpected.add(2);
        idExpected.add(3);
        idExpected.add(4);
        assertThat(idResult, is(idExpected));
    }

    /**
     * The second Test.
     */
    @Test
    public void processSecondTestDoubleData() {
        UserConvert uc = new UserConvert();
        HashMap<Integer, User> hm = new HashMap<Integer, User>();
        List<User> users = new ArrayList<User>();
        users.add(new User(1, "Alexey", "Moscow"));
        users.add(new User(2, "Boris", "Bryansk"));
        users.add(new User(2, "Boris", "Bryansk"));
        users.add(new User(3, "Vladislav", "Vladimir"));
        users.add(new User(4, "Genadyi", "Gjel"));
        users.add(new User(4, "Genadyi", "Gjel"));
        hm = uc.process(users);
        List<Integer> idResult = new ArrayList<Integer>();
        for (Integer i : hm.keySet()) {
            idResult.add(i);
        }
        List<Integer> idExpected = new ArrayList<Integer>();
        idExpected.add(1);
        idExpected.add(2);
        idExpected.add(3);
        idExpected.add(4);
        assertThat(idResult, is(idExpected));
    }
}

