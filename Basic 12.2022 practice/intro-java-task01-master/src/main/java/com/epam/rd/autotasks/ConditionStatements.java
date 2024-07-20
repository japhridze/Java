package com.epam.rd.autotasks;

 import java.rmi.UnexpectedException;

class ConditionStatements {
    public static int task1(int n) {
        if (n>0){
            return n*n;
        }else if (n<0){
            return Math.abs(n);
        }else{
            return 0;
        }

    }


}
