/*
package ru.job4j.checkmate;

*/
/**
 * Start class.
 *
 * @author Kuzmin Danila (mailto:bus1d0@mail.ru)
 * @version $Id$
 * @since 0.1.3
 *//*

public class Start {
    */
/**
     * main.
     *
     * @param args - args.
     *//*



    public static void main(String[] args) {
        Figure[][] figures = new Figure[8][8];
        setFirstPosition(figures);
        Figure search = null;
        Figure figure = figures[0][0];
        Cell a2 = new Cell(0, 1);
        Cell a4 = new Cell(0, 3);
        Cell a1 = new Cell(0, 0);
        Cell a3 = new Cell(0, 1);
        Board board = new Board();
        board.move(a2, a4);
        board.move(a1,a3);
    }


    private static void setFirstPosition(Figure[][] figures) {
        for (int i = 0; i < 8; i++) {
            figures[i][1] = new Pawn(new Cell(i, 1));
            figures[i][6] = new Pawn(new Cell(i, 6));
            figures[i][6].isWhite = false;
        }

        figures[0][0] = new Rook(new Cell(0, 0));
        figures[0][7] = new Rook(new Cell(0, 7));
        figures[0][7].isWhite = false;
        figures[7][0] = new Rook(new Cell(7, 0));
        figures[7][7] = new Rook(new Cell(7, 7));
        figures[7][7].isWhite = false;

        figures[1][0] = new Knight(new Cell(1, 0));
        figures[6][0] = new Knight(new Cell(6, 0));
        figures[1][7] = new Knight(new Cell(1, 7));
        figures[1][7].isWhite = false;
        figures[6][7] = new Knight(new Cell(6, 7));
        figures[6][7].isWhite = false;

        figures[2][0] = new Bishop(new Cell(2, 0));
        figures[5][0] = new Bishop(new Cell(5, 0));
        figures[2][7] = new Bishop(new Cell(2, 7));
        figures[2][7].isWhite = false;
        figures[5][7] = new Bishop(new Cell(5, 7));
        figures[5][7].isWhite = false;

        figures[4][0] = new King((new Cell(4, 0)));
        figures[4][7] = new King((new Cell(4, 7)));
        figures[4][7].isWhite = false;

        figures[3][0] = new Queen((new Cell(3, 0)));
        figures[3][7] = new Queen((new Cell(3, 7)));
    }
}







*/
