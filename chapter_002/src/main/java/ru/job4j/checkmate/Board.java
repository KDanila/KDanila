package ru.job4j.checkmate;

/**
 * Board class.
 *
 * @author Kuzmin Danila (mailto:bus1d0@mail.ru)
 * @version $Id$
 * @since 0.1.3
 */
public class Board {
    /**
     * figures array.
     */
    Figure[][] figures = new Figure[8][8];

    /**
     * @param source from.
     * @param dest   to.
     * @return possibility of move.
     * @throws ImposibleMoveException - ImposibleMoveException.
     * @throws OccupiedWayException - OccupiedWayException.
     * @throws FigureNotFoundException - FigureNotFoundException.
     */
    boolean move(Cell source, Cell dest) throws ImposibleMoveException, OccupiedWayException, FigureNotFoundException {
        boolean isPossibleToMove = false;
        Cell[] way;
        int xOfFigure = 0;
        int yOfFigure = 0;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (figures[i][j] != null) {
                    Cell currentPosition = figures[i][j].getCurrentPosition();
                    if (currentPosition.equals(source)) {
                        xOfFigure = i;
                        yOfFigure = j;
                        way = figures[i][j].way(source, dest);
                        for (Cell cell : way) {
                            if (cell.equals(dest)) {
                                isPossibleToMove = true;
                                break;
                            }
                        }
                        if (!isPossibleToMove) {
                            throw new ImposibleMoveException();
                        }
                        for (int k = 0; k < 8; k++) {
                            for (int l = 0; l < 8; l++) {
                                for (int m = 0; m < way.length - 1; m++) {
                                    if (figures[k][l] != null) {
                                        if (way[m].equals(figures[k][l].getCurrentPosition()) && !way[m].equals(dest)) {
                                            isPossibleToMove = false;
                                            throw new OccupiedWayException();
                                        }
                                    }
                                }
                            }

                        }

                    }
                }
            }
        }
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (figures[i][j] != null) {
                    Cell currentPosition = figures[i][j].getCurrentPosition();
                    if (currentPosition.equals(dest)) {
                        isPossibleToMove = false;
                        throw new OccupiedWayException();
                    }
                }
            }

        }
        if (isPossibleToMove) {
            figures[xOfFigure][yOfFigure].setCurrentPosition(dest);
        }
        return isPossibleToMove;
    }


    /**
     * Set first position of figures.
     */
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
