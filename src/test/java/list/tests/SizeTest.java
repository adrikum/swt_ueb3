package list.tests;

import list.SimpleLinkedList;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
TODO Victoria:
    1. korrekte größe nach entfernen, iterator.remove()
 */
public class SizeTest {

    @Test
    void sizeAfterAdd() {
        SimpleLinkedList<Integer> list = new SimpleLinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        assertEquals(3,list.size());
    }

    @Test
    public void sizeAfterRemove() {
        SimpleLinkedList<Integer> list = new SimpleLinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        for(Iterator<Integer> it = list.iterator(); it.hasNext();) {
            it.next();
            it.remove();
        }

        assertEquals(0, list.size());
    }
}
