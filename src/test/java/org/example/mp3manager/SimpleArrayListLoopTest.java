package org.example.mp3manager;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SimpleArrayListLoopTest {

    @Test
    void testAddLoopAndResize() {
        SimpleArrayList<Integer> list = new SimpleArrayList<>();
        for (int i = 0; i < 50; i++) {
            list.add(i);
        }
        assertEquals(50, list.size());
        assertEquals(Integer.valueOf(0), list.get(0));
        assertEquals(Integer.valueOf(49), list.get(49));
    }

    @Test
    void testRemoveLoopUntilEmpty() {
        SimpleArrayList<Integer> list = new SimpleArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        for (int i = 0; i < 10; i++) {
            list.remove(0);
        }
        assertEquals(0, list.size());
    }

    @Test
    void testAccessAfterResize() {
        SimpleArrayList<Integer> list = new SimpleArrayList<>();
        for (int i = 0; i < 25; i++) {
            list.add(i);
        }
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(100));
    }
}
