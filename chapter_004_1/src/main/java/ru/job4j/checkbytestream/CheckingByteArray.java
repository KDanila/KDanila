package ru.job4j.checkbytestream;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * ConvertIterator class.
 *
 * @author Kuzmin Danila (mailto:bus1d0@mail.ru)
 * @version $Id$
 * @since 0.1.0
 */
public class CheckingByteArray {
    /**
     * Method checks inputstream. If write even number --> true.
     *
     * @param in
     * @return
     */
    boolean isNumber(InputStream in) {
        boolean isNumber = false;
        try(BufferedReader br = new BufferedReader(new InputStreamReader(in))) {
            isNumber = br.lines().anyMatch(x->Integer.valueOf(x)%2==0);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return isNumber;
    }
}
