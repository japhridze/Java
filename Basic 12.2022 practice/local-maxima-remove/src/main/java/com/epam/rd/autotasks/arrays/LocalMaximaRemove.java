package com.epam.rd.autotasks.arrays;

import java.util.Arrays;

public class LocalMaximaRemove {
    public static int[] removeLocalMaxima(int[] arr){
        if(arr.length <= 2)
            return arr;

        int counter = 0;
        for(int i = 1; i < arr.length; i++) {
            if (arr[i - 1] > arr[i]){
                if (i - 1 == 0 || arr[i - 1] > arr[i - 2])
                    counter++;
            }
            else if(i + 1 == arr.length && arr[i - 1] < arr[i])
                counter++;
        }

        if(counter == 0)
            return arr;

        int[] non_local_arr = new int[arr.length - counter];
        for(int i = 1, j = 0; i < arr.length; i++) {
            if (i - 1 != 0 && arr[i - 1] <= arr[i - 2] || arr[i-1] <= arr[i]) {
                non_local_arr[j] = arr[i-1];
                j++;
            } else if(i + 1 == arr.length && arr[i] < arr[i-1])
                non_local_arr[j] = arr[i];
        }
        return non_local_arr;
    }


    public static void main(String[] args) {
        int[] arr = new int[]{3, 2, 4, 3, 3, 6};
        arr = removeLocalMaxima(arr);
        for(int i = 0; i < arr.length; i++){
          continue;
        }
        System.out.println(Arrays.toString(arr));
    }

}
