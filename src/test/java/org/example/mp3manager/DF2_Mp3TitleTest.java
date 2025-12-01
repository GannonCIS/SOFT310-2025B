package org.example.mp3manager;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DF2_Mp3TitleTest {

    @Test
    void titleDefinitionToUse() {
        Mp3File f = new Mp3File("p");
        f.setTitle("Hello");
        assertEquals("Hello", f.getTitle());
    }
}