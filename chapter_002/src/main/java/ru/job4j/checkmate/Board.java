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
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (i == 1 || i == 6) {

                }
            }
        }
    }
}
