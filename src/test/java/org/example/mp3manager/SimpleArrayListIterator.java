package org.example.mp3manager;

import org.junit.jupiter.api.Test;

import java.util.ConcurrentModificationException;
import java.util.ListIterator;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class SimpleArrayListIteratorTest {

    @Test
    void iteratorStartsAtGivenIndex() {
        SimpleArrayList<Integer> list = new SimpleArrayList<>();
        list.add(10);
        list.add(20);
        list.add(30);

        ListIterator<Integer> it = list.listIterator(1);
        assertTrue(it.hasNext());
        assertEquals(20, it.next());
    }

    @Test
    void nextAndHasNextTraverseForward() {
        SimpleArrayList<Integer> list = new SimpleArrayList<>();
        list.add(1);
        list.add(2);

        ListIterator<Integer> it = list.listIterator(0);
        assertTrue(it.hasNext());
        assertEquals(1, it.next());
        assertTrue(it.hasNext());
        assertEquals(2, it.next());
        assertFalse(it.hasNext());
    }

    @Test
    void previousAndHasPreviousTraverseBackward() {
        SimpleArrayList<Integer> list = new SimpleArrayList<>();
        list.add(1);
        list.add(2);

        ListIterator<Integer> it = list.listIterator(2); // после последнего
        assertTrue(it.hasPrevious());
        assertEquals(2, it.previous());
        assertTrue(it.hasPrevious());
        assertEquals(1, it.previous());
        assertFalse(it.hasPrevious());
    }

    @Test
    void nextOnEndThrowsNoSuchElement() {
        SimpleArrayList<Integer> list = new SimpleArrayList<>();
        list.add(1);

        ListIterator<Integer> it = list.listIterator(1); // сразу после последнего
        assertThrows(NoSuchElementException.class, it::next);
    }

    @Test
    void concurrentModificationDetected() {
        SimpleArrayList<Integer> list = new SimpleArrayList<>();
        list.add(1);
        list.add(2);

        ListIterator<Integer> it = list.listIterator(0);
        // модифицируем список после создания итератора
        list.add(3);

        assertThrows(ConcurrentModificationException.class, it::next);
    }
}
