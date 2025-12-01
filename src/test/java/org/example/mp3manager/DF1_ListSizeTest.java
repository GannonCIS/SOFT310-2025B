package org.example.mp3manager;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DF1_ListSizeTest {

    @Test
    void countDefinitionToUse() {
        SimpleArrayList<String> list = new SimpleArrayList<>();
        list.add("A");
        list.add("B");
        list.remove(0);
        assertEquals(1, list.size());
    }
}