package com.epam.rd.autotasks;

import java.util.Arrays;

public class CycleSwap {
    public static void main(String[] args) {
        {

            int[] array = new int[]{1, 3, 2, 7, 4};
            CycleSwap.cycleSwap(array);
            System.out.println(Arrays.toString(array));
        }
        {
            int[] array = new int[]{ 1, 3, 2, 7, 4 };
            CycleSwap.cycleSwap(array, 2);
            System.out.println(Arrays.toString(array));
        }
        {
            int[] array = new int[]{ 1, 3, 2, 7, 4 };
            CycleSwap.cycleSwap(array, 5);
            System.out.println(Arrays.toString(array));
        }

    }
    static void cycleSwap(int[] array){
        if (array.length <= 1) {
            return;
        }

        int temp = array[array.length - 1];

        for (int i = array.length - 1; i > 0; i--) {
            array[i] = array[i - 1];
        }

        array[0] = temp;
    }


    static void cycleSwap(int[] array, int shift) {
        int length = array.length;


        shift = shift % length;

        if (shift < 0) {
            shift = length + shift;
        }

        if (length <= 1 || shift == 0) {
            return;
        }

        int[] tempArray = new int[length];

        for (int i = 0; i < length; i++) {
            tempArray[(i + shift) % length] = array[i];
        }


        System.arraycopy(tempArray, 0, array, 0, length);
    }



}
