package ru.job4j.checkmate;

/**
 * Figure class.
 *
 * @author Kuzmin Danila (mailto:bus1d0@mail.ru)
 * @version $Id$
 * @since 0.1.3
 */
public abstract class Figure {
    /**
     * Cell position.
     */
    private final Cell position;
    /**
     * Current position of Figure.
     */
    private Cell currentPosition;
    /**
     * Color of figure.
     */
    boolean isWhite = true;

    /**
     * Constructor.
     *
     * @param position - cell position.
     */
    protected Figure(Cell position) {
        this.position = position;
        this.currentPosition = position;
    }

    /**
     * @param source - cell from.
     * @param dest   -cell to.
     * @return cell array with posibble move.
     * @throws ImposibleMoveException - throw if move is imposible.
     */
    abstract Cell[] way(Cell source, Cell dest) throws ImposibleMoveException;

    /**
     * getter.
     *
     * @return current position.
     */

    public Cell getCurrentPosition() {
        return currentPosition;
    }

    /**
     * setter.
     *
     * @param currentPosition -set.
     */
    public void setCurrentPosition(Cell currentPosition) {
        this.currentPosition = currentPosition;
    }

}

/**
 * Pawn class.
 */
class Pawn extends Figure {
    /**
     * first step.
     */
    boolean firstStep = true;

    /**
     * constructor.
     *
     * @param position - position.
     */
    protected Pawn(Cell position) {
        super(position);
    }

    /**
     * @param source - cell from.
     * @param dest   -cell to.
     * @return
     * @throws ImposibleMoveException
     */
    @Override
    Cell[] way(Cell source, Cell dest) throws ImposibleMoveException {
        int length = Math.abs(source.getY() - dest.getY());
        Cell[] toReturn = new Cell[length];
        if (source.getY() < 8 || source.getY() > 0 || dest.getX() < 8 || dest.getY() > 0 || !source.equals(dest)) {
            if (isWhite) {
                if (firstStep) {
                    toReturn[0] = new Cell(source.getX(), source.getY() + 1);
                    if (toReturn.length == 2) {
                        toReturn[1] = new Cell(source.getX(), source.getY() + 2);
                    }
                } else {
                    toReturn[0] = new Cell(source.getX(), source.getY() + 1);
                }
            } else {
                if (firstStep) {
                    toReturn[0] = new Cell(source.getX(), source.getY() - 1);
                    if (toReturn.length == 2) {
                        toReturn[1] = new Cell(source.getX(), source.getY() - 2);
                    }
                } else {
                    toReturn[0] = new Cell(source.getX(), source.getY() - 1);
                }
            }
        } else {
            throw new ImposibleMoveException();
        }

        return toReturn;
    }
}

/**
 * Rook class.
 */
class Rook extends Figure {
    /**
     * constructor.
     *
     * @param position - position.
     */
    protected Rook(Cell position) {
        super(position);
    }

    /**
     * @param source - cell from.
     * @param dest   -cell to.
     * @return
     * @throws ImposibleMoveException
     */
    @Override
    Cell[] way(Cell source, Cell dest) throws ImposibleMoveException {
        int length = (source.getX() - dest.getX() == 0) ? Math.abs(source.getY() - dest.getY()) : Math.abs(source.getX() - dest.getX());
        Cell[] toReturn = new Cell[length + 1];
        int tempY = (source.getY() < dest.getY()) ? source.getY() : dest.getY();
        int tempX = (source.getX() < dest.getX()) ? source.getX() : dest.getX();
        if (source.getX() - dest.getX() == 0 && source.getY() - dest.getY() != 0) {
            for (int i = 0; i < length; i++) {
                if (source.getY() < dest.getY()) {
                    toReturn[i] = new Cell(source.getX(), source.getY() + 1 + i);
                } else {
                    toReturn[i] = new Cell(source.getX(), tempY + i);
                }
            }
        } else if (source.getX() - dest.getX() != 0 && source.getY() - dest.getY() == 0) {
            for (int i = 0; i < length; i++) {
                if (source.getX() < dest.getX()) {
                    toReturn[i] = new Cell(source.getX() + 1 + i, source.getY());
                } else {
                    toReturn[i] = new Cell(tempX + i, source.getY());
                }

            }
        } else {
            throw new ImposibleMoveException();
        }
        return toReturn;
    }
}

/**
 * Knight class.
 * x  x  x  x  x  x  x
 * x  x  x  x  x  x  x
 * x  x  8  x  1  x  x
 * x  7  x  x  x  2  x
 * x  x  x  0  x  x  x
 * x  6  x  x  x  3  x
 * x  x  5  x  4  x  x
 * x  x  x  x  x  x  x
 */
class Knight extends Figure {
    /**
     * Constructor.
     *
     * @param position - position.
     */
    protected Knight(Cell position) {
        super(position);
    }

