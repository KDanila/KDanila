package ru.job4j.simplecollection.simpletree;

import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class SimpleTreeTest {

    @Test
    public void whenUseSearchByShouldReturnCorrectly() {
        JustTree<Integer> justTree = new JustTree<>();
        justTree.add(1, 2);
        justTree.add(1, 3);
        justTree.add(1, 4);
        justTree.add(2, 6);
        justTree.add(2, 7);
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

    @Test
    public void when6ElFindNotExitThenOptionEmpty() {
        JustTree<Integer> tree = new JustTree<>(1);
        tree.add(1, 2);
        assertThat(
                tree.findBy(7).isPresent(),
                is(false)
        );
    }
}

