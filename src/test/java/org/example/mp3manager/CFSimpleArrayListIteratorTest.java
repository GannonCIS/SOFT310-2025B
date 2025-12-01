package org.example.mp3manager;

import org.junit.jupiter.api.Test;

import java.util.ListIterator;

import static org.junit.jupiter.api.Assertions.*;

class CFSimpleArrayListIteratorTest {

    @Test
    void controlFlow_next_and_previous() {
        SimpleArrayList<String> list = new SimpleArrayList<>();
        list.add("X");

        ListIterator<String> it = list.listIterator(0);

        assertTrue(it.hasNext());
        assertEquals("X", it.next());
        assertFalse(it.hasNext());

        assertTrue(it.hasPrevious());
        assertEquals("X", it.previous());
        assertFalse(it.hasPrevious());
    }
}
