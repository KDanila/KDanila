package ru.job4j.convertlist;

import java.util.ArrayList;
import java.util.List;


/**
 * ConvertList class.
 *
 * @author Kuzmin Danila (mailto:bus1d0@mail.ru)
 * @version $Id$
 * @since 0.1.3
 */
public class ConvertList {
    /**
     * В метод приходит двумерный массив -----> добавляем в list.
     *
     * @param array - int [][] - is needed to add in list.
     * @return - list array.
     */
    public List<Integer> toList(int[][] array) {
        List<Integer> toReturn = new ArrayList<Integer>();
        for (int[] i : array) {
            for (int j : i) {
                toReturn.add(j);
            }
        }
        return toReturn;
    }

    /**
     * метод разбивает лист на количество строк двумерного массива.
     * В методе toArray должна есть проверка - если количество элементов не кратно количеству строк
     * - оставшиеся значения в массиве заполнять нулями.
     *
     * @param list - list.
     * @param rows - number of rows.
     * @return - int [][] array.
     */
    public int[][] toArray(List<Integer> list, int rows) {
        int[][] toReturn = new int[rows][rows];
        int i = 0;
        for (Integer li : list) {
            if (i < rows * rows) {
                toReturn[i / rows][i % rows] = li;
                i++;
            }
        }
        return toReturn;
    }
    /*
    В классе ConvertList из 3-го задания 1-го урока написать метод:

public List<Integer> convert (List<int[]> list)

В этом методе вы должны пройтись по всем элементам всех массивов в списке list и добавить их в один общий лист Integer.

Массивы в списке list могут быть разного размера.

Например:
list.add(new int[]{1, 2})
list.add(new int[]{3, 4, 5, 6})
List<Integer> result = convertList.convert(list)

List<Integer> result будет содержать элементы: (1, 2, 3, 4, 5, 6)

     */
}
