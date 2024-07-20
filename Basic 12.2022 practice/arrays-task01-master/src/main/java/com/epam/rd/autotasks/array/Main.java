package com.epam.rd.autotasks.array;

import java.util.Arrays;

public class Main {


    public static void main(String[] args){

        int[] array = new int[]{ 100, 2, 3, 4, 5 };

        IntArrayUtil.swapEven(array);

        System.out.println(Arrays.toString(array));


    }
}
