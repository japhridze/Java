package com.epam.rd.autotasks;

public class Sorting {
    public void sort(int[] array) {
        if (array == null) {
            throw new IllegalArgumentException();
        }


        boolean swapped;
        int n = array.length;
        do {
            swapped = false;
            for (int i = 1; i < n; i++) {
                if (array[i - 1] > array[i]) {

                    int temp = array[i - 1];
                    array[i - 1] = array[i];
                    array[i] = temp;
                    swapped = true;
                }
            }
            n--;
        } while (swapped);
    }
}
