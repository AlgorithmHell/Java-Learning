import com.sun.org.apache.regexp.internal.RE;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by Helga on 11/21/2017.
 */
public class Main {
    public static void main(String[] args) {
     try {
         SumOfLists sumOfLists = new SumOfLists("Data.txt",3);
         sumOfLists.sumOfLists();
         LengthOfLongestSubstring lengthOfLongestSubstring = new LengthOfLongestSubstring();
         System.out.println(lengthOfLongestSubstring.lengthOfLongestSubstring(""));
         ReverseInteger reverseInteger = new ReverseInteger();
         System.out.println(reverseInteger.reverse(123));

         IfAPowerOfTwo ifAPowerOfTwo = new IfAPowerOfTwo();
         System.out.println(ifAPowerOfTwo.isAPowerOfTwo(256));
         System.out.println(ifAPowerOfTwo.isAPowerOfTwoConstantTime(256));
         DivideWithoutDividing divideWithoutDividing = new DivideWithoutDividing();
         System.out.println(divideWithoutDividing.divide(-2147483648 ,-1));
         System.out.println(Integer.MIN_VALUE);
         int[] array = new int[9];
         Scanner in = new Scanner(new File("Rotated.txt"));
         int i =0;
         while(in.hasNextInt()){
             array[i++] = in.nextInt();
         }
         SearchInARotatedArray searchInARotatedArray = new SearchInARotatedArray();
         System.out.println("Search : "+searchInARotatedArray.searchRotated(array, 0, array.length - 1, 2));

     } catch (FileNotFoundException e ){
         System.out.println("File not found");
     }

    }
}