    /**
     * @param source - cell from.
     * @param dest   -cell to.
     * @return
     * @throws ImposibleMoveException
     */
    @Override
    Cell[] way(Cell source, Cell dest) throws ImposibleMoveException {
        Cell[] possiblePosition = new Cell[8];
        Cell[] toReturn = new Cell[1];
        if (source.getX() + 1 < 8) {
            if (source.getY() + 2 < 8) {
                possiblePosition[0] = new Cell(source.getX() + 1, source.getY() + 2);
            }
            if (source.getY() - 2 >= 0) {
                possiblePosition[1] = new Cell(source.getX() + 1, source.getY() - 2);
            }
        }
        if (source.getX() + 2 < 8) {
            if (source.getY() + 1 < 8) {
                possiblePosition[2] = new Cell(source.getX() + 2, source.getY() + 1);
            }
            if (source.getY() - 1 >= 0) {
                possiblePosition[3] = new Cell(source.getX() + 2, source.getY() - 1);
            }
        }
        if (source.getX() - 1 >= 0) {
            if (source.getY() + 2 < 8) {
                possiblePosition[4] = new Cell(source.getX() - 1, source.getY() + 2);
            }
            if (source.getY() - 2 >= 0) {
                possiblePosition[5] = new Cell(source.getX() - 1, source.getY() - 2);
            }
        }
        if (source.getX() - 2 >= 0) {
            if (source.getY() + 1 < 8) {
                possiblePosition[6] = new Cell(source.getX() - 2, source.getY() + 1);
            }
            if (source.getY() - 1 >= 0) {
                possiblePosition[7] = new Cell(source.getX() - 2, source.getY() - 1);
            }
        }

        for (int i = 0; i < 8; i++) {
            if (possiblePosition[i] != null && possiblePosition[i].equals(dest)) {
                toReturn[0] = possiblePosition[i];
                break;
            }
        }
        if (toReturn[0] != null) {
            return toReturn;
        } else {
            throw new ImposibleMoveException();
        }

    }
}

/**
 * Bishop class.
 */
class Bishop extends Figure {
    /**
     * Constructor.
     *
     * @param position - position.
     */
    protected Bishop(Cell position) {
        super(position);
    }

    /**
     * @param source - cell from.
     * @param dest   -cell to.
     * @return
     * @throws ImposibleMoveException
     */
    @Override
    Cell[] way(Cell source, Cell dest) throws ImposibleMoveException {
        int xStep = Integer.compare(dest.getX(), source.getX());
        int yStep = Integer.compare(dest.getY(), source.getY());
        int length = Math.abs(dest.getX() - source.getX());
        Cell[] toReturn = new Cell[length];
        if(Math.abs(dest.getX() - source.getX())==Math.abs(dest.getY() - source.getY())) {
            for (int i = 1; i <= length; i++) {
                toReturn[i - 1] = new Cell(source.getX() + xStep * i, source.getY() + yStep * i);
            }
        }
        else {
            throw new ImposibleMoveException();
        }

        return toReturn;
    }
}

/**
 * King class.
 */
class King extends Figure {
    /**
     * Constructor.
     *
     * @param position - position.
     */
    protected King(Cell position) {
        super(position);
    }

    /**
     * @param source - cell from.
     * @param dest   -cell to.
     * @return
     * @throws ImposibleMoveException
     */
    @Override
    Cell[] way(Cell source, Cell dest) throws ImposibleMoveException {
        int position = 0;
        Cell[] possiblePosition = new Cell[12];
        Cell[] toReturn = new Cell[1];

        if (source.getX() + 1 < 8) {
            possiblePosition[position++] = new Cell(source.getX() + 1, source.getY());
            if (source.getY() + 1 < 8) {
                possiblePosition[position++] = new Cell(source.getX() + 1, source.getY() + 1);
            }
            if (source.getY() - 1 >= 0) {
                possiblePosition[position++] = new Cell(source.getX() + 1, source.getY() - 1);
            }
        }
        if (source.getX() - 1 >= 0) {
            possiblePosition[position++] = new Cell(source.getX() - 1, source.getY());
            if (source.getY() + 1 < 8) {
                possiblePosition[position++] = new Cell(source.getX() - 1, source.getY() + 1);
            }
            if (source.getY() - 1 >= 0) {
                possiblePosition[position++] = new Cell(source.getX() - 1, source.getY() - 1);
            }
        }
        if (source.getY() + 1 < 8) {
            possiblePosition[position++] = new Cell(source.getX(), source.getY() + 1);
            if (source.getX() + 1 < 8) {
                possiblePosition[position++] = new Cell(source.getX() + 1, source.getY() + 1);
            }
            if (source.getX() - 1 >= 0) {
                possiblePosition[position++] = new Cell(source.getX() - 1, source.getY() + 1);
            }
        }
        if (source.getY() - 1 >= 0) {
            possiblePosition[position++] = new Cell(source.getX(), source.getY() - 1);
            if (source.getX() + 1 < 8) {
                possiblePosition[position++] = new Cell(source.getX() + 1, source.getY() - 1);
            }
            if (source.getX() - 1 >= 0) {
                possiblePosition[position++] = new Cell(source.getX() - 1, source.getY() - 1);
            }
        }

        for (Cell toFind : possiblePosition) {
            if (toFind != null && toFind.equals(dest)) {
                toReturn[0] = toFind;
                break;
            }
        }
        if (toReturn[0] != null) {
            return toReturn;
        } else {
            throw new ImposibleMoveException();
        }
    }
}

