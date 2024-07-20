package com.epam.rd.autotasks.arrays;

public class SumOfEvenNumbers  {

    public static void main(String[] args){
        int[] vals = new int[]{-2,10,0,5};
        int result = SumOfEvenNumbers.sum(vals);
        System.out.println(result == 8);
    }
    public static int sum(int[] values) {
        int[] vals = new int[]{-2,10,0,5};
        if (values==null || values.length ==0){
            return 0;
        }
        int shemnaxavi = 0;
        for (int i = 0; i <vals.length; i++) {
            if (vals[i] % 2 ==0){
                shemnaxavi +=vals[i];
            }
        }
        return shemnaxavi;
    }
}


