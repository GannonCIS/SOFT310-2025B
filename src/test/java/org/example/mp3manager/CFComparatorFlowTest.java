package org.example.mp3manager;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CFComparatorFlowTest {

    private Mp3File file(String title, String album, String author, String year) {
        Mp3File f = new Mp3File("dummy");
        f.setTitle(title);
        f.setAlbum(album);
        f.setAuthor(author);
        f.setDate(year);
        try {
            f.setYear(Integer.parseInt(year));
        } catch (Exception ignored) {}
        return f;
    }


    @Test
    void controlFlow_allComparatorBranches() {
        Mp3File f1 = file("Song A", "AlbumX", "AuthorX", "2000");
        Mp3File f2 = file("Song B", "AlbumX", "AuthorX", "2001");
        Mp3File f3 = file("Song A", "AlbumY", "AuthorY", "1999");

        AlbumComparator albumComp = new AlbumComparator();
        AuthorComparator authorComp = new AuthorComparator();
        TitleComparator titleComp = new TitleComparator();
        DateComparator dateComp = new DateComparator();

        assertEquals(0, albumComp.compare(f1, f2));
        assertTrue(albumComp.compare(f1, f3) < 0);

        assertEquals(0, authorComp.compare(f1, f2));
        assertTrue(authorComp.compare(f1, f3) < 0);

        assertTrue(titleComp.compare(f1, f2) < 0);
        assertEquals(0, titleComp.compare(f1, f1));

        assertTrue(dateComp.compare(f3, f2) < 0);
        assertEquals(0, dateComp.compare(f2, f2));
    }
}
