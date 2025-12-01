package org.example.mp3manager;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FTFunction11_EnsureCapacityTest {

    @Test
    void capacityExpands() {
        SimpleArrayList<Integer> list = new SimpleArrayList<>();

        for (int i = 0; i < 25; i++) list.add(i);

        assertEquals(25, list.size());
        assertEquals(24, list.get(24));
    }
}
