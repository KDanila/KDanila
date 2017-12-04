package ru.job4j.checkmate;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


public class FigureTest {

    /**
     * Тест на возможные ходы белой пешки, если ход первый.
     */
    @Test
    public void whenPawnUseWayThenReturnCorrectCellArray() {
        Cell first = new Cell(0, 1);
        Cell dist = new Cell(0, 3);
        Pawn pawn = new Pawn(first);
        Cell[] result = pawn.way(first, dist);
        int[] resultInt = {result[0].x, result[0].y, result[1].x, result[1].y};
        int[] expected = {0, 2, 0, 3};
        assertThat(resultInt, is(expected));
    }

    /**
     * Тест на возможные ходы белой пешки, если ход не первый.
     */
    @Test
    public void whenPawnUseWayMoreThanOneTimeThenReturnCorrectCellArray() {
        Cell first = new Cell(1, 1);
        Cell dist = new Cell(1, 2);
        Pawn pawn = new Pawn(first);
        pawn.firstStep = false;
        Cell[] result = pawn.way(first, dist);
        int[] resultInt = {result[0].x, result[0].y};
        int[] expected = {1, 2};
        assertThat(resultInt, is(expected));
    }

    /**
     * Тест на возможные ходы черной пешки, если ход не первый.
     */
    @Test
    public void whenPawnBlackUseWayMoreThanOneTimeThenReturnCorrectCellArray() {
        Cell first = new Cell(7, 7);
        Cell dist = new Cell(7, 6);
        Pawn pawn = new Pawn(first);
        pawn.isWhite = false;
        pawn.firstStep = false;
        Cell[] result = pawn.way(first, dist);
        int[] resultInt = {result[0].x, result[0].y};
        int[] expected = {7, 6};
        assertThat(resultInt, is(expected));
    }

    /**
     * Тест на возможные ходы черной пешки, если ход первый.
     */
    @Test
    public void whenPawnBlackUseWayThenReturnCorrectCellArray() {
        Cell first = new Cell(6, 7);
        Cell dist = new Cell(6, 5);
        Pawn pawn = new Pawn(first);
        pawn.isWhite = false;
        Cell[] result = pawn.way(first, dist);
        int[] resultInt = {result[0].x, result[0].y, result[1].x, result[1].y};
        int[] expected = {6, 6, 6, 5};
        assertThat(resultInt, is(expected));
    }

    /**
     * Ладья ходит по вертикали вверх.
     */
    @Test
    public void whenRockUseWatToUpThenCorrectCellArray() {
        Cell first = new Cell(0, 0);
        Cell dist = new Cell(0, 7);
        Rook rook = new Rook(first);
        Cell[] result = rook.way(first, dist);
        int[] resultInt = {result[0].x, result[0].y, result[1].x, result[1].y,
                result[2].x, result[2].y, result[3].x, result[3].y, result[4].x, result[4].y,
                result[5].x, result[5].y, result[6].x, result[6].y,};
        int[] expected = {0, 1, 0, 2, 0, 3, 0, 4, 0, 5, 0, 6, 0, 7};
        assertThat(resultInt, is(expected));

    }

    /**
     * Ладья ходит по вертикали вниз(Массив выдается по возрастанию).
     */
    @Test
    public void whenRockUseWatToDownThenCorrectCellArray() {
        Cell first = new Cell(8, 0);
        Cell dist = new Cell(6, 0);
        Rook rook = new Rook(first);
        Cell[] result = rook.way(first, dist);
        int[] resultInt = {result[0].x, result[0].y, result[1].x, result[1].y};
        int[] expected = {6, 0, 7, 0};
        assertThat(resultInt, is(expected));

    }

    /**
     * Конь ходит Г
     */
    @Test
    public void whenKnightMoveThenCorrectCellArray() {
        Cell first = new Cell(0, 0);
        Cell dist = new Cell(1, 2);
        Knight knight = new Knight(first);
        Cell[] result = knight.way(first, dist);
        int[] resultInt = {result[0].x, result[0].y};
        int[] expected = {1, 2};
        assertThat(resultInt, is(expected));

    }

    /**
     * Конь ходит 2.
     */
    @Test
    public void whenKnightMoveSecondThenCorrectCellArray() {
        Cell first = new Cell(3, 4);
        Cell dist = new Cell(2, 2);
        Knight knight = new Knight(first);
        Cell[] result = knight.way(first, dist);
        int[] resultInt = {result[0].x, result[0].y};
        int[] expected = {2, 2};
        assertThat(resultInt, is(expected));

    }

    /**
     * Слон с 0 0 ----> 2 2.
     */
    @Test
    public void whenBishopMoveThenCorrectCellArray() {
        Cell first = new Cell(0, 0);
        Cell dist = new Cell(2, 2);
        Bishop bishop = new Bishop(first);
        Cell[] result = bishop.way(first, dist);
        int[] resultInt = {result[0].x, result[0].y, result[1].x, result[1].y};
        int[] expected = {2, 2, 1, 1};
        assertThat(resultInt, is(expected));
    }

    /**
     * Слон с 4 5 ----> 0 1.
     */
    @Test
    public void whenBishopMoveSecondThenCorrectCellArray() {
        Cell first = new Cell(4, 5);
        Cell dist = new Cell(0, 1);
        Bishop bishop = new Bishop(first);
        Cell[] result = bishop.way(first, dist);
        int[] resultInt = {result[0].x, result[0].y, result[1].x, result[1].y,
                result[2].x, result[2].y, result[3].x, result[3].y};
        int[] expected = {0, 1, 1, 2, 2, 3, 3, 4};
        assertThat(resultInt, is(expected));
    }

    /**
     * Слон с 1 6 ----> 7 7.
     */
    @Test
    public void whenBishopMoveThirdThenCorrectCellArray() {
        Cell first = new Cell(1, 6);
        Cell dist = new Cell(3, 4);
        Bishop bishop = new Bishop(first);
        Cell[] result = bishop.way(first, dist);
        int[] resultInt = {result[0].x, result[0].y, result[1].x, result[1].y};
        int[] expected = {3, 4, 2, 5};
        assertThat(resultInt, is(expected));
    }
    /**
     * Слон с 3 1 ----> 1 3.
     */
    @Test
    public void whenBishopMoveFouthThenCorrectCellArray() {
        Cell first = new Cell(3, 1);
        Cell dist = new Cell(1, 3);
        Bishop bishop = new Bishop(first);
        Cell[] result = bishop.way(first, dist);
        int[] resultInt = {result[0].x, result[0].y, result[1].x, result[1].y};
        int[] expected = {2, 2, 1, 3};
        assertThat(resultInt, is(expected));
    }

}

