/**
 * Created by Helga on 8/3/2017.
Task 798B Task 798B Task 798B Task 798B Task 798B Task 798B
 */
import java.util.*;
public class Main {
    public static void main(String... args)
    {
        Scanner input=new Scanner(System.in);
        int n=input.nextInt();
        String[] Data=new String[n];
        String buffer=input.nextLine();
        for(int i=0;i<n;i++) {


                Data[i] = input.nextLine();


        }

        int[] counters=new int[n];
        for(int i=0;i<n;i++)
        {
            counters[i]=0;
        }
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(i!=j)
                {
                    int checker=Step(Data[j],Data[i]);
                  //  System.out.println("checker"+i+" "+j+" "+checker);
                    if (checker!=-1)
                    {
                        counters[i]+=checker;
                    }

                    else
                    {
                        System.out.println(-1);
                        return ;
                    }
                }
            }
          //  System.out.println(counters[i]+" count : "+i);
        }
        int min=counters[0];
        for(int i=1;i<n;i++)
        {
            if(min>counters[i])
            {
                min=counters[i];
            }
        }
        System.out.println(min);

    }
    public static int Step( String ToBeMoved, String toCompare)
    {
        char[] moves=ToBeMoved.toCharArray();
        char[] compare=toCompare.toCharArray();

        int a=0;
        for(;a<toCompare.length();a++)
        {
            if(moves[a]!=compare[a])
                break;
        }
        if (a==toCompare.length())
        {
         return 0;

        }
            char[] buf=ToBeMoved.toCharArray();
        String Buf=ToBeMoved;
        char[] comp=toCompare.toCharArray();


        int iterations=1;
        for(;iterations<=ToBeMoved.length()+1;iterations++)
        {
            char buf0 = buf[0];
            for (int k = 1; k < buf.length; k++)
            {
                buf[k-1] = buf[k];
            }
            buf[buf.length -1] = buf0;

            int t=0;
            for(;t<ToBeMoved.length();t++)
            {
                if(buf[t]!=comp[t])
                    break;
            }
            if(t==ToBeMoved.length())
            {
                break;
            }

        }


        if(iterations>ToBeMoved.length()+1)
        {
            return -1;
        }

        return iterations;
    }
}
