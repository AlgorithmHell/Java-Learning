package com.Series;

import java.math.BigDecimal;
import java.math.RoundingMode;

class FunctionalSeries {
    private BigDecimal sum;
    private double x;
    private double epsilon;
    private int iterations;

    public FunctionalSeries(double x, double epsilon) {
        this.x = x;
        this.epsilon = epsilon;
        sum = new BigDecimal(0);
        iterations = 0;

    }



    public BigDecimal sum() {

        int k = 1;
        BigDecimal fact= BigDecimal.valueOf(1);
        BigDecimal numerator=BigDecimal.valueOf(1);
        while (numerator.abs().compareTo(BigDecimal.valueOf(epsilon)) > 0)  {
            fact= fact.multiply(BigDecimal.valueOf(k+1));
            numerator = BigDecimal.valueOf(x + Math.pow(k, -0.5));
            numerator = numerator.divide(fact, 20, RoundingMode.HALF_UP);
            sum = sum.add(numerator);
            iterations++;
            k++;
            System.out.println(iterations);

        }

        return sum;

    }
}

