/*

package com; com.domain.package.class - должно выглядить подобным образом


//import java.util.ArrayList; Я бы добавил только конкретные классы
//import java.util.Iterator;
//import java.util.List;
import java.util.*;

public class Convert {

    public Convert(){ //Пустой конструктор создается автоматически, перегрузки его нет ---> смысл его создовать?

    }

    //Converts array to list
    List<Integer> makeList(int[][] array) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++)
                list.add(array[i][j]);
        }
        return list;
    }


    //Converts list to array
    public int[][] makeArray(List<Integer> list, int rws) {
        Iterator<Integer> iterator = list.iterator();
        int cls = list.size() / rws + (list.size() % rws == 0 ? 0 : 1);//Не читаемо, плюс зачем эта операция если
        //массив имеет по сути вид [rows][rows]. Прогнал по тестам этот метод упал практически везде.
        int[][] array = new int[rws][cls];
        for (int i = 0; i < rws; i++) {
            for (int j = 0; j < cls; j++) {
                if (iterator.hasNext())
                    array[i][j] = iterator.next();
                else
                    array[i][j] = 0;
            }
        }
        return array;
    }
}*/
