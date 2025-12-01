package org.example.mp3manager;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FTFunction10_UnknownValueTest {

    @Test
    void unknownValues() {
        Mp3File f = new Mp3File("p");

        f.setTitle("Unknown");
        f.setDate("1900");

        assertEquals("Unknown", f.getTitle());
        assertEquals("1900", f.getDate());
    }
}
