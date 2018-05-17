package ru.job4j.simplecollection.simpletree;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Optional;
import java.util.Queue;

public class JustTree implements SimpleTree {
    Node root;

    @Override
    public boolean add(Comparable parent, Comparable child) {
        Node currentParent = (Node)parent;
        if(this.root==null){
            root = (Node)parent;
        }
        return false;
    }

    @Override
    public Optional<Node> findBy(Comparable value) {
        Optional<Node> rsl = Optional.empty();
        Queue<Node> data = new LinkedList<>();
        data.offer(this.root);
        while (!data.isEmpty()) {
            Node el = data.poll();
            if (el.eqValue(value)) {
                rsl = Optional.of(el);
                break;
            }
            for (Object child : el.leaves()) {
                data.offer((Node) child);
            }
        }
        return rsl;
    }


    @Override
    public Iterator iterator() {
        return null;
    }
}
