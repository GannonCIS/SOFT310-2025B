package org.example.mp3manager;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class FTFunction09_IterationTest {

    @Test
    void iterateViaGet() {
        SimpleArrayList<String> list = new SimpleArrayList<>();
        list.add("A");
        list.add("B");

        assertEquals("A", list.get(0));
        assertEquals("B", list.get(1));
    }
}
