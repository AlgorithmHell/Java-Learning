
import java.util.Scanner;

/**
 * Created by Helga on 7/28/2017.
 */
public class Main {
    public static void main( String... args)
    {
        Scanner input=new Scanner(System.in);
        int n= input.nextInt();


        String s=input.next();
        System.out.println(s);
        System.out.println(BinaryProtocol(n,s));
    }
    public static int BinaryProtocol( int n, String s)
    {
        int result=0;

        char [] arr=s.toCharArray();
        int[] buf=new int[n];
        int index=0;
        int j=0;
        for (int i = 0; i<n; i++)
        {
            int counter = 0;
            for (j = i; j<n&&arr[j] != '0'; j++)
            {
                counter++;
            }
            i = ++j;
            buf[index] = counter;
            index++;

            boolean isZero = false;
            int k = j;
            for (; k<n&&arr[k] != '1'; k++)
            {
                buf[index] = 0;
                counter++;
                index++;
                isZero = true;
            }
            if (k == n)
            {
                buf[index++] = 0;
            }
            i = --k;
        }
        int divisor=1;
        for(int i=index-1;i>=0;i--)
        {
            result+=divisor*buf[i];
            divisor*=10;
        }
        return result;
    }
}
