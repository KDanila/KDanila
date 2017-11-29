package ru.job4j.checkmate;

public abstract class Figure {
    final Cell position;

    protected Figure(Cell position) {
        this.position = position;
    }

    abstract Cell[] way(Cell source, Cell dest) throws ImposibleMoveException;
}

class Pawn extends Figure {

    protected Pawn(Cell position) {
        super(position);
    }

    @Override
    Cell[] way(Cell source, Cell dest) throws ImposibleMoveException {
        return new Cell[0];
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