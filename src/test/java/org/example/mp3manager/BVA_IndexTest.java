package org.example.mp3manager;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BVA_IndexTest {

    @Test
    void robustAndNormalBVA_onIndex() {
        SimpleArrayList<Integer> list = new SimpleArrayList<>();

        for (int i = 0; i < 10; i++) list.add(i);

        assertThrows(IndexOutOfBoundsException.class, () -> list.get(-1));

        assertEquals(0, list.get(0));

        assertEquals(1, list.get(1));

        assertEquals(5, list.get(5));

        assertEquals(8, list.get(8));

        assertEquals(9, list.get(9));

        assertThrows(IndexOutOfBoundsException.class, () -> list.get(10));
    }
}