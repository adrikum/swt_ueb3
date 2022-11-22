package list.tests;

import list.SimpleLinkedList;
import org.junit.jupiter.api.Test;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

/*
TODO Tuan:
    1. refaktorisieren
    2. hasNext(): true wenn es mehr elemente gibt, false wenn beim letzten
    3. next(): gibt richtiges element zurück und wirft exception wenn beim letzten
    4. remove():    - entfernt das element aus der liste, datenstuktur geht nicht kaputt
                    - edge cases: updatet start variable wenn das erste element entfernt wird
                                  updatet end variable wenn letztes element entfernt wird
 */
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
        it.remove();
        assertEquals(list.size(), 1);
    }

}
