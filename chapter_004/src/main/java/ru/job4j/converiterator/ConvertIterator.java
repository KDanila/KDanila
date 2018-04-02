package ru.job4j.converiterator;

import java.util.ArrayList;
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
    Iterator<Integer> convert(Iterator<Iterator<Integer>> it) {
        return new Iterator<Integer>() {
            int position = 0;
            @Override
            public boolean hasNext() {
                return it.hasNext();
            }

            @Override
            public Integer next() {
                Iterator tempIterator;
                int counter = 0;
                int toReturn=-1;
                while (it.hasNext()) {
                    tempIterator = it.next();
                    while (tempIterator.hasNext()) {
                        if(counter==this.position){
                            this.position ++;
                            return (Integer) tempIterator.next();
                        }
                        counter++;
                        tempIterator.next();
                    }
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
