package ru.job4j.checkmate;

public abstract class Figure {

    private final Cell position;



    private Cell currentPosition;

    boolean isWhite = true;

    // Cell [] pullOfCells = Cell.fillPull();

    protected Figure(Cell position) {
        this.position = position;
    }

    abstract Cell[] way(Cell source, Cell dest) throws ImposibleMoveException;

    public Cell getPosition() {
        return position;
    }
    public Cell getCurrentPosition() {
        return currentPosition;
    }

    public void setCurrentPosition(Cell currentPosition) {
        this.currentPosition = currentPosition;
    }

}

class Pawn extends Figure {

    boolean firstStep = true;


    protected Pawn(Cell position) {
        super(position);
    }

    @Override
    Cell[] way(Cell source, Cell dest) throws ImposibleMoveException {
        int length = Math.abs(source.y - dest.y);
        Cell[] wayToreturn = new Cell[length];
        if (source.y < 8 || source.y > 0 || dest.x < 8 || dest.y > 0 || !source.equals(dest)) {
            if (isWhite) {
                if (firstStep) {
                    wayToreturn[0] = new Cell(source.x, source.y + 1);
                    wayToreturn[1] = new Cell(source.x, source.y + 2);

                } else {
                    wayToreturn[0] = new Cell(source.x, source.y + 1);
                }
            } else {
                if (firstStep) {
                    wayToreturn[0] = new Cell(source.x, source.y - 1);
                    wayToreturn[1] = new Cell(source.x, source.y - 2);
                } else {
                    wayToreturn[0] = new Cell(source.x, source.y - 1);
                }
            }
        } else throw new ImposibleMoveException();
        return wayToreturn;
    }
}

class Rook extends Figure {

    protected Rook(Cell position) {
        super(position);
    }

    @Override
    Cell[] way(Cell source, Cell dest) throws ImposibleMoveException {
        int length = (source.x - dest.x == 0) ? Math.abs(source.y - dest.y) : Math.abs(source.x - dest.x);
        Cell[] toReturn = new Cell[length + 1];
        int tempY = (source.y < dest.y) ? source.y : dest.y;
        int tempX = (source.x < dest.x) ? source.x : dest.x;
        if (source.x - dest.x == 0 && source.y - dest.y != 0) {
            for (int i = 0; i < length; i++) {
                if (source.y < dest.y) {
                    toReturn[i] = new Cell(source.x, source.y + 1 + i);
                } else {
                    toReturn[i] = new Cell(source.x, tempY + i);
                }
            }
        } else if (source.x - dest.x != 0 && source.y - dest.y == 0) {
            for (int i = 0; i < length; i++) {
                if (source.x < dest.x) {
                    toReturn[i] = new Cell(source.x + 1 + i, source.y);
                } else {
                    toReturn[i] = new Cell(tempX + i, source.y);
                }

            }
        } else {
            throw new ImposibleMoveException();
        }
        return toReturn;
    }
}

