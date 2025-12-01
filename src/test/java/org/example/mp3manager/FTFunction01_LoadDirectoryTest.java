package org.example.mp3manager;

import org.junit.jupiter.api.Test;
import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

class FTFunction01_LoadDirectoryTest {

    @Test
    void loadDirectory_mp3Only() throws Exception {
        File dir = new File("test_mp3_dir");
        dir.mkdir();

        File f1 = new File(dir, "song1.mp3");
        File f2 = new File(dir, "song2.txt");
        f1.createNewFile();
        f2.createNewFile();

        MP3Collection col = new MP3Collection(dir.getAbsolutePath());

        assertEquals(1, col.size());

        f1.delete();
        f2.delete();
        dir.delete();
    }
}