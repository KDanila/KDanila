package ru.job4j.checkmate;

public class Cell {
    int x;
    int y;
    Cell(int x, int y){
        this.x =x;
        this.y =y;
    }

    /**
     *Создаем поле доски
     * @return массив ячеек.
     */
    static Cell[] fillPull() {
        Cell[] pullOfCells = new Cell[64];
        for (int y = 0; y < 8; y++) {
            for (int x = 0; x < 8; x++) {
                pullOfCells[x+y]= new Cell(x,y);
            }
        }
        return pullOfCells;
    }
}
