package org.example.mp3manager;

import org.junit.jupiter.api.Test;
import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.*;

class FTFunction07_SortTest {

    private MP3Collection build(Mp3File[] arr) throws Exception {
        MP3Collection c = new MP3Collection();
        Field f = MP3Collection.class.getDeclaredField("Mp3Library");
        f.setAccessible(true);
        f.set(c, arr);
        return c;
    }

    private Mp3File file(String title) {
        Mp3File f = new Mp3File("x");
        f.setTitle(title);
        return f;
    }

    @Test
    void sortByTitle() throws Exception {
        MP3Collection col = build(new Mp3File[]{
                file("C"), file("A"), file("B")
        });

        col.sort(new TitleComparator());

        assertEquals("A", col.getFile(0).getTitle());
        assertEquals("B", col.getFile(1).getTitle());
        assertEquals("C", col.getFile(2).getTitle());
    }
}
