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
        return null;
    }
}

/**
 * Вам необходимо создать класс ConvertList. Внутри методов использовать foreach.
 * <p>
 * В нём написать 2 метода:
 * <p>
 * public List<Integer> toList (int[][] array) {} - в метод приходит двумерный массив целых чисел, необходимо пройтись
 * по всем элементам массива и добавить их в List<Integer>.
 * <p>
 * public int[][] toArray (List<Integer> list, int rows) {} - метод toArray должен равномерно разбить лист на количество
 * строк двумерного массива. В методе toArray должна быть проверка - если количество элементов не кратно количеству строк
 * - оставшиеся значения в массиве заполнять нулями.
 * <p>
 * Например в результате конвертации листа со значениями (1,2,3,4,5,6,7) с разбиением на 3 строки должен получиться
 * двумерный массив {{1, 2, 3} {4, 5, 6} {7, 0 ,0}}
 */