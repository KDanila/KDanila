package ru.job4j.checkmate;

public class Start {
    public static void main(String[] args) {
        Cell source = new Cell(7, 7);
        Cell dest = new Cell(0, 0);

        Cell[] possiblePosition = new Cell[13];
        Cell[] toReturn = new Cell[Math.abs(Math.max(source.x, source.y) - Math.min(dest.x, dest.y))];
        int temp = 0;
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


        for (int i = 0; i <Math.abs(Math.max(source.x, source.y) - Math.min(dest.x, dest.y)); i++) {
            if (possiblePosition[i] != null && possiblePosition[i].equals(dest)) {
                int x = possiblePosition[i].x;
                int y = possiblePosition[i].y;
                int length = Math.abs(Math.max(source.x, source.y) - Math.min(dest.x, dest.y));
                for (int j = 1; j < length; j++) {
                    if (source.x != possiblePosition[i].x && source.y != possiblePosition[i].y) {
                        if (source.x > possiblePosition[i].x && source.y > possiblePosition[i].y) {
                            toReturn[j] = new Cell(x + j, y + j);
                        }
                        if (source.x > possiblePosition[i].x && source.y < possiblePosition[i].y) {
                            toReturn[j] = new Cell(x + j, y - j);
                        }
                        if (source.x < possiblePosition[i].x && source.y > possiblePosition[i].y) {
                            toReturn[j] = new Cell(x - j, y + j);
                        }
                        if (source.x < possiblePosition[i].x && source.y < possiblePosition[i].y) {
                            toReturn[j] = new Cell(x - j, y - j);
                        }
                    }
                }
            }
        }
        for (int i = 0; i < toReturn.length; i++) {
            if (toReturn[i] != null) {
                System.out.println(toReturn[i].x + " " + toReturn[i].y);
            }
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
