package com.epam.rd.autotasks.arrays;



public class SumOfPrevious {

    public static void main(String[] args) {
        int[] inputarray = new int[]{1, -1, 0, 4, 6, 10, 15, 25};
        boolean[] result = getSumCheckArray(inputarray);

        for (boolean value: result) {
            System.out.println(value);

        }

    }

//    public static void main(String[] args) {
//        int[] array = new int[]{1, -1, 0, 4, 6, 10, 15, 25};
//
//      //  System.out.println(Arrays.toString(getSumCheckArray(array)));
//    }

    public static boolean[] getSumCheckArray(int[] array) {
        boolean[] sumsheck = new boolean[array.length];
        sumsheck[0] = false;
        sumsheck[1] = false;
        for (int i = 2; i < array.length; i++) {

            sumsheck[i] = (array[i] == array[i - 1] + array[i - 2]);

        }
        return sumsheck;
    }
}
