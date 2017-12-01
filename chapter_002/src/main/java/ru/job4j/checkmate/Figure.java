package ru.job4j.checkmate;

public abstract class Figure {
    final Cell position;

    boolean isWhite = true;

    // Cell [] pullOfCells = Cell.fillPull();

    protected Figure(Cell position) {
        this.position = position;
    }

    abstract Cell[] way(Cell source, Cell dest) throws ImposibleMoveException;


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

class Knight extends Figure {

    protected Knight(Cell position) {
        super(position);
    }

    @Override
    Cell[] way(Cell source, Cell dest) throws ImposibleMoveException {
        return new Cell[0];
    }
}

class Bishop extends Figure {

    protected Bishop(Cell position) {
        super(position);
    }

    @Override
    Cell[] way(Cell source, Cell dest) throws ImposibleMoveException {
        return new Cell[0];
    }
}

class King extends Figure {

    protected King(Cell position) {
        super(position);
    }

    @Override
    Cell[] way(Cell source, Cell dest) throws ImposibleMoveException {
        return new Cell[0];
    }
}

class Queen extends Figure {

    protected Queen(Cell position) {
        super(position);
    }

    @Override
    Cell[] way(Cell source, Cell dest) throws ImposibleMoveException {
        return new Cell[0];
    }
}