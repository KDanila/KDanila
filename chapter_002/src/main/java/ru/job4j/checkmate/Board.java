package ru.job4j.checkmate;

public class Board {
    Figure[][] figures = new Figure[8][8];

    /*
    Метод должен проверить
   - Что в заданной ячейки есть фигура. если нет. то выкинуть исключение
   - Если фигура есть. Проверить может ли она так двигаться. Если нет то упадет исключение
   - Проверить что полученный путь. не занят фигурами. Если занят выкинуть исключение
   - Если все отлично. Записать в ячейку новое новое положение Figure figure.clone(Cell dest)
     */
    boolean move(Cell source, Cell dest) throws ImposibleMoveException, OccupiedWayException, FigureNotFoundException {
        return false;
    }

    /*
    Отображаем доску
     */
    public void showBoard() {
        /* ToDo */
    }

    public void setFirstPosition() {

        Pawn a2 = new Pawn(new Cell(0, 1));
        Pawn b2 = new Pawn(new Cell(1, 1));
        Pawn c2 = new Pawn(new Cell(2, 1));
        Pawn d2 = new Pawn(new Cell(3, 1));
        Pawn e2 = new Pawn(new Cell(4, 1));
        Pawn f2 = new Pawn(new Cell(5, 1));
        Pawn g2 = new Pawn(new Cell(6, 1));
        Pawn h2 = new Pawn(new Cell(7, 1));

        Pawn a7 = new Pawn(new Cell(0, 6));
        a2.isWhite = false;
        Pawn b7 = new Pawn(new Cell(1, 6));
        a2.isWhite = false;
        Pawn c7 = new Pawn(new Cell(2, 6));
        a2.isWhite = false;
        Pawn d7 = new Pawn(new Cell(3, 6));
        a2.isWhite = false;
        Pawn e7 = new Pawn(new Cell(4, 6));
        a2.isWhite = false;
        Pawn f7 = new Pawn(new Cell(5, 6));
        a2.isWhite = false;
        Pawn g7 = new Pawn(new Cell(6, 6));
        a2.isWhite = false;
        Pawn h7 = new Pawn(new Cell(7, 6));
        a2.isWhite = false;

        Rook a1 = new Rook(new Cell(0, 0));
        Rook a8 = new Rook(new Cell(0, 7));
        a8.isWhite = false;
        Rook h1 = new Rook(new Cell(7, 0));
        Rook h8 = new Rook(new Cell(7, 7));
        h8.isWhite = false;

        Knight b1 = new Knight(new Cell(1, 0));
        Knight g1 = new Knight(new Cell(6, 0));
        Knight b8 = new Knight(new Cell(1, 7));
        b8.isWhite = false;
        Knight g8 = new Knight(new Cell(6, 7));
        g8.isWhite = false;

        Bishop c1 = new Bishop(new Cell(2, 0));
        Bishop f1 = new Bishop(new Cell(5, 0));
        Bishop c8 = new Bishop(new Cell(2, 7));
        c8.isWhite = false;
        Bishop f8 = new Bishop(new Cell(5, 7));
        f8.isWhite = false;

        King e1 = new King((new Cell(4,0)));
        King e8 = new King((new Cell(4,7)));
        e8.isWhite= false;

        Queen d1 = new Queen((new Cell(3,0)));
        Queen d8 = new Queen((new Cell(3,7)));
    }
}
