package com.epam.rd.autotasks;

import java.util.Locale;
import java.util.Scanner;

import static java.lang.Math.sqrt;

public class QuadraticEquation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
        double a = scanner.nextDouble();
        double b = scanner.nextDouble();
        double c = scanner.nextDouble();
        double Dkr=(b*b -4*a*c ) ;
        double x1;
        double x2;
        double mn = 2*a;

        if (Dkr < 0){
            System.out.println("no roots");
        } else if (Dkr>0) {
            x1= (-b +Math.sqrt(Dkr)  ) / mn;
            x2=(-b - Math.sqrt(Dkr) ) / mn;
            System.out.println(x2);
            System.out.println(x1 );

        }else  {
            x1= -b / mn;
            System.out.println(x1);
        }


    }

}