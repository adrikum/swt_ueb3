package list.tests;

import list.SimpleLinkedList;
import org.junit.jupiter.api.Test;

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

}
