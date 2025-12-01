package org.example.mp3manager;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class FTFunction02_Mp3FileCreationTest {

    @Test
    void createMp3File() {
        Mp3File f = new Mp3File("path");
        f.setTitle("A");
        f.setAlbum("B");
        f.setAuthor("C");
        f.setDate("2000");

        assertEquals("A", f.getTitle());
        assertEquals("B", f.getAlbum());
        assertEquals("C", f.getAuthor());
        assertEquals("2000", f.getDate());
    }
}