package org.example.mp3manager;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TitleComparatorTest {

    private Mp3File make(String album, String title, int year) {
        Mp3File f = new Mp3File("test.mp3");
        f.setAlbum(album);
        f.setTitle(title);
        f.setYear(year);
        return f;
    }

    @Test
    void firstTitleBeforeSecond() {
        Mp3File first = make("AlbumA", "AAA", 2000);
        Mp3File second = make("AlbumB", "BBB", 2001);
        TitleComparator comp = new TitleComparator();
        assertTrue(comp.compare(first, second) < 0);
    }

    @Test
    void titlesAreEqual() {
        Mp3File first = make("AlbumA", "Same", 2000);
        Mp3File second = make("AlbumB", "Same", 2001);
        TitleComparator comp = new TitleComparator();
        assertEquals(0, comp.compare(first, second));
    }

    @Test
    void firstTitleAfterSecond() {
        Mp3File first = make("AlbumA", "ZZZ", 2000);
        Mp3File second = make("AlbumB", "AAA", 2001);
        TitleComparator comp = new TitleComparator();
        assertTrue(comp.compare(first, second) > 0);
    }
}
