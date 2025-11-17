package org.example.mp3manager;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.*;

class MP3CollectionSortLoopTest {

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
    void sortAlreadySorted() throws Exception {
        Mp3File a = file("A");
        Mp3File b = file("B");
        Mp3File c = file("C");

        MP3Collection col = build(new Mp3File[]{a, b, c});
        col.sort(new TitleComparator());

        assertEquals("A", col.getFile(0).getTitle());
        assertEquals("B", col.getFile(1).getTitle());
        assertEquals("C", col.getFile(2).getTitle());
    }

    @Test
    void sortReverseOrder() throws Exception {
        Mp3File a = file("A");
        Mp3File b = file("B");
        Mp3File c = file("C");

        MP3Collection col = build(new Mp3File[]{c, b, a});
        col.sort(new TitleComparator());

        assertEquals("A", col.getFile(0).getTitle());
        assertEquals("B", col.getFile(1).getTitle());
        assertEquals("C", col.getFile(2).getTitle());
    }

    @Test
    void sortAllEqual() throws Exception {
        Mp3File a = file("X");
        Mp3File b = file("X");
        Mp3File c = file("X");

        MP3Collection col = build(new Mp3File[]{a, b, c});
        col.sort(new TitleComparator());

        assertEquals("X", col.getFile(0).getTitle());
        assertEquals("X", col.getFile(1).getTitle());
        assertEquals("X", col.getFile(2).getTitle());
    }

    @Test
    void sortSingleElement() throws Exception {
        Mp3File a = file("Only");

        MP3Collection col = build(new Mp3File[]{a});
        col.sort(new TitleComparator());

        assertEquals("Only", col.getFile(0).getTitle());
    }

    @Test
    void sortEmptyArray() throws Exception {
        MP3Collection col = build(new Mp3File[]{});
        col.sort(new TitleComparator());

        assertEquals(0, col.size());
    }
}
