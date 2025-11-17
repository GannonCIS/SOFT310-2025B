package org.example.mp3manager;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Mp3FileDateDataFlowTest {

    // DF-4: setYear -> getYear (переменная year)
    @Test
    void setYearThenGetYearUsesStoredValue() {
        Mp3File file = new Mp3File("dummy"); // файл может не существовать, нам всё равно
        file.setYear(2005);                  // define year

        // use year
        assertEquals(2005, file.getYear());
    }

    // DF-5: year двух объектов используется в DateComparator.compare
    @Test
    void dateComparatorUsesYearOfBothFiles() {
        Mp3File older = new Mp3File("dummy1");
        older.setYear(1990);

        Mp3File newer = new Mp3File("dummy2");
        newer.setYear(2000);

        DateComparator comp = new DateComparator();

        // use older.year и newer.year
        assertTrue(comp.compare(older, newer) < 0);
        assertTrue(comp.compare(newer, older) > 0);
        assertEquals(0, comp.compare(older, older));
    }
}