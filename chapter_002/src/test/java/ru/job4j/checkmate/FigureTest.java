package ru.job4j.checkmate;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;



public class FigureTest {

    /**
     * Тест на возможные ходы пешки, если ход первый.
     */
    @Test
    public void whenPawnUseWayThenReturnCorrectCellArray() {
        Cell first = new Cell(0,1);
        Cell dist = new Cell(0,3);
        Pawn pawn = new Pawn(first);
        Cell[] result = pawn.way(first,dist);
        int[] resultInt = {result[0].x,result[0].y,result[1].x,result[1].y};
        int[] expected = {0,2,0,3};
        assertThat(resultInt, is(expected));
    }
    /**
     * Тест на возможные ходы пешки, если ход не первый.
     */
    @Test
    public void whenPawnUseWayMoreThanOneTimeThenReturnCorrectCellArray() {
        Cell first = new Cell(1,1);
        Cell dist = new Cell(1,2);
        Pawn pawn = new Pawn(first);
        pawn.firstStep=false;
        Cell[] result = pawn.way(first,dist);
        int[] resultInt = {result[0].x,result[0].y};
        int[] expected = {1,2};
        assertThat(resultInt, is(expected));
    }

}

