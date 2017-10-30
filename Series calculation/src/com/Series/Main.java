package com.Series;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;
import java.io.*;

public class Main {


    public static void main(String... args) {
        double x;
        double epsilon;
        try {

            if (args.length != 2)
            {
                throw new MyException("Arguments mismatch " + args.length);
            }
            x = Double.parseDouble(args[0]);
            epsilon = Double.parseDouble(args[1]);
            System.out.println(x + " " + epsilon);
            FunctionalSeries functionalSeries = new FunctionalSeries(x, epsilon);
            System.out.println(functionalSeries.sum().toString());
        } catch (NumberFormatException e) {
            System.out.println("Input Mismatch: " + e.getMessage());
        } catch (MyException e) {
            System.out.println(e.getMessage());
        }


    }


}

