package com.epam.rd.autotasks;



import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FunctionsTask1Test {

    @Test
    public void testArrayIsSortedByAsc() {
        assertTrue(FunctionsTask1.isSorted(new int[] {1, 2, 3, 4, 5}, SortOrder.ASC));
        assertTrue(FunctionsTask1.isSorted(new int[] {1, 10, 12, 18, 1000}, SortOrder.ASC));
        assertTrue(FunctionsTask1.isSorted(new int[] {1001, 1002, 1003, 1004, 1005}, SortOrder.ASC));
        assertTrue(FunctionsTask1.isSorted(new int[] {1, 1, 1, 1, 1}, SortOrder.ASC));
        assertTrue(FunctionsTask1.isSorted(new int[] {-5, -4, -3, -2, -1}, SortOrder.ASC));
        assertTrue(FunctionsTask1.isSorted(new int[] {-1003, -1002, -1001, -1000, -999}, SortOrder.ASC));
        assertTrue(FunctionsTask1.isSorted(new int[] {-3, -2, -1, 0, 1}, SortOrder.ASC));
    }

    @Test
    public void testArrayIsSortedByDesc() {
        assertTrue(FunctionsTask1.isSorted(new int[]{5, 4, 3, 2, 1}, SortOrder.DESC));
        assertTrue(FunctionsTask1.isSorted(new int[] {20, 18, 0, -20, -1000}, SortOrder.DESC));
        assertTrue(FunctionsTask1.isSorted(new int[] {1005, 1004, 1003, 1002, 1001}, SortOrder.DESC));
        assertTrue(FunctionsTask1.isSorted(new int[] {1, 1, 1, 1, 1}, SortOrder.DESC));
        assertTrue(FunctionsTask1.isSorted(new int[] {-1, -2, -3, -4, -5}, SortOrder.DESC));
        assertTrue(FunctionsTask1.isSorted(new int[] {-999, -1000, -1001, -1002, -1003}, SortOrder.DESC));
        assertTrue(FunctionsTask1.isSorted(new int[] {1, 0, -1, -2, -3}, SortOrder.DESC));
    }
    @Test
    public void testNegativeArrayIsSortedByAsc() {
        assertFalse(FunctionsTask1.isSorted(new int[] {5, 4, 3, 2, 1}, SortOrder.ASC));
        assertFalse(FunctionsTask1.isSorted(new int[] {5, 3, 4, 2, 1}, SortOrder.ASC));
        assertFalse(FunctionsTask1.isSorted(new int[] {20, 18, 0, -20, -1000}, SortOrder.ASC));
        assertFalse(FunctionsTask1.isSorted(new int[] {1005, 1004, 1003, 1002, 1001}, SortOrder.ASC));
        assertFalse(FunctionsTask1.isSorted(new int[] {1005, 1004, 1003, 1001, 1002}, SortOrder.ASC));
        assertFalse(FunctionsTask1.isSorted(new int[] {-1, -2, -3, -4, -5}, SortOrder.ASC));
        assertFalse(FunctionsTask1.isSorted(new int[] {-1, -3, -4, -6, -5}, SortOrder.ASC));
        assertFalse(FunctionsTask1.isSorted(new int[] {-999, -1000, -1001, -1002, -1003}, SortOrder.ASC));
        assertFalse(FunctionsTask1.isSorted(new int[] {-999, -1001, -1000, -1002, -1003}, SortOrder.ASC));
        assertFalse(FunctionsTask1.isSorted(new int[] {1, 0, -1, -2, -3}, SortOrder.ASC));
        assertFalse(FunctionsTask1.isSorted(new int[] {5, 17, 24, 88, 33, 2}, SortOrder.ASC));
        assertFalse(FunctionsTask1.isSorted(new int[] {15, 10, 3}, SortOrder.ASC));
    }

    @Test
    public void testNegativeArrayIsSortedByDesc() {
        assertFalse(FunctionsTask1.isSorted(new int[] {1, 2, 3, 4, 5}, SortOrder.DESC));
        assertFalse(FunctionsTask1.isSorted(new int[] {1, 2, 4, 3, 5}, SortOrder.DESC));
        assertFalse(FunctionsTask1.isSorted(new int[] {1, 10, 12, 18, 1000}, SortOrder.DESC));
        assertFalse(FunctionsTask1.isSorted(new int[] {1001, 1002, 1003, 1004, 1005}, SortOrder.DESC));
        assertFalse(FunctionsTask1.isSorted(new int[] {1001, 1005, 1003, 1005, 1005}, SortOrder.DESC));
        assertFalse(FunctionsTask1.isSorted(new int[] {-5, -4, -3, -2, -1}, SortOrder.DESC));
        assertFalse(FunctionsTask1.isSorted(new int[] {-5, -4, -2, -3, -1}, SortOrder.DESC));
        assertFalse(FunctionsTask1.isSorted(new int[] {-1003, -1002, -1001, -1000, -999}, SortOrder.DESC));
        assertFalse(FunctionsTask1.isSorted(new int[] {-1003, -1002, -1000, -1001, -999}, SortOrder.DESC));
        assertFalse(FunctionsTask1.isSorted(new int[] {-3, -2, -1, 0, 1}, SortOrder.DESC));
        assertFalse(FunctionsTask1.isSorted(new int[] {5, 17, 24, 88, 33, 2}, SortOrder.DESC));
    }
    @Test()
    public void arrayIsSortedWithIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> {
            FunctionsTask1.isSorted(new int[] {}, SortOrder.ASC);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            FunctionsTask1.isSorted(new int[] {}, SortOrder.DESC);
        });
    }
    @Test()
    public void testArrayIsSortedWithNullArgs() {
        assertThrows(IllegalArgumentException.class, () -> {
            FunctionsTask1.isSorted(null, null);
        });


    }

}
