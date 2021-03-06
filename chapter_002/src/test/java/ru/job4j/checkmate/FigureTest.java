/*
package ru.job4j.checkmate;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

*/
/**
 * Figure test class.
 *
 * @author Kuzmin Danila (mailto:bus1d0@mail.ru)
 * @version $Id$
 * @since 0.1.3
 *//*


public class FigureTest {

    */
/**
     * Тест на возможные ходы белой пешки, если ход первый.
     *//*

    @Test
    public void whenPawnUseWayThenReturnCorrectCellArray() {
        Cell first = new Cell(0, 1);
        Cell dist = new Cell(0, 3);
        Pawn pawn = new Pawn(first);
        Cell[] result = pawn.way(first, dist);
        int[] resultInt = {result[0].getX(), result[0].getY(), result[1].getX(), result[1].getY()};
        int[] expected = {0, 2, 0, 3};
        assertThat(resultInt, is(expected));
    }

    */
/**
     * Тест на возможные ходы белой пешки, если ход не первый.
     *//*

    @Test
    public void whenPawnUseWayMoreThanOneTimeThenReturnCorrectCellArray() {
        Cell first = new Cell(1, 1);
        Cell dist = new Cell(1, 2);
        Pawn pawn = new Pawn(first);
        pawn.firstStep = false;
        Cell[] result = pawn.way(first, dist);
        int[] resultInt = {result[0].getX(), result[0].getY()};
        int[] expected = {1, 2};
        assertThat(resultInt, is(expected));
    }

    */
/**
     * Тест на возможные ходы черной пешки, если ход не первый.
     *//*

    @Test
    public void whenPawnBlackUseWayMoreThanOneTimeThenReturnCorrectCellArray() {
        Cell first = new Cell(7, 7);
        Cell dist = new Cell(7, 6);
        Pawn pawn = new Pawn(first);
        pawn.isWhite = false;
        pawn.firstStep = false;
        Cell[] result = pawn.way(first, dist);
        int[] resultInt = {result[0].getX(), result[0].getY()};
        int[] expected = {7, 6};
        assertThat(resultInt, is(expected));
    }

    */
/**
     * Тест на возможные ходы черной пешки, если ход первый.
     *//*

    @Test
    public void whenPawnBlackUseWayThenReturnCorrectCellArray() {
        Cell first = new Cell(6, 7);
        Cell dist = new Cell(6, 5);
        Pawn pawn = new Pawn(first);
        pawn.isWhite = false;
        Cell[] result = pawn.way(first, dist);
        int[] resultInt = {result[0].getX(), result[0].getY(), result[1].getX(), result[1].getY()};
        int[] expected = {6, 6, 6, 5};
        assertThat(resultInt, is(expected));
    }

    */
/**
     * Ладья ходит по вертикали вверх.
     *//*

    @Test
    public void whenRockUseWatToUpThenCorrectCellArray() {
        Cell first = new Cell(0, 0);
        Cell dist = new Cell(0, 7);
        Rook rook = new Rook(first);
        Cell[] result = rook.way(first, dist);
        int[] resultInt = {result[0].getX(), result[0].getY(), result[1].getX(), result[1].getY(),
                result[2].getX(), result[2].getY(), result[3].getX(), result[3].getY(), result[4].getX(), result[4].getY(),
                result[5].getX(), result[5].getY(), result[6].getX(), result[6].getY()};
        int[] expected = {0, 1, 0, 2, 0, 3, 0, 4, 0, 5, 0, 6, 0, 7};
        assertThat(resultInt, is(expected));

    }

    */
/**
     * Ладья ходит по вертикали вниз(Массив выдается по возрастанию).
     *//*

    @Test
    public void whenRockUseWatToDownThenCorrectCellArray() {
        Cell first = new Cell(7, 0);
        Cell dist = new Cell(5, 0);
        Rook rook = new Rook(first);
        Cell[] result = rook.way(first, dist);
        int[] resultInt = {result[0].getX(), result[0].getY(), result[1].getX(), result[1].getY()};
        int[] expected = {5, 0, 6, 0};
        assertThat(resultInt, is(expected));

    }

    */
/**
     * Конь ходит Г.
     *//*

    @Test
    public void whenKnightMoveThenCorrectCellArray() {
        Cell first = new Cell(0, 0);
        Cell dist = new Cell(1, 2);
        Knight knight = new Knight(first);
        Cell[] result = knight.way(first, dist);
        int[] resultInt = {result[0].getX(), result[0].getY()};
        int[] expected = {1, 2};
        assertThat(resultInt, is(expected));

    }

    */
/**
     * Конь ходит 2.
     *//*

    @Test
    public void whenKnightMoveSecondThenCorrectCellArray() {
        Cell first = new Cell(3, 4);
        Cell dist = new Cell(2, 2);
        Knight knight = new Knight(first);
        Cell[] result = knight.way(first, dist);
        int[] resultInt = {result[0].getX(), result[0].getY()};
        int[] expected = {2, 2};
        assertThat(resultInt, is(expected));

    }

    */
