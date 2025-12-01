package org.example.mp3manager;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DF3_Mp3AuthorTest {

    @Test
    void authorDefinitionToUse() {
        Mp3File f = new Mp3File("p");
        f.setAuthor("John");
        assertEquals("John", f.getAuthor());
    }
}
