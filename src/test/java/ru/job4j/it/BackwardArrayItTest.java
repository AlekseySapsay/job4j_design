package ru.job4j.it;

import org.junit.Test;
import java.util.NoSuchElementException;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;

public class BackwardArrayItTest {
    @Test
    public void whenMultiCallhasNextThenTrue() {
        BackwardArrayIt it = new BackwardArrayIt(new int[]{1, 2, 3, 4});
        assertEquals(it.hasNext(), is(true));
        assertEquals(it.hasNext(), is(true));
        assertEquals(it.hasNext(), is(true));
    }

    @Test
    public void whenReadSequence() {
        BackwardArrayIt it = new BackwardArrayIt(new int[]{1, 2, 3, 4});
        assertEquals(it.next(), is(4));
        assertEquals(it.next(), is(3));
        assertEquals(it.next(), is(2));
        assertEquals(it.next(), is(1));
    }

    @Test(expected = NoSuchElementException.class)
    public void whenNextFromEmpty() {
        BackwardArrayIt it = new BackwardArrayIt(
                new int[]{}
        );
        it.next();
    }
}