package com.epam.rd.autotasks;

import java.util.Arrays;
import java.util.Scanner;


import static com.epam.rd.autotasks.FunctionsTask3.multiArithmeticElements;


public class Main {

    private static final String MESSAGE_INPUT_ARRAY_SIZE = "Choose array size: \n n = ";
    private static final String MESSAGE_INPUT_ARRAY_ELEMENT = "array[%s] = ";
    private static final String MESSAGE_INPUT_SORT_ORDER = "\nSortOrder is ASCENDING => input figure \"1\", " +
            "\nSortOrder is DESCENDING => input figure \"2\"\n";
    private static final String MESSAGE_CONTINUE = "Continue? yes => input figure \"1\", " +
            "\n\tno => input any figure more then \"1\"";
    private static final String MESSAGE_ARRAY_IS_SORTED = "!!!RESULT!!! Array is sorted => %s \n\n";

    private static final Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        int[] array = getArray();      

        System.out.println("\n=>Task 3<=");
        System.out.println(multiArithmeticElements(1, 2, 1));

      
    }

    private static int[] getArray() {
        System.out.print(MESSAGE_INPUT_ARRAY_SIZE);
        int n = input.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.printf(MESSAGE_INPUT_ARRAY_ELEMENT, i);
            array[i] = input.nextInt();
        }
        return array;
    }

   

    private static boolean getContinue() {
        System.out.println(MESSAGE_CONTINUE);
        int answer = input.nextInt();
        return answer == 1;
    }
}