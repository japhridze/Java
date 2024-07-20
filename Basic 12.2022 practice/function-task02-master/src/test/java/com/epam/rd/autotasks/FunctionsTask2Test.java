package com.epam.rd.autotasks;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FunctionsTask2Test {

    @Test
    public void getArrayIsSortedByAscEndExpectedResult() {

        assertArrayEquals(new int[]{1, 3, 5, 7, 9}, FunctionsTask2.transform(new int[]{1, 2, 3, 4, 5}, SortOrder.ASC));
        assertArrayEquals(new int[]{1, 11, 14, 21, 1004}, FunctionsTask2.transform(new int[]{1, 10, 12, 18, 1000}, SortOrder.ASC));
        assertArrayEquals(new int[]{1001, 1003, 1005, 1007, 1009}, FunctionsTask2.transform(new int[]{1001, 1002, 1003, 1004, 1005}, SortOrder.ASC));
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, FunctionsTask2.transform(new int[]{1, 1, 1, 1, 1}, SortOrder.ASC));
        assertArrayEquals(new int[]{-5, -3, -1, 1, 3}, FunctionsTask2.transform(new int[]{-5, -4, -3, -2, -1}, SortOrder.ASC));
        assertArrayEquals(new int[]{-1003, -1001, -999, -997, -995}, FunctionsTask2.transform(new int[]{-1003, -1002, -1001, -1000, -999}, SortOrder.ASC));
        assertArrayEquals(new int[]{-3, -1, 1, 3, 5}, FunctionsTask2.transform(new int[]{-3, -2, -1, 0, 1}, SortOrder.ASC));

    }

    @Test
    public void getArrayIsSortedByDescEndExpectedResult() {

        assertArrayEquals(new int[]{5, 5, 5, 5, 5}, FunctionsTask2.transform(new int[]{5, 4, 3, 2, 1}, SortOrder.DESC));
        assertArrayEquals(new int[]{20, 19, 2, -17, -996}, FunctionsTask2.transform(new int[]{20, 18, 0, -20, -1000}, SortOrder.DESC));
        assertArrayEquals(new int[]{1005, 1005, 1005, 1005, 1005}, FunctionsTask2.transform(new int[]{1005, 1004, 1003, 1002, 1001}, SortOrder.DESC));
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, FunctionsTask2.transform(new int[]{1, 1, 1, 1, 1}, SortOrder.DESC));
        assertArrayEquals(new int[]{-1, -1, -1, -1, -1}, FunctionsTask2.transform(new int[]{-1, -2, -3, -4, -5}, SortOrder.DESC));
        assertArrayEquals(new int[]{-999, -999, -999, -999, -999}, FunctionsTask2.transform(new int[]{-999, -1000, -1001, -1002, -1003}, SortOrder.DESC));
        assertArrayEquals(new int[]{1, 1, 1, 1, 1}, FunctionsTask2.transform(new int[]{1, 0, -1, -2, -3}, SortOrder.DESC));
        assertArrayEquals(new int[]{15, 11, 5}, FunctionsTask2.transform(new int[]{15, 10, 3}, SortOrder.DESC));

    }

}