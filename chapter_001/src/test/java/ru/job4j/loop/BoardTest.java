package ru.job4j.loop;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class BoardTest {
    public void when3x3ThenX(){
        Board board = new Board();
        String result = board.paint(3,3);
        assertThat(result, is("x x\n x \nx x"));
    }
}
