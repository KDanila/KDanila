package ru.job4j.checkmate;

public class Start {
    public static void main(String[] args) {
        Cell first = new Cell(0,0);
        Cell dist = new Cell(0,5);

/*
        int length=(first.x-dist.x==0)?Math.abs(first.y-dist.y):Math.abs(first.x-dist.x);

        Rook rook = new Rook(first);
             Cell[] result=rook.way(first,dist);
        for (int i = 0; i < length; i++) {
            System.out.println(result[i].x+"  "+result[i].y);
        }
*/

        Cell[] possiblePosition = new Cell[8];
        Cell[] toReturn = new Cell[1];
        if (first.x + 1 < 8) {
            if (first.y + 2 < 8) {
                possiblePosition[0] = new Cell(first.x + 1, first.y + 2);
            }
            if (first.y - 2 >= 0) {
                possiblePosition[1] = new Cell(first.x + 1, first.y - 2);
            }
        }
        if (first.x + 2 < 8) {
            if (first.y + 1 < 8) {
                possiblePosition[2] = new Cell(first.x + 2, first.y + 1);
            }
            if (first.y - 1 >= 0) {
                possiblePosition[3] = new Cell(first.x + 2, first.y - 1);
            }
        }
        if (first.x - 1 >= 0) {
            if (first.y + 2 < 8) {
                possiblePosition[4] = new Cell(first.x - 1, first.y + 2);
            }
            if (first.y - 2 >= 0) {
                possiblePosition[5] = new Cell(first.x - 1, first.y - 2);
            }
        }
        if (first.x - 2 >= 0) {
            if (first.y + 1 < 8) {
                possiblePosition[6] = new Cell(first.x - 2, first.y + 1);
            }
            if (first.y - 1 >= 0) {
                possiblePosition[7] = new Cell(first.x - 2, first.y - 1);
            }
        }
        for (int i = 0; i <8 ; i++) {
            System.out.println(possiblePosition[i]);
        }



    }
}
/*
1. реализовать шахматную доску.

2. должна быть возможность двигать фигуру.

3. система должна проверять корректность движения фигуры.

4. каждая фигура должна двигаться в соответствии со своей логикой.

5. нельзя ставить на занятые поля.

6. нельзя перемещать фигуру, если на пути стоит другая фигура. кроме коня.

7. в этом задании не надо делать меню и пользователей. меня интересует только логика. а не ввод данных.

8. все выше описанные поведения должны быть проверен через Junit tests.

Общая схема реализации. Вы можете добавлять свои методы.

1. Прочитать про шаблон проектирования стратегия.

2. Создать абстрактный класс Figure

2. В Figure сделать поле final Cell position - и конструктор. В классе не должно быть методов set get

3. Добавить в класс Figure абстрактный метод Cell[] way(Cell source, Cell dest) throw ImposibleMoveException

    Метод должен работать так. dest - задают ячейку куда следует пойти. Если фигура может туда пойти.
    то Вернуть массив ячеек. которые должна пройти фигура.

    Если фигура туда пойти не может. выбросить исключение ImposibleMoveException

4. Cell - описывает ячейки шахматной доски. Содержит координаты x, y. Cell не может содержать объект Figure.

5. Создать класс Board.

6. В классе создать массив Figure[][] figures = new Figure[8][8] - содержит фигуры. Клетки доски.

7. Добавить метод boolean move(Cell source, Cell dest) throws ImpossibleMoveException, OccupiedWayException, FigureNotFoundException

8. Метод должен проверить
   - Что в заданной ячейки есть фигура. если нет. то выкинуть исключение
   - Если фигура есть. Проверить может ли она так двигаться. Если нет то упадет исключение
   - Проверить что полученный путь. не занят фигурами. Если занят выкинуть исключение
   - Если все отлично. Записать в ячейку новое новое положение Figure figure.clone(Cell dest)

9. Изначально сделайте. только движения фигуры слон и покажите промежуточный результат.
 */
