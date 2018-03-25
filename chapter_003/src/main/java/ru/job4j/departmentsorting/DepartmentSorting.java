package ru.job4j.departmentsorting;

import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

public class DepartmentSorting {

    // ToDo инкапсулировать стратегию сортировки (в аргумент принимать стратегию сортировки).
    TreeSet<String> sort(List<String> departments, Comparator<String> compareStrategy) {
        TreeSet<String> toReturn = new TreeSet<>(compareStrategy);
        String tempLine;
        int lastIndex;
        for (int i = 0; i < departments.size(); i++) {
            toReturn.add(departments.get(i));
            tempLine = departments.get(i);
            lastIndex = tempLine.lastIndexOf("\\");
            while (lastIndex != -1) {
                toReturn.add(tempLine.substring(0, lastIndex));
                tempLine = tempLine.substring(0, lastIndex);
                lastIndex = tempLine.lastIndexOf("\\");
            }
        }
        return toReturn;
    }
}

/*
В организации было решено ввести справочник подразделений. Коды подразделений представлены в виде массива строк вида:

“K1\SK1”

“K1\SK2”

“K1\SK1\SSK1”

“K1\SK1\SSK2”

“K2”

“K2\SK1\SSK1”

“K2\SK1\SSK2”

, где каждая строка имеет следующую структуру: каждая строка включает в себя код данного подразделения,
а также все коды подразделений, которые включают в свою структуру данное подразделение (к примеру департамент
K1 включает в себя службу SK1, включающую в себя отдел SSK1). Подразделения в одной строке разделены знаком “\”.
Возможны случаи, когда в массиве отсутствуют строки с кодом верхнеуровнего подразделения (в показанном выше массиве
 есть строки с подразделением K1, но данный код подразделения не представлен отдельной строкой “K1”, аналогичный случай
  с кодом K2\SK1), в таком случае необходимо добавить строку с кодом данного подразделения и учитывать ее при сортировке.

Задача:

Реализовать возможность сортировки массива кодов подразделений по возрастанию и убыванию, при которых сохранялась
бы иерархическая структура (показано далее в примерах сортировки), т.к. отсортированный массив используется для
отображения категорий пользователю. Отсортированный тестовый массив должен иметь вид:

    Сортировка по возрастанию:

“K1”

“K1\SK1”

“K1\SK1\SSK1”

“K1\SK1\SSK2”

“K1\SK2”

“K2”

“K2\SK1”

“K2\SK1\SSK1”

“K2\SK1\SSK2”



    Сортировка по убыванию:

“K2”

“K2\SK1”

“K2\SK1\SSK2”

“K2\SK1\SSK1”

“K1”

“K1\SK2”

“K1\SK1”

“K1\SK1\SSK2”

“K1\SK1\SSK1”
 */