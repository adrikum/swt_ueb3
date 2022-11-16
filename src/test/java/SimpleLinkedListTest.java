import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

class SimpleLinkedListTest {

    @Test
    void add() {
        SimpleLinkedList<Integer> list = new SimpleLinkedList<>();
        list.add(1);
        list.add(5);
        list.add(3);

        int[] arr = new int[]{1,5,3};
        int i = 0;

        Iterator<Integer> iter = list.iterator();
        while(iter.hasNext()) {
            int tmp = iter.next();
            assertEquals(arr[i],tmp);
            i++;
        }
    }

    @Test
    void size() {
        SimpleLinkedList<Integer> list = new SimpleLinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        assertEquals(3,list.size());
    }

    @Test
    void iterator() {
    }
}