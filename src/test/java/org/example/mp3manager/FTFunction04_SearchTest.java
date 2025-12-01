package org.example.mp3manager;

import org.junit.jupiter.api.Test;
import java.lang.reflect.Field;
import static org.junit.jupiter.api.Assertions.*;

class FTFunction04_SearchTest {

    private MP3Collection build(Mp3File[] arr) throws Exception {
        MP3Collection c = new MP3Collection();
        Field f = MP3Collection.class.getDeclaredField("Mp3Library");
        f.setAccessible(true);
        f.set(c, arr);
        return c;
    }

    private Mp3File file(String title) {
        Mp3File f = new Mp3File("p");
        f.setTitle(title);
        return f;
    }

    @Test
    void searchFound() throws Exception {
        MP3Collection col = build(new Mp3File[]{
                file("A"), file("B"), file("C")
        });

        col.sort(new TitleComparator());

        assertEquals(1, col.search(file("B"), new TitleComparator()));
    }
}
