package ru.job4j.checkmate;

public abstract class Figure {
    final Cell position;

    boolean isWhite = true;

    // Cell [] pullOfCells = Cell.fillPull();

    protected Figure(Cell position) {
        this.position = position;
    }

    abstract Cell[] way(Cell source, Cell dest) throws ImposibleMoveException;

   /* int findNumberOfCellInPull(Cell toFind){
       Cell[] pull = this.pullOfCells;
       int number=0;
        for (int j = 0; j < 84; j++) {
            if(pull[j].equals(toFind)) {
                number=j;
                break;
            }
        }
        return number;
    }*/

}

class Pawn extends Figure {

    boolean firstStep = true;

    protected Pawn(Cell position) {
        super(position);
    }

    @Override
    Cell[] way(Cell source, Cell dest) throws ImposibleMoveException {
        Cell[] wayToreturn = new Cell[2];
        if (source.y < 8 || source.y > 0 || dest.x < 8 || dest.y > 0) {
            if (isWhite) {
                if (!source.equals(dest) && firstStep) {
                    wayToreturn[0] = new Cell(source.x, source.y + 1);
                    wayToreturn[1] = new Cell(source.x, source.y + 2);

                } else if (!source.equals(dest) && !firstStep) {
                    wayToreturn[0] = new Cell(source.x, source.y + 1);
                }
            } else {
                if (!source.equals(dest) && firstStep) {
                    wayToreturn[0] = new Cell(source.x, source.y - 1);
                    wayToreturn[1] = new Cell(source.x, source.y - 2);
                } else if (!source.equals(dest) && !firstStep) {
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
        return new Cell[0];
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