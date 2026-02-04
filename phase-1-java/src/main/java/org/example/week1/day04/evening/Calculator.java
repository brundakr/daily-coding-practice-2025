package org.example.week1.day04.evening;

public class Calculator {

    public double divide(Double a, Double b) throws NumberFormatException {
        try {
            if(b == 0) {
               throw new NumberFormatException("Division by zero");
            }
            double res = a / b;
            return res;
        } catch (NumberFormatException e) {
            return Double.NaN;
        }
    }

}
