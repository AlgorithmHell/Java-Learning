package Main; /**
 * Created by Helga on 7/16/2017.
 */
import java.util.Scanner;
import static StandartAlgos.Sort.BubbleSort;
import static StandartAlgos.Sort.InsertionSort;
import static StandartAlgos.Sort.SelectionSort;

public class Main {
    public static void main(String[] args)
    {
        int arr[]=new int[10];
        arr[0]=6;arr[1]=7;arr[2]=8;arr[3]=1;arr[4]=2;arr[5]=3;arr[6]=0;
        arr[7]=5;arr[8]=4;arr[9]=34;

        int iterations=0;
        for(int i=0; i<10;i++)
        {
            System.out.print(arr[i]+" ");
        }
        System.out.println("");
///Use of Sort

        iterations=InsertionSort(arr);



        System.out.println("Iterations : "+iterations);
        for(int i=0; i<10;i++)
        {
            System.out.print(arr[i]+" ");
        }

    }

}
