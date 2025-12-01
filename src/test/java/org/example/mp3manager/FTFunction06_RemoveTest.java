package org.example.mp3manager;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class FTFunction06_RemoveTest {

    @Test
    void removeElement() {
        SimpleArrayList<String> list = new SimpleArrayList<>();
        list.add("A");
        list.add("B");

        String removed = list.remove(0);

        assertEquals("A", removed);
        assertEquals("B", list.get(0));
    }
}
