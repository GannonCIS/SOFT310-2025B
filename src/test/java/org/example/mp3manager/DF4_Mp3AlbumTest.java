package org.example.mp3manager;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DF4_Mp3AlbumTest {

    @Test
    void albumDefinitionToUse() {
        Mp3File f = new Mp3File("p");
        f.setAlbum("Best Album");
        assertEquals("Best Album", f.getAlbum());
    }
}