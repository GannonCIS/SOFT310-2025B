package org.example.mp3manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AuthorComparatorEquivalenceTest {

    private AuthorComparator comparator;
    private Mp3File mp3_A;
    private Mp3File mp3_B;

    @BeforeEach
    void setUp() {
        comparator = new AuthorComparator();
        mp3_A = new Mp3File("dummy_path_A.mp3");
        mp3_B = new Mp3File("dummy_path_B.mp3");
    }

    @Test
    void testCompareNormalStrings() {
        mp3_A.setAuthor("Led Zeppelin");
        mp3_B.setAuthor("Pink Floyd");

        // "Led Zeppelin" comes before "Pink Floyd"
        assertTrue(comparator.compare(mp3_A, mp3_B) < 0);
        assertTrue(comparator.compare(mp3_B, mp3_A) > 0);
    }

    @Test
    void testCompareEqualStrings() {
        mp3_A.setAuthor("Tame Impala");
        mp3_B.setAuthor("Tame Impala");
        assertEquals(0, comparator.compare(mp3_A, mp3_B));
    }

    @Test
    void testNullAndEmptyBecomeUnknown() {
        mp3_A.setAuthor(null);
        mp3_B.setAuthor(""); // Empty string

        // Both become "Unknown", so they are equal
        assertEquals(0, comparator.compare(mp3_A, mp3_B));

        mp3_A.setAuthor("Radiohead");
        mp3_B.setAuthor(null); // "Unknown"

        // "Radiohead" comes before "Unknown"
        assertTrue(comparator.compare(mp3_A, mp3_B) < 0);
    }

    @Test
    void testExplicitUnknown() {
        mp3_A.setAuthor("Unknown");
        mp3_B.setAuthor(null); // getAuthor() returns "Unknown"
        assertEquals(0, comparator.compare(mp3_A, mp3_B));
    }

    @Test
    void testCaseDifferences() {
        mp3_A.setAuthor("author"); // lowercase
        mp3_B.setAuthor("AUTHOR"); // uppercase

        // "author" comes after "AUTHOR" in ASCII
        assertTrue(comparator.compare(mp3_A, mp3_B) > 0);
    }
}