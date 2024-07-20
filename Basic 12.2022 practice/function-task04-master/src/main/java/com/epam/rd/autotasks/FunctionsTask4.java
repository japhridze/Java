package com.epam.rd.autotasks;

public class FunctionsTask4 {

    public static int sumGeometricElements(int a1, double t, int alim) {
        if(t <= 0 || t >= 1 || a1 <= alim || alim < 0)
        {
            throw new IllegalArgumentException();
        }
        double sum = 0;
        double an = a1;
        while (an > alim) {
            sum += an;
            an *= t;
            if (an <= 0.01) break;
        }

        return (int) Math.ceil(sum);
    }



}
