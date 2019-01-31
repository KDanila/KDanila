package ru.job4j.scanfilesystem;

import java.io.File;
import java.util.*;

public class Search {

    List<File> files(String parent, List<String> exts){
        File parentFile = new File(parent);
        List<File> toReturn = new ArrayList<>();
        Queue<File> files = new LinkedList<>();
        files.offer(parentFile);
        File temp;
        while(!files.isEmpty()){
            temp = files.poll();
            if(temp.isDirectory()){
                 files.addAll(Arrays.asList(temp.listFiles()));
            } else {
                if(checkExtension(temp,exts)){
                    toReturn.add(temp);
                }
            }
        }
        return toReturn;
    }

    private boolean checkExtension(File temp, List<String> exts) {
        String name = temp.getName();
        boolean check = false;
        for (String s : exts) {
            if (name.endsWith(s)) {
                check = true;
                break;
            }
        }
        return check;
    }
}
/*
file.listFiles() file.isDirectory() file.getName();

Файловая система представляет собой древовидную структуру. В модуле "Коллекции Про" рассматривался алгоритм обхода дерева.

Этот алгоритм обхода в ширину.

В этом задании нужно написать метод, который возвращает список всех файлов с конкретным расширением.

Метод должен заходить во всех каталоги.

Для этого нужно использовать алгоритм обхода дерева в ширину.

class Search {
   List<File> files(String parent, List<String> exts);

}

String parent - это путь до каталога, с которого нужно осуществлять поиск.

List<String> exts - это расширения файлов, которые мы ходим получить.

В этой задаче нужно использовать методы.

File file = new File(path);

file.listFiles() - возвращает список всех каталогов и файлов находящихся в папке  file.

file.isDirectory() - проверяет, что файл является директорией.

file.getName() - возвращает имя файла с расширением.

В этой задаче нужно написать тесты. Для тестов нужно создать временную структуру с файлами.

Структуру нужно создавать в папке System.getProperty("java.io.tmpdir")

Здесь нельзя использовать FileVisitor. Это задание на работу с деревом каталогов.

 */