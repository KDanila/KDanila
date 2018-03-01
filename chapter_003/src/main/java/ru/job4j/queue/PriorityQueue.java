package ru.job4j.queue;

import java.util.LinkedList;
import java.util.ListIterator;

public class PriorityQueue {
    private LinkedList<Task> tasks = new LinkedList<>();

    /**
     * Метод должен вставлять в нужную позицию элемент.
     * Позиция определять по полю приоритет.
     * Для вставик использовать add(int index, E value)
     * @param task задача
     */
    public void put(Task task) {
      /*  //TODO добавить вставку в связанный список.
        int priority = task.getPriority();
        ListIterator<Task> lit= tasks.listIterator();
        while (lit.hasNext()){
            Task t = lit.next();
            if(t.getPriority()<=priority){
                tasks.add(lit.previousIndex(),t);
            }
        }
    }*/

    public Task take() {
        return this.tasks.poll();
    }
}

