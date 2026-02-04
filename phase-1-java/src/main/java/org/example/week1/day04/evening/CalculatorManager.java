package org.example.week1.day04.evening;

public class CalculatorManager {

    public static void main(String[] args) {
        Calculator calc = new Calculator();
        System.out.println(calc.divide(1.0,1.0));
        System.out.println(calc.divide(1.0, 0.0));
    }
}
