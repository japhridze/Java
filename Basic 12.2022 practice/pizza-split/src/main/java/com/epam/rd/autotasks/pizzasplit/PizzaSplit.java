package com.epam.rd.autotasks.pizzasplit;
import java.util.Scanner;
public class PizzaSplit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int numberOfPeople = scanner.nextInt();
        int piecesPerPizza = scanner.nextInt();


        int minimumPizzas = (int) Math.ceil((double) numberOfPeople / piecesPerPizza);



        if (minimumPizzas == 0) {
            minimumPizzas = 1;
        }


        System.out.println(minimumPizzas);


        scanner.close();
    }
}
