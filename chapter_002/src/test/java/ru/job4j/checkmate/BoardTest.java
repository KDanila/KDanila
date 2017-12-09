package ru.job4j.checkmate;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class BoardTest {

    @Test
    public void whenPawnStepThenReturnTrue(){
        Board board = new Board();
        board.setFirstPosition();
        Cell a2= new Cell(0,1);
        Cell a4= new Cell(0,3);
        boolean result= board.move(a2,a4);
        boolean expected = true;
        assertThat(result,is(expected));
    }
}
