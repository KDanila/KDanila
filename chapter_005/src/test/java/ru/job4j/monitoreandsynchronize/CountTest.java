package ru.job4j.monitoreandsynchronize;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * CountTest class.
 *
 * @author Kuzmin Danila (mailto:bus1d0@mail.ru)
 * @version $Id$
 * @since 0.1.0
 */
public class CountTest {

    /**
     * Класс описывает нить со счетчиком.
     */
    private class ThreadCount extends Thread {
        /**
         * Count.
         */
        private final Count count;

        /**
         * Constructor.
         *
         * @param count -count
         */
        private ThreadCount(final Count count) {
            this.count = count;
        }

        /**
         * Override run method.
         */
        @Override
        public void run() {
            this.count.increment();
        }
    }

    /**
     * Test method.
     *
     * @throws InterruptedException -exception.
     */
    @Test
    public void whenExecute2ThreadThen2() throws InterruptedException {
        //Создаем счетчик.
        final Count count = new Count();
        //Создаем нити.
        Thread first = new ThreadCount(count);
        Thread second = new ThreadCount(count);
        //Запускаем нити.
        first.start();
        second.start();
        //Заставляем главную нить дождаться выполнения наших нитей.
        first.join();
        second.join();
        //Проверяем результат.
        assertThat(count.get(), is(2));
    }
}