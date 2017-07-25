package CodewarsSolvesOne;

/**
 * Created by Helga on 7/13/2017.
 */
public class SolvesOne {


    public static void main(String[] args) {
        System.out.println(getDivisorsCnt(1));
        System.out.println(getDivisorsCnt(10));
        System.out.println(getDivisorsCnt(11));
        System.out.println(getDivisorsCnt(54));
        /***************************/
        System.out.println(findNb(1071225));
        System.out.println(findNb(107122554));
    }
public static String printerError(String s) {
        String Result="";
         int numerator=0;
        for(int i=0;i<s.length();i++)
        {
            int a=s.charAt(i);
            System.out.println(a);
            if(a<97||a>109)
            {
                numerator++;
            }
        }
        Result+=Integer.toString(numerator);
        Result+="/";
        Result+=Integer.toString(s.length());


 return Result;
    }
    public static int getDivisorsCnt(int n) /* Calculates the amount of divisors of a number*/ {

        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                count++;
            }
        }
        return count;
    }

/*
Your task is to construct a building which will be a pile of n cubes.
 The cube at the bottom will have a volume of n^3, the cube above will have
 volume of (n-1)^3 and so on until the top which will have a volume of 1^3.

You are given the total volume m of the building. Being given m can you find
 the number n of cubes you will have to build?

The parameter of the function findNb (find_nb, find-nb, findNb) will be an integer m
 and you have to return the integer n such as n^3 + (n-1)^3 + ... + 1^3 = m if such
  a n exists or -1 if there is no such n.

Examples:

findNb(1071225) --> 45
findNb(91716553919377) --> -1
 */

    /*I am a mathematician so that i'd rather use a formula 1^3+ +n^3=(n*(n+1)/2)^2*/
    public static long findNb(long m) {

        long n = -1;

        for (int i = 0; Math.pow((i * (i + 1) / 2), 2) <= m; i++) {
            if (Math.pow((i * (i + 1) / 2), 2) == m) {
                n = i;
                break;
            }

        }

        return n;
    }
}