/**
     * Слон с 0 0---->2 2.
     *//*


    @Test
    public void whenBishopMoveThenCorrectCellArray() {
        Cell first = new Cell(0, 0);
        Cell dist = new Cell(2, 2);
        Bishop bishop = new Bishop(first);
        Cell[] result = bishop.way(first, dist);
        int[] resultInt = {result[0].getX(), result[0].getY(), result[1].getX(), result[1].getY()};
        int[] expected = {1, 1, 2, 2};
        assertThat(resultInt, is(expected));
    }

    */
/**
     * Слон с 4 5 ----> 0 1.
     *//*


    @Test
    public void whenBishopMoveSecondThenCorrectCellArray() {
        Cell first = new Cell(4, 5);
        Cell dist = new Cell(0, 1);
        Bishop bishop = new Bishop(first);
        Cell[] result = bishop.way(first, dist);
        int[] resultInt = {result[0].getX(), result[0].getY(), result[1].getX(), result[1].getY(),
                result[2].getX(), result[2].getY(), result[3].getX(), result[3].getY()};
        int[] expected = {3, 4, 2, 3, 1, 2, 0, 1};
        assertThat(resultInt, is(expected));
    }


    */
/**
     * Слон с 1 6 ----> 7 7.
     *//*


    @Test
    public void whenBishopMoveThirdThenCorrectCellArray() {
        Cell first = new Cell(1, 6);
        Cell dist = new Cell(3, 4);
        Bishop bishop = new Bishop(first);
        Cell[] result = bishop.way(first, dist);
        int[] resultInt = {result[0].getX(), result[0].getY(), result[1].getX(), result[1].getY()};
        int[] expected = {2, 5, 3, 4};
        assertThat(resultInt, is(expected));
    }

    */
/**
     * Слон с 3 1 ----> 1 3.
     *//*


    @Test
    public void whenBishopMoveFourthThenCorrectCellArray() {
        Cell first = new Cell(3, 1);
        Cell dist = new Cell(1, 3);
        Bishop bishop = new Bishop(first);
        Cell[] result = bishop.way(first, dist);
        int[] resultInt = {result[0].getX(), result[0].getY(), result[1].getX(), result[1].getY()};
        int[] expected = {2, 2, 1, 3};
        assertThat(resultInt, is(expected));
    }

    */
/**
     * Король 0,0 ---- 1,1.
     *//*

    @Test
    public void whenKingMoveThenCorrectCellArray() {
        Cell first = new Cell(0, 0);
        Cell dist = new Cell(1, 1);
        King king = new King(first);
        Cell[] result = king.way(first, dist);
        int[] resultInt = {result[0].getX(), result[0].getY()};
        int[] expected = {1, 1};
        assertThat(resultInt, is(expected));

    }

    */
/**
     * Король 5,5 ---- 5,4.
     *//*

    @Test
    public void whenKingMoveSecondThenCorrectCellArray() {
        Cell first = new Cell(5, 5);
        Cell dist = new Cell(5, 4);
        King king = new King(first);
        Cell[] result = king.way(first, dist);
        int[] resultInt = {result[0].getX(), result[0].getY()};
        int[] expected = {5, 4};
        assertThat(resultInt, is(expected));

    }

    */
/**
     * Ферзь 3,3 ---- 0,3.
     *//*

    @Test
    public void whenQueenMoveThenCorrectCellArray() {
        Cell first = new Cell(3, 3);
        Cell dist = new Cell(0, 3);
        Queen queen = new Queen(first);
        Cell[] result = queen.way(first, dist);
        int[] resultInt = {result[0].getX(), result[0].getY(), result[1].getX(), result[1].getY(), result[2].getX(), result[2].getY()};
        int[] expected = {0, 3, 1, 3, 2, 3};
        assertThat(resultInt, is(expected));

    }

    */
/**
     * Ферзь 0,7 ---- 0,0.
     *//*

    @Test
    public void whenQueenMoveSecondThenCorrectCellArray() {
        Cell first = new Cell(0, 7);
        Cell dist = new Cell(0, 0);
        Queen queen = new Queen(first);
        Cell[] result = queen.way(first, dist);
        int[] resultInt = {result[0].getX(), result[0].getY(), result[1].getX(), result[1].getY(), result[2].getX(), result[2].getY(),
                result[3].getX(), result[3].getY(), result[4].getX(), result[4].getY(), result[5].getX(), result[5].getY(),
                result[6].getX(), result[6].getY()};
        int[] expected = {0, 0, 0, 1, 0, 2, 0, 3, 0, 4, 0, 5, 0, 6};
        assertThat(resultInt, is(expected));

    }

    */
/**
     * Ферзь 0,7 ---- 0,0.
     *//*

    @Test
    public void whenQueenMoveThirdThenCorrectCellArray() {
        Cell first = new Cell(3, 3);
        Cell dist = new Cell(0, 0);
        Queen queen = new Queen(first);
        Cell[] result = queen.way(first, dist);
        int[] resultInt = {result[0].getX(), result[0].getY(), result[1].getX(), result[1].getY(), result[2].getX(), result[2].getY()};
        int[] expected = {2, 2, 1, 1, 0, 0};
        assertThat(resultInt, is(expected));

    }
}

*/
