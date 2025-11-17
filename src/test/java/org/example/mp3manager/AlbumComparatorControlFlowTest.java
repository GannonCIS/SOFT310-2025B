package org.example.mp3manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AlbumComparatorControlFlowTest {

    private AlbumComparator comparator;
    private Mp3File mp3_A;
    private Mp3File mp3_B;

    @BeforeEach
    void setUp() {
        comparator = new AlbumComparator();
        mp3_A = new Mp3File("dummy_path_A.mp3");
        mp3_B = new Mp3File("dummy_path_B.mp3");
    }

    @Test
    void testCompareNormalStrings() {
        mp3_A.setAlbum("Abbey Road");
        mp3_B.setAlbum("Blonde on Blonde");
        assertTrue(comparator.compare(mp3_A, mp3_B) < 0);
        assertTrue(comparator.compare(mp3_B, mp3_A) > 0);
    }

    @Test
    void testCompareEqualStrings() {
        mp3_A.setAlbum("Currents");
        mp3_B.setAlbum("Currents");
        assertEquals(0, comparator.compare(mp3_A, mp3_B));
    }

    @Test
    void testNullAndEmptyBecomeUnknown() {
        mp3_A.setAlbum(null);
        mp3_B.setAlbum("");

        assertEquals(0, comparator.compare(mp3_A, mp3_B));

        mp3_A.setAlbum("Actual Album");
        mp3_B.setAlbum(null); // "Unknown"

        assertTrue(comparator.compare(mp3_A, mp3_B) < 0);
    }

    @Test
    void testExplicitUnknown() {
        mp3_A.setAlbum("Unknown");
        mp3_B.setAlbum(null);
        assertEquals(0, comparator.compare(mp3_A, mp3_B));
    }

    @Test
    void testCaseDifferences() {
        mp3_A.setAlbum("album");
        mp3_B.setAlbum("ALBUM");
        assertTrue(comparator.compare(mp3_A, mp3_B) > 0);
    }
}