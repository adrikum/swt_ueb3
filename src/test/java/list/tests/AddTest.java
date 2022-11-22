package list.tests;

import list.SimpleLinkedList;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

/*
TODO Cong Linh:
    1. list.add(e) gibt true zurück
 */

public class AddTest {

    @Test
    void containsAllElementsAndCorrectOrder() {
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
    void addTest() {
        SimpleLinkedList<String> list = new SimpleLinkedList<>();
        for (int i = 0; i < 10; i++) {
            assertTrue(list.add(Integer.toString(i)));
        }

        for (int i = 0; i < 10; i++) {
            assertTrue(list.contains(Integer.toString(i)));
        }

        assertFalse(list.add(null));
        assertFalse(list.contains(null));

    }

}
