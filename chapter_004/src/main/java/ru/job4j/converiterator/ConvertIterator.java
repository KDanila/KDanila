package ru.job4j.converiterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

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
    Iterator<Integer> convert(Iterator<Iterator<Integer>> it) {
        return new Iterator<Integer>() {
            private int position = 0;
            private Iterator tempIterator = it.next();

            @Override
            public boolean hasNext() {
                return tempIterator.hasNext();
            }

            @Override
            public Integer next() throws NoSuchElementException {
                int counter = 0;
                int toReturn = -1;
                while (tempIterator.hasNext()) {
                    if (counter == this.position) {
                        this.position++;
                        toReturn = (Integer) tempIterator.next();
                        if (!tempIterator.hasNext() && it.hasNext()) {
                            tempIterator = it.next();
                            this.position = 0;
                        }
                        break;
                    }
                    counter++;

                }
                if (toReturn == -1) {
                    throw new NoSuchElementException();
                }

                return toReturn;
            }
        };

        /*        Iterator<Integer> tempIterator;
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
