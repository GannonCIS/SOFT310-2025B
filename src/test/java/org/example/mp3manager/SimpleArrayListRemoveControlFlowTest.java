package org.example.mp3manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SimpleArrayListRemoveControlFlowTest {

    private SimpleArrayList<String> list;

    @BeforeEach
    void setUp() {
        list = new SimpleArrayList<>();
    }

    @Test
    void testRemoveFromMiddle() {
        list.add("A");
        list.add("B");
        list.add("C");

        String removed = list.remove(1); // Remove "B"

        assertEquals("B", removed);
        assertEquals(2, list.size());
        assertEquals("A", list.get(0));
        assertEquals("C", list.get(1));
    }

    @Test
    void testRemoveFromEnd() {
        list.add("A");
        list.add("B");
        list.add("C");

        String removed = list.remove(2); // Remove "C"

        assertEquals("C", removed);
        assertEquals(2, list.size());
        assertEquals("A", list.get(0));
        assertEquals("B", list.get(1));
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(2));
    }

    @Test
    void testRemoveFromBeginning() {
        list.add("A");
        list.add("B");
        list.add("C");

        String removed = list.remove(0); // Remove "A"

        assertEquals("A", removed);
        assertEquals(2, list.size());
        assertEquals("B", list.get(0));
        assertEquals("C", list.get(1));
    }

    @Test
    void testRemoveOnlyElement() {
        list.add("A");
        String removed = list.remove(0); // Remove "A"

        assertEquals("A", removed);
        assertEquals(0, list.size());
        assertTrue(list.isEmpty());
    }

    @Test
    void testRemoveFromEmptyList() {
        assertThrows(IndexOutOfBoundsException.class, () -> list.remove(0));
    }

    @Test
    void testRemoveWithNegativeIndex() {
        list.add("A");
        assertThrows(IndexOutOfBoundsException.class, () -> list.remove(-1));
    }

    @Test
    void testRemoveWithIndexEqualsSize() {
        list.add("A");
        list.add("B");
        assertThrows(IndexOutOfBoundsException.class, () -> list.remove(2));
    }
}