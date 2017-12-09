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
        boolean isPossibleToMove = false;
        Cell[] way;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                Cell currentPosition = figures[i][j].getPosition();
                if (currentPosition.equals(source)) {

                    way = figures[i][j].way(source, dest);
                    for (Cell cell : way) {
                        if (cell.equals(dest)) {
                            isPossibleToMove = true;
                            break;
                        } else {
                            throw new ImposibleMoveException();
                        }
                    }

                } else {
                    throw new FigureNotFoundException();
                }
            }
        }
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                Cell currentPosition = figures[i][j].getPosition();
                if(currentPosition.equals(dest)){
                    isPossibleToMove=false;
                    throw new OccupiedWayException();
                }
            }

        }
        return isPossibleToMove;
    }

    /*
    Отображаем доску
     */
    public void showBoard() {
        /* ToDo */
    }

    public void setFirstPosition() {
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
