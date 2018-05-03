package ru.job4j.simplecollection.cyclearray;

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
        Node slow = first;
        Node fast = first;
        boolean isCycle = false;
        while (slow != null && fast != null) {
            slow = slow.getNext();
            fast = fast.getNext().getNext();
            if (slow == fast) {
                isCycle = true;
                break;
            }
        }
        return isCycle;
    }
        /*Node temp = first;
        boolean toReturn = false;
        while (temp.getNext() != null) {
            if (temp.isFlag()) {
                toReturn = true;
                break;
            }
            temp.setFlag(true);
            temp = temp.getNext();
        }
        return toReturn;*/

}

/**
 * Simple Node class.
 *
 * @param <T> - generic.
 */
class Node<T> {
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
     * Setter.
     *
     * @param next - next.
     */
    public void setNext(Node<T> next) {
        this.next = next;
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