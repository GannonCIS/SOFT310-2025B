package org.example.mp3manager;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SimpleArrayListDataFlowTest {

    // DF-1: add -> size/get (переменная count)
    @Test
    void addUpdatesCountAndGetUsesIt() {
        SimpleArrayList<Integer> list = new SimpleArrayList<>();

        list.add(10);  // count = 1
        list.add(20);  // count = 2

        // use count в size()
        assertEquals(2, list.size());

        // use count внутри get при проверке индекса
        assertEquals(Integer.valueOf(10), list.get(0));
        assertEquals(Integer.valueOf(20), list.get(1));
    }

    // DF-2: remove -> size/get (переменная count и массив list[])
    @Test
    void removeShiftsElementsAndUpdatesCount() {
        SimpleArrayList<Integer> list = new SimpleArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);  // [1, 2, 3], count = 3

        Integer removed = list.remove(1); // удаляем элемент "2"

        assertEquals(Integer.valueOf(2), removed);

        // count уменьшился
        assertEquals(2, list.size());

        // массив сдвинулся
        assertEquals(Integer.valueOf(1), list.get(0));
        assertEquals(Integer.valueOf(3), list.get(1));
    }

    // DF-3: indexOf (переменные i и e)
    @Test
    void indexOfUsesLoopIndexAndElement() {
        SimpleArrayList<String> list = new SimpleArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");

        int idxB = list.indexOf("B"); // e = "B"
        int idxX = list.indexOf("X"); // e = "X"

        // i используется в сравнении и в возвращаемом значении
        assertEquals(1, idxB);
        assertEquals(-1, idxX);
    }
}