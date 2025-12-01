package org.example.mp3manager;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class FTFunction03_AddToCollectionTest {

    @Test
    void addToSimpleArrayList() {
        SimpleArrayList<String> list = new SimpleArrayList<>();
        list.add("A");
        list.add("B");

        assertEquals(2, list.size());
        assertEquals("B", list.get(1));
    }
}
