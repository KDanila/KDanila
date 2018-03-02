package ru.job4j.queue;

import java.util.LinkedList;
import java.util.ListIterator;

/**
 * Queue class.
 *
 * @author Kuzmin Danila (mailto:bus1d0@mail.ru)
 * @version $Id$
 * @since 0.1.3
 */
public class PriorityQueue {
    /**
     * Linked list of tasks.
     */
    private LinkedList<Task> tasks = new LinkedList<>();

    /**
     * Метод должен вставлять в нужную позицию элемент.
     * Позиция определять по полю приоритет.
     * Для вставик использовать add(int index, E value)
     *
     * @param task задача.
     */
    public void put(Task task) {

        int priority = task.getPriority();
        int num = 0;
        ListIterator<Task> lit = tasks.listIterator();
        if (tasks.size() == 0) {
            tasks.add(task);
        } else {
            while (lit.hasNext()) {
                Task t = lit.next();
                if (t.getPriority() <= priority) {
                    num = lit.previousIndex() + 1;
                }
            }
            tasks.add(num, task);
        }
    }

    /**
     * Take from queue.
     *
     * @return task.
     */
    public Task take() {
        return this.tasks.poll();
    }
}

