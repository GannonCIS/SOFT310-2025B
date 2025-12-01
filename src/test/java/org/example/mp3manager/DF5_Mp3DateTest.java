package org.example.mp3manager;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DF5_Mp3DateTest {

    @Test
    void dateDefinitionToUse() {
        Mp3File f = new Mp3File("p");
        f.setDate("2001");
        assertEquals("2001", f.getDate());
    }
}