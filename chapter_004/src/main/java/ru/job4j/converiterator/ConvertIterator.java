package ru.job4j.converiterator;

import java.util.Iterator;

/**
 * ConvertIterator class.
 *
 * @author Kuzmin Danila (mailto:bus1d0@mail.ru)
 * @version $Id$
 * @since 0.1.0
 */
public class ConvertIterator {
    /**
     * Convert Iterator of Iterators to Iterator<Integer>.
     *
     * @param it - Iterator<Iterator<Integer>>.
     * @return Iterator<Integer>.
     */
    Iterator convert(Iterator<Iterator<Integer>> it) {

        return new Iterator() {
            private int position = 0;

            @Override
            public boolean hasNext() {
                return it.hasNext();
            }

            @Override
            public Object next() {
                Iterator<Integer> tempIterator;
                int counter = 0;
                while (it.hasNext()) {
                    tempIterator = it.next();
                    while (tempIterator.hasNext()) {
                        if (counter == position) {
                            position++;
                            return tempIterator.next();
                        }
                    }
                }
                return -1;
            }
        };

/*

        Iterator<Integer> tempIterator;
        Iterator<Integer> toReturn;
        ArrayList<Integer> tempInt = new ArrayList<>();
        while (it.hasNext()) {
            tempIterator = it.next();
            while (tempIterator.hasNext()) {
                tempInt.add(tempIterator.next());
            }
        }
        toReturn = tempInt.iterator();
        return toReturn;*/
    }
}
