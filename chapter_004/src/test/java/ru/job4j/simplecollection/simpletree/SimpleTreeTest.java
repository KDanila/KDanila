package ru.job4j.simplecollection.simpletree;

import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * JustTree class.
 *
 * @author Kuzmin Danila (mailto:bus1d0@mail.ru)
 * @version $Id$
 * @since 0.1.0
 */
public class SimpleTreeTest {
    /**
     * The first test.
     * Add and findBy.
     */
    @Test
    public void when6ElFindLastThen6() {
        JustTree<Integer> tree = new JustTree<>(1);
        tree.add(1, 2);
        tree.add(1, 3);
        tree.add(1, 4);
        tree.add(4, 5);
        tree.add(5, 6);
        assertThat(
                tree.findBy(6).isPresent(),
                is(true)
        );
    }

    /**
     * The Second Test.
     * isPresent test.
     */
    @Test
    public void when6ElFindNotExitThenOptionEmpty() {
        JustTree<Integer> tree = new JustTree<>(1);
        tree.add(1, 2);
        assertThat(
                tree.findBy(7).isPresent(),
                is(false)
        );
    }

    /**
     * The Third test.
     * Iterator testing.
     */
    @Test
    public void whenUseIteratorShouldReturnCorreclyValues() {
        JustTree<Integer> tree = new JustTree<>(1);
        tree.add(1, 2);
        tree.add(1, 3);
        tree.add(1, 4);
        tree.add(4, 5);
        tree.add(5, 6);
        Iterator it = tree.iterator();
        assertThat(((Node) it.next()).getValue(), is(1));
        assertThat(((Node) it.next()).getValue(), is(2));
        assertThat(((Node) it.next()).getValue(), is(3));
        assertThat(((Node) it.next()).getValue(), is(4));
        assertThat(((Node) it.next()).getValue(), is(5));
        assertThat(((Node) it.next()).getValue(), is(6));
        assertThat(it.hasNext(), is(false));
    }

/*
    @Test
    public void whenUseSearchByShouldReturnCorrectly() {
        JustTree<Integer> justTree = new JustTree<>();
        justTree.add(1, 2);
        justTree.add(1, 3);
        justTree.add(1, 4);
        justTree.add(2, 6);
        justTree.add(2, 6);
        justTree.add(2, 7);
        justTree.add(3, 6);
        justTree.add(3, 6);
        System.out.println(justTree.root.getValue());
        for (Node in : justTree.root.leaves()) {
            System.out.println(in.getValue());
            if (in.leaves() != null) {

                for (Node aa : (ArrayList<Node>) in.leaves()) {
                    System.out.println("===============");
                    System.out.println(aa.getValue());
                    System.out.println("===============");
                }
            }
        }
    }
*/

}

