package ru.job4j.cyclearray;

/**
 * CycleArray.
 *
 * @author Kuzmin Danila (mailto:bus1d0@mail.ru)
 * @version $Id$
 * @since 0.1.0
 */
public class CycleArray {
    /**
     * Method what find cycle in Node link.
     *
     * @param first - first node.
     * @return boolean - true if in node links have cycle.
     */
    boolean hasCycle(Node first) {
        Node temp = first;
        boolean toReturn = false;
        while (temp.getNext() != null) {
            if (temp.isFlag()) {
                toReturn = true;
                break;
            }
            temp.setFlag(true);
            temp = temp.getNext();
        }
        return toReturn;
    }
}

/**
 * Simple Node class.
 *
 * @param <T> - generic.
 */
class Node<T> {
    /**
     * flag for found cycle.
     */
    private boolean flag = false;
    /**
     * T value.
     */
    private T value;
    /**
     * link to next Node.
     */
    private Node<T> next;

    /**
     * Constructor.
     *
     * @param value - value.
     */
    Node(T value) {
        this.value = value;
    }

    /**
     * Getter.
     *
     * @return flag.
     */
    public boolean isFlag() {
        return flag;
    }

    /**
     * Setter.
     *
     * @param next - next.
     */
    public void setNext(Node<T> next) {
        this.next = next;
    }

    /**
     * Setter.
     *
     * @param flag - flag.
     */
    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    /**
     * Getter.
     *
     * @return Node.
     */
    public Node<T> getNext() {
        return next;
    }
}