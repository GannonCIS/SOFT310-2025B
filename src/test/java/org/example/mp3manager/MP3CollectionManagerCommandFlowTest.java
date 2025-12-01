package org.example.mp3manager;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.*;

class CFMP3CollectionSearchFlowTest {

    private MP3Collection build(Mp3File[] arr) throws Exception {
        MP3Collection c = new MP3Collection();
        Field f = MP3Collection.class.getDeclaredField("Mp3Library");
        f.setAccessible(true);
        f.set(c, arr);
        return c;
    }

    private Mp3File file(String title) {
        Mp3File f = new Mp3File("dummy");
        f.setTitle(title);
        return f;
    }

    @Test
    void controlFlow_search_found_and_notFound() throws Exception {
        Mp3File a = file("A");
        Mp3File b = file("B");
        Mp3File c = file("C");

        MP3Collection col = build(new Mp3File[]{a, b, c});
        col.sort(new TitleComparator());

        int found = col.search(file("B"), new TitleComparator());
        int notFound = col.search(file("Z"), new TitleComparator());

        assertEquals(1, found);
        assertEquals(-1, notFound);
    }
}