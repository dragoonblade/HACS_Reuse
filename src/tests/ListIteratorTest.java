package tests;

import hacs.ListIterator;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ListIteratorTest {
    private static String TEST_STRING = "Test";

    @Test
    void testHasNextSuccess() {
        ArrayList<Object> list = new ArrayList<Object>();
        list.add(TEST_STRING);
        ListIterator iterator = new ListIterator(list);
        assertEquals(true, iterator.hasNext());
    }

    @Test
    void testHasNextFailure() {
        ArrayList<Object> list = new ArrayList<Object>();
        ListIterator iterator = new ListIterator(list);
        assertEquals(false, iterator.hasNext());
    }

    @Test
    void testNextSuccess() {
        ArrayList<Object> list = new ArrayList<Object>();
        list.add(TEST_STRING);
        ListIterator iterator = new ListIterator(list);
        assertEquals(TEST_STRING, iterator.next());
    }

    @Test
    void testNextFailure() {
        ArrayList<Object> list = new ArrayList<Object>();
        ListIterator iterator = new ListIterator(list);
        assertEquals(null, iterator.next());
    }

    @Test
    void testRemoveSuccess() {
        ArrayList<Object> list = new ArrayList<Object>();
        list.add(TEST_STRING);
        ListIterator iterator = new ListIterator(list);
        iterator.next();
        iterator.remove();
        assertEquals(0, list.size());
    }

    @Test
    void testRemoveFailure() {
        ArrayList<Object> list = new ArrayList<Object>();
        ListIterator iterator = new ListIterator(list);
        iterator.next();
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> iterator.remove());
    }
}