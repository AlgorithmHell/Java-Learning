/**
 * Created by Helga on 7/29/2017.
 */
import java.util.*;
public class Main {
    public static void main( String... args)
    {
        Scanner input=new Scanner(System.in);
        int n=input.nextInt();
        int[] arr=new int[n];
        for (int i=0;i<arr.length;i++ )
        {
        arr[i] =input.nextInt();

        }
        int i=0;

        for(;i<arr.length-1;i++)
        {

            if(arr[i]>=arr[i+1])
            {
                break;
            }
        }



        for(;i<arr.length-1;i++)
        {

            if (arr[i] != arr[i + 1])
            {
                break;
            }
        }

                for(;i<arr.length-1;i++)
                {

                    if(arr[i]<=arr[i+1])
                    {
                        break;
                    }
                }

            if(i==arr.length-1)
            {
                System.out.println("YES");
                return;
            }
            else
            {
                System.out.println("NO");
                return;
            }

    }
}
