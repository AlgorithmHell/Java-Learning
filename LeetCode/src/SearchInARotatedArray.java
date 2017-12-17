import com.sun.java.swing.plaf.windows.WindowsInternalFrameTitlePane;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by Helga on 11/27/2017.
 */
public class SearchInARotatedArray {

     public int searchRotated(int [] array, int start, int end, int value)  {
         return search(array, start, end, value);
     }
    private int search(int [] array, int start, int end,  int value) {
        // 5 6 7 8 0 1 2 3 4
        int mid = start + (end - start) / 2;
        if(array[mid] == value) {
            return mid;
        }
        // 0 + 8/2 = 4
        // 5 6 7 8 0(mid)    1 2 3 4
        // start 0, end 4, mid 2 : 5 6 7(mid)  8 0
        if (array[start] <= value && array[mid] < value || array[start] <= value && array[mid] > value) {
           return  search(array, start,mid - 1, value);
        } else {
            if(array[mid + 1] <= value && array[end] >= value || array[mid + 1] <= value && array[end] >= value) {
               return search(array, mid + 1 , end, value);
            }
        }

        return -1;
    }

}
