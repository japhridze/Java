package com.epam.rd.autotasks;


class LoopStatements {
    public static int sumOfFibonacciNumbers(int n) {

        int prev = 0;
        int curr =1;
        int sum = 1;

        if (n==1){
            return prev;
        }else if (n==2){
            return curr;
        }else if (n==0){
            return prev;
        }
        for (int i = 3; i <= n; i++) {
            int next = prev+curr;
            sum+=next;

            prev=curr;
            curr=next;
        }
        return sum ;

    }


}