/**
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

    protected Knight(Cell position) {
        super(position);
    }

    @Override
    Cell[] way(Cell source, Cell dest) throws ImposibleMoveException {
        Cell[] possiblePosition = new Cell[8];
        Cell[] toReturn = new Cell[1];
        if (source.x + 1 < 8) {
            if (source.y + 2 < 8) {
                possiblePosition[0] = new Cell(source.x + 1, source.y + 2);
            }
            if (source.y - 2 >= 0) {
                possiblePosition[1] = new Cell(source.x + 1, source.y - 2);
            }
        }
        if (source.x + 2 < 8) {
            if (source.y + 1 < 8) {
                possiblePosition[2] = new Cell(source.x + 2, source.y + 1);
            }
            if (source.y - 1 >= 0) {
                possiblePosition[3] = new Cell(source.x + 2, source.y - 1);
            }
        }
        if (source.x - 1 >= 0) {
            if (source.y + 2 < 8) {
                possiblePosition[4] = new Cell(source.x - 1, source.y + 2);
            }
            if (source.y - 2 >= 0) {
                possiblePosition[5] = new Cell(source.x - 1, source.y - 2);
            }
        }
        if (source.x - 2 >= 0) {
            if (source.y + 1 < 8) {
                possiblePosition[6] = new Cell(source.x - 2, source.y + 1);
            }
            if (source.y - 1 >= 0) {
                possiblePosition[7] = new Cell(source.x - 2, source.y - 1);
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

class Bishop extends Figure {

    protected Bishop(Cell position) {
        super(position);
    }

    @Override
    Cell[] way(Cell source, Cell dest) throws ImposibleMoveException {
        Cell[] possiblePosition = new Cell[13];
        Cell[] toReturn = new Cell[Math.abs(Math.max(source.x, source.y) - Math.min(dest.x, dest.y))];
        int temp = 0;
        int tempTwo = 0;
        for (int i = 1; i < 8; i++) {
            if (source.x + i < 8 && source.y + i < 8) {
                possiblePosition[temp] = new Cell(source.x + i, source.y + i);
                temp++;
            }
            if (source.x + i < 8 && source.y - i >= 0) {
                possiblePosition[temp] = new Cell(source.x + i, source.y - i);
                temp++;
            }
            if (source.x - i >= 0 && source.y - i >= 0) {
                possiblePosition[temp] = new Cell(source.x - i, source.y - i);
                temp++;
            }
            if (source.x - i >= 0 && source.y + i < 8) {
                possiblePosition[temp] = new Cell(source.x - i, source.y + i);
                temp++;
            }
        }

        for (int i = 0; i < possiblePosition.length; i++) {
            if (possiblePosition[i] != null && possiblePosition[i].equals(dest)) {
                int x = possiblePosition[i].x;
                int y = possiblePosition[i].y;
                for (int j = 0; j < Math.abs(Math.max(source.x, source.y) - Math.min(dest.x, dest.y)); j++) {


                    if (source.x > x && source.y > y) {
                        toReturn[tempTwo++] = new Cell(source.x - j - 1, source.y - j - 1);
                    }
                    if (source.x > x && source.y < y) {
                        toReturn[tempTwo++] = new Cell(source.x - j - 1, source.y + j + 1);
                    }
                    if (source.x < x && source.y < y) {
                        toReturn[tempTwo++] = new Cell(source.x + j + 1, source.y + j + 1);
                    }
                    if (source.x < x && source.y > y) {
                        toReturn[tempTwo++] = new Cell(source.x + 1 + j, source.y - j - 1);
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

class King extends Figure {

    protected King(Cell position) {
        super(position);
    }

    @Override
    Cell[] way(Cell source, Cell dest) throws ImposibleMoveException {
        int position = 0;
        Cell[] possiblePosition = new Cell[12];
        Cell[] toReturn = new Cell[1];

        if (source.x + 1 < 8) {
            possiblePosition[position++] = new Cell(source.x + 1, source.y);
            if (source.y + 1 < 8) {
                possiblePosition[position++] = new Cell(source.x + 1, source.y + 1);
            }
            if (source.y - 1 >= 0) {
                possiblePosition[position++] = new Cell(source.x + 1, source.y - 1);
            }
        }
        if (source.x - 1 >= 0) {
            possiblePosition[position++] = new Cell(source.x - 1, source.y);
            if (source.y + 1 < 8) {
                possiblePosition[position++] = new Cell(source.x - 1, source.y + 1);
            }
            if (source.y - 1 >= 0) {
                possiblePosition[position++] = new Cell(source.x - 1, source.y - 1);
            }
        }
        if (source.y + 1 < 8) {
            possiblePosition[position++] = new Cell(source.x, source.y + 1);
            if (source.x + 1 < 8) {
                possiblePosition[position++] = new Cell(source.x + 1, source.y + 1);
            }
            if (source.x - 1 >= 0) {
                possiblePosition[position++] = new Cell(source.x - 1, source.y + 1);
            }
        }
        if (source.y - 1 >= 0) {
            possiblePosition[position++] = new Cell(source.x, source.y - 1);
            if (source.x + 1 < 8) {
                possiblePosition[position++] = new Cell(source.x + 1, source.y - 1);
            }
            if (source.x - 1 >= 0) {
                possiblePosition[position++] = new Cell(source.x - 1, source.y - 1);
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

class Queen extends Figure {

    protected Queen(Cell position) {
        super(position);
    }

    @Override
    Cell[] way(Cell source, Cell dest) throws ImposibleMoveException {
        if (source.x - dest.x == 0 || source.y - dest.y == 0) {
            int length = (source.x - dest.x == 0) ? Math.abs(source.y - dest.y) : Math.abs(source.x - dest.x);
            Cell[] toReturn = new Cell[length + 1];
            int tempY = (source.y < dest.y) ? source.y : dest.y;
            int tempX = (source.x < dest.x) ? source.x : dest.x;
            if (source.x - dest.x == 0 && source.y - dest.y != 0) {
                for (int i = 0; i < length; i++) {
                    if (source.y < dest.y) {
                        toReturn[i] = new Cell(source.x, source.y + 1 + i);
                    } else {
                        toReturn[i] = new Cell(source.x, tempY + i);
                    }
                }
            } else if (source.x - dest.x != 0 && source.y - dest.y == 0) {
                for (int i = 0; i < length; i++) {
                    if (source.x < dest.x) {
                        toReturn[i] = new Cell(source.x + 1 + i, source.y);
                    } else {
                        toReturn[i] = new Cell(tempX + i, source.y);
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
            Cell[] toReturn = new Cell[Math.abs(Math.max(source.x, source.y) - Math.min(dest.x, dest.y))];
            int temp = 0;
            int tempTwo = 0;
            for (int i = 1; i < 8; i++) {
                if (source.x + i < 8 && source.y + i < 8) {
                    possiblePosition[temp] = new Cell(source.x + i, source.y + i);
                    temp++;
                }
                if (source.x + i < 8 && source.y - i >= 0) {
                    possiblePosition[temp] = new Cell(source.x + i, source.y - i);
                    temp++;
                }
                if (source.x - i >= 0 && source.y - i >= 0) {
                    possiblePosition[temp] = new Cell(source.x - i, source.y - i);
                    temp++;
                }
                if (source.x - i >= 0 && source.y + i < 8) {
                    possiblePosition[temp] = new Cell(source.x - i, source.y + i);
                    temp++;
                }
            }

            for (int i = 0; i < possiblePosition.length; i++) {
                if (possiblePosition[i] != null && possiblePosition[i].equals(dest)) {
                    int x = possiblePosition[i].x;
                    int y = possiblePosition[i].y;
                    for (int j = 0; j < Math.abs(Math.max(source.x, source.y) - Math.min(dest.x, dest.y)); j++) {


                        if (source.x > x && source.y > y) {
                            toReturn[tempTwo++] = new Cell(source.x - j - 1, source.y - j - 1);
                        }
                        if (source.x > x && source.y < y) {
                            toReturn[tempTwo++] = new Cell(source.x - j - 1, source.y + j + 1);
                        }
                        if (source.x < x && source.y < y) {
                            toReturn[tempTwo++] = new Cell(source.x + j + 1, source.y + j + 1);
                        }
                        if (source.x < x && source.y > y) {
                            toReturn[tempTwo++] = new Cell(source.x + 1 + j, source.y - j - 1);
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