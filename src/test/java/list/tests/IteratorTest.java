package list.tests;

import list.SimpleLinkedList;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class IteratorTest {

    @Test
    public void hasNextTest() {
        SimpleLinkedList<Integer> list = new SimpleLinkedList<>();
        for(int i = 0; i < 5; i++) list.add(i);

        Iterator<Integer> it = list.iterator();
        for(int i = 0; i < 5; i++) {
            assertTrue(it.hasNext());
            it.next();
        }

        assertFalse(it.hasNext());
    }

    @Test
    public void hasNextEmptyList() {
        SimpleLinkedList<Integer> list = new SimpleLinkedList<>();
        assertFalse(list.iterator().hasNext());
    }

    @Test
    public void nextReturnsAllElementsAndCorrectOrder() {
        SimpleLinkedList<Integer> list = new SimpleLinkedList<>();
        for(int i = 0; i < 5; i++) list.add(i);

        Iterator<Integer> it = list.iterator();
        for(int i = 0; i < 5; i++) {
            assertEquals(it.next(), i);
        }
    }

    @Test
    public void nextThrowsExceptionAtEnd() {
        SimpleLinkedList<Integer> list = new SimpleLinkedList<>();
        list.add(0);

        Iterator<Integer> it = list.iterator();
        it.next();
        assertThrows(NoSuchElementException.class, it::next);
    }

    @Test
    public void removeElement() {
        // add all test values and remove 3
        SimpleLinkedList<Integer> list = new SimpleLinkedList<>();
        for(int i = 0; i < 5; i++) list.add(i);
        for(Iterator<Integer> it = list.iterator(); it.hasNext();) {
            if(it.next() == 3) it.remove();
        }

        // validate that 3 is not in the list
        for(Iterator<Integer> it = list.iterator(); it.hasNext();) {
            assertNotEquals(it.next(), 3);
        }
    }

    @Test
    public void removeFirstElement() {
        SimpleLinkedList<Integer> list = new SimpleLinkedList<>();
        for(int i = 0; i < 5; i++) list.add(i);

        // remove first element, 0
        Iterator<Integer> it = list.iterator();
        it.next();
        it.remove();

        // first element should be 1 now
        assertEquals(list.iterator().next(), 1);
    }

    @Test
    public void removeLastElement() {
        SimpleLinkedList<Integer> list = new SimpleLinkedList<>();
        for(int i = 0; i < 5; i++) list.add(i);

        // remove number 4
        for(Iterator<Integer> it = list.iterator(); it.hasNext();) {
            int i = it.next();
            if(i == 4) it.remove();
        }

        // validate that list goes from 0 to 3
        int i = 0;
        for(Iterator<Integer> it = list.iterator(); it.hasNext();) {
            if(i == 4) fail("last element is still in the list");
            assertEquals(it.next(), i++);
        }
    }

    @Test
    public void intactDataStructureAfterRemove() {
        SimpleLinkedList<Integer> simpleLinkedList = new SimpleLinkedList<>();
        List<Integer> builtInList = new LinkedList<>();
        for(int i = 0; i < 5; i++) {
            builtInList.add(i);
            simpleLinkedList.add(i);
        }

        // remove number 3
        builtInList.remove(3);
        for(Iterator<Integer> it = simpleLinkedList.iterator(); it.hasNext();) {
            if(it.next() == 3) it.remove();
        }

        // add 4, 5, 6
        for(int i = 4; i <= 6; i++) {
            builtInList.add(i);
            simpleLinkedList.add(i);
        }

        // validate list content
        Iterator<Integer> it = simpleLinkedList.iterator();
        for(int i : builtInList) {
            assertEquals(it.next(), i);
        }

        // validate no more elements
        assertFalse(it.hasNext());
    }
}
