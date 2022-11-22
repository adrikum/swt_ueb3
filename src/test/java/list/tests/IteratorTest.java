package list.tests;

import list.SimpleLinkedList;
import org.junit.jupiter.api.Test;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class IteratorTest {

    @Test
    void iterator() {
        SimpleLinkedList<Integer> list = new SimpleLinkedList<>();
        list.add(1);
        list.add(16);

        //hasNext()
        Iterator<Integer> it = list.iterator();
        assertTrue(it.hasNext());

        //next()
        assertTrue(it.next() == 1);
        assertTrue(it.next() == 16);
        assertFalse(it.hasNext());

        //remove()
        Exception exception = assertThrows(UnsupportedOperationException.class, () ->
                it.remove());
        assertEquals(null, exception.getMessage());
    }

}