/**
 * Queen class.
 */
class Queen extends Figure {
    /**
     * constructor.
     *
     * @param position - position.
     */
    protected Queen(Cell position) {
        super(position);
    }

    /**
     * @param source - cell from.
     * @param dest   -cell to.
     * @return
     * @throws ImposibleMoveException
     */
    @Override
    Cell[] way(Cell source, Cell dest) throws ImposibleMoveException {
        if (source.getX() - dest.getX() == 0 || source.getY() - dest.getY() == 0) {
            int length = (source.getX() - dest.getX() == 0) ? Math.abs(source.getY() - dest.getY()) : Math.abs(source.getX() - dest.getX());
            Cell[] toReturn = new Cell[length + 1];
            int tempY = (source.getY() < dest.getY()) ? source.getY() : dest.getY();
            int tempX = (source.getX() < dest.getX()) ? source.getX() : dest.getX();
            if (source.getX() - dest.getX() == 0 && source.getY() - dest.getY() != 0) {
                for (int i = 0; i < length; i++) {
                    if (source.getY() < dest.getY()) {
                        toReturn[i] = new Cell(source.getX(), source.getY() + 1 + i);
                    } else {
                        toReturn[i] = new Cell(source.getX(), tempY + i);
                    }
                }
            } else if (source.getX() - dest.getX() != 0 && source.getY() - dest.getY() == 0) {
                for (int i = 0; i < length; i++) {
                    if (source.getX() < dest.getX()) {
                        toReturn[i] = new Cell(source.getX() + 1 + i, source.getY());
                    } else {
                        toReturn[i] = new Cell(tempX + i, source.getY());
                    }
                }
            } else {
                throw new ImposibleMoveException();
            }
            if (toReturn[0] != null) {
                return toReturn;
            } else {
                throw new ImposibleMoveException();
            }
        } else {
            Cell[] possiblePosition = new Cell[13];
            Cell[] toReturn = new Cell[Math.abs(Math.max(source.getX(), source.getY()) - Math.min(dest.getX(), dest.getY()))];
            int temp = 0;
            int tempTwo = 0;
            for (int i = 1; i < 8; i++) {
                if (source.getX() + i < 8 && source.getY() + i < 8) {
                    possiblePosition[temp] = new Cell(source.getX() + i, source.getY() + i);
                    temp++;
                }
                if (source.getX() + i < 8 && source.getY() - i >= 0) {
                    possiblePosition[temp] = new Cell(source.getX() + i, source.getY() - i);
                    temp++;
                }
                if (source.getX() - i >= 0 && source.getY() - i >= 0) {
                    possiblePosition[temp] = new Cell(source.getX() - i, source.getY() - i);
                    temp++;
                }
                if (source.getX() - i >= 0 && source.getY() + i < 8) {
                    possiblePosition[temp] = new Cell(source.getX() - i, source.getY() + i);
                    temp++;
                }
            }

            for (int i = 0; i < possiblePosition.length; i++) {
                if (possiblePosition[i] != null && possiblePosition[i].equals(dest)) {
                    int x = possiblePosition[i].getX();
                    int y = possiblePosition[i].getY();
                    for (int j = 0; j < Math.abs(Math.max(source.getX(), source.getY()) - Math.min(dest.getX(), dest.getY())); j++) {


                        if (source.getX() > x && source.getY() > y) {
                            toReturn[tempTwo++] = new Cell(source.getX() - j - 1, source.getY() - j - 1);
                        }
                        if (source.getX() > x && source.getY() < y) {
                            toReturn[tempTwo++] = new Cell(source.getX() - j - 1, source.getY() + j + 1);
                        }
                        if (source.getX() < x && source.getY() < y) {
                            toReturn[tempTwo++] = new Cell(source.getX() + j + 1, source.getY() + j + 1);
                        }
                        if (source.getX() < x && source.getY() > y) {
                            toReturn[tempTwo++] = new Cell(source.getX() + 1 + j, source.getY() - j - 1);
                        }
                    }
                }
            }
            if (toReturn[0] != null) {
                return toReturn;
            } else {
                throw new ImposibleMoveException();
            }
        }
    }
}