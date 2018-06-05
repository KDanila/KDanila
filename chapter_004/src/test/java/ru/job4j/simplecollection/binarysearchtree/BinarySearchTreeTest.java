package ru.job4j.simplecollection.binarysearchtree;

import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * BinarySearchTreeTest class.
 *
 * @author Kuzmin Danila (mailto:bus1d0@mail.ru)
 * @version $Id$
 * @since 0.1.0
 */
public class BinarySearchTreeTest {
    /**
     * First test.
     */
    @Test
    public void whenAddThenAdded() {
        BinarySearchTree<Integer> binarySearchTree = new BinarySearchTree<>();
        binarySearchTree.add(1);
        binarySearchTree.add(2);
        binarySearchTree.add(3);
        binarySearchTree.add(4);
        binarySearchTree.add(5);
        Iterator it = binarySearchTree.iterator();

        assertThat(((Node) it.next()).getValue(), is(1));
        assertThat(((Node) it.next()).getValue(), is(2));
        assertThat(((Node) it.next()).getValue(), is(3));
        assertThat(((Node) it.next()).getValue(), is(4));
        assertThat(((Node) it.next()).getValue(), is(5));
    }

    /**
     * Second test.
     */
    @Test
    public void whenAddNonSequentArrayThenAdded() {
        BinarySearchTree<Integer> binarySearchTree = new BinarySearchTree<>();
        binarySearchTree.add(1);
        binarySearchTree.add(10);
        binarySearchTree.add(5);
        binarySearchTree.add(15);
        binarySearchTree.add(20);
        Iterator it = binarySearchTree.iterator();
        assertThat(((Node) it.next()).getValue(), is(1));
        assertThat(((Node) it.next()).getValue(), is(10));
        assertThat(((Node) it.next()).getValue(), is(5));
        assertThat(((Node) it.next()).getValue(), is(15));
        assertThat(((Node) it.next()).getValue(), is(20));
    }

}