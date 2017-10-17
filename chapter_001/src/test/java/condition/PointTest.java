package condition;

import org.junit.Test;
import ru.job4j.condition.Point;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Point Test.
 *
 * @author Kuzmin Danila (mailto:bus1d0@mail.ru)
 * @version $Id$
 * @since 0.1
 */
public class PointTest {
    /**
     * Test Pont x=1;y=1.
     * a=0,b=1;
     */
    @Test
    public void whenPointOnLineThenTrue() {
        //create of new point.
        Point a = new Point(1, 1);
        boolean rsl = a.is(0, 1);
        assertThat(rsl, is(true));
    }
    /**
     * Test Pont x=1;y=1.
     * a=2,b=-1;
     */
    @Test
    public void whenPointOnLineAndBNegativeThenTrue() {
        Point a = new Point(1, 1);
        boolean rsl = a.is(2, -1);
        assertThat(rsl, is(true));
    }
    /**
     * Test Pont x=0;y=1.
     * a=2,b=3;
     */
    @Test
    public void whenPointIsNotOnLineThenFalse() {
        Point a = new Point(0, 1);
        boolean rsl = a.is(2, 3);
        assertThat(rsl, is(false));
    }
}
