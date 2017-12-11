package ru.job4j.checkmate;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class BoardTest {
    /**
     * Pawn a2-a4.
     */
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
    /**
     * Bishop c1-d2 after pawn d1-d3.
     */
    @Test
    public void whenBishopStepThenReturnTrue(){
        Board board = new Board();
        board.setFirstPosition();
        Cell d1= new Cell(3,1);
        Cell d3= new Cell(3,3);
        Cell c1= new Cell(2,0);
        Cell d2= new Cell(3,1);
        board.move(d1,d3);
        boolean result= board.move(c1,d2);
        boolean expected = true;
        assertThat(result,is(expected));
    }
    /**
     * Knight 1,0- 2,2.
     */
    @Test
    public void whenKnightStepThenReturnTrue(){
        Board board = new Board();
        board.setFirstPosition();
        Cell b1= new Cell(1,0);
        Cell c3= new Cell(2,2);
        boolean result= board.move(b1,c3);
        boolean expected = true;
        assertThat(result,is(expected));
    }
    /**
     * Knight 1,0- 2,2.
     */
    @Test
    public void whenRookStepThenReturnTrue(){
        Board board = new Board();
        board.setFirstPosition();
        Cell a2= new Cell(0,1);
        Cell a4= new Cell(0,3);
        Cell a1= new Cell(0,0);
        Cell a3= new Cell(0,2);
        board.move(a2,a4);
        boolean result= board.move(a1,a3);
        boolean expected = true;
        assertThat(result,is(expected));
    }
    /**
     * Queen d1-a4.
     */
    @Test
    public void whenQueenStepThenReturnTrue(){
        Board board = new Board();
        board.setFirstPosition();
        Cell d1= new Cell(3,0);
        Cell a4= new Cell(0,3);
        Cell c1= new Cell(2,1);
        Cell c3= new Cell(2,2);
        board.move(c1,c3);
        boolean result= board.move(d1,a4);
        boolean expected = true;
        assertThat(result,is(expected));
    }
    /**
     * King d1-a4.
     */
    @Test
    public void whenKingStepThenReturnTrue(){
        Board board = new Board();
        board.setFirstPosition();
        Cell e1= new Cell(4,0);
        Cell e2= new Cell(4,1);
        Cell e3= new Cell(4,2);
        board.move(e2,e3);
        boolean result= board.move(e1,e2);
        boolean expected = true;
        assertThat(result,is(expected));
    }

}
