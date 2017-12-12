package ru.job4j.checkmate;

/**
 * Start class.
 *
 * @author Kuzmin Danila (mailto:bus1d0@mail.ru)
 * @version $Id$
 * @since 0.1.3
 */
public class Start {
    /**
     * main.
     *
     * @param args - args.
     */
    public static void main(String[] args) {


        Cell source = new Cell(1, 0);
        Cell dest = new Cell(5, 4);
        Cell[] toShow = new Cell[Math.abs(dest.getX() - source.getX())];
        Start test = new Start();
        toShow = test.way(source, dest);
        for (Cell cell : toShow) {
            if (cell != null) {
                System.out.println(cell.getX() + " " + cell.getY());
            }
        }

    }

    Cell[] way(Cell source, Cell dest) {

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


