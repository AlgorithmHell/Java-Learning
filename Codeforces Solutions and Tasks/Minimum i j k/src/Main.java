/**
 * Created by Helga on 8/1/2017.
 */
import java.math.BigInteger;
import java.util.*;
public class Main {
    public static void main(String... args)
    {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++)
        {
            arr[i]=in.nextInt();
        }
        //Sort three first
        for(int i=0;i<3;i++)
        {
            int smallestIndex=i;
            int smallestElement=arr[i];
            for(int j=i+1;j<arr.length;j++)
            {
                if(smallestElement>arr[j])
                {
                    smallestIndex=j;
                    smallestElement=arr[j];
                }

            }
            arr[smallestIndex]=arr[i];
            arr[i]=smallestElement;
        }
       //System.out.println(arr[0]+" "+arr[1]+" "+arr[2]);
        if(arr[0]==arr[1]&&arr[1]==arr[2]&&arr[2]==arr[0])
        {
            int N=n;
            for(int i=3;i<n;i++)
            {
                if(arr[0]!=arr[i])
                {
                    N--;
                }
            }
            BigInteger howManyChoices=  BigInteger.valueOf(N);
           howManyChoices= howManyChoices.multiply(BigInteger.valueOf(N-1));
            howManyChoices= howManyChoices.multiply(BigInteger.valueOf(N-2));
            howManyChoices=howManyChoices.divide(BigInteger.valueOf(6));

            System.out.println(howManyChoices.toString());
            return;
        }
        if(arr[0]==arr[1]||arr[1]==arr[2]||arr[2]==arr[0])
        {
            BigInteger howManyChoices=  BigInteger.valueOf(1);
            int equlaElCholices=n-1;
            int nonEqualElChoices=1;
            if(arr[0]==arr[1])
            {
              for(int i=3;i<n;i++)
              {
                  if(arr[0]!=arr[i])
                  {
                      equlaElCholices--;
                  }
                  if(arr[2]==arr[i])
                  {
                      nonEqualElChoices++;
                  }
              }


                howManyChoices=howManyChoices.multiply(BigInteger.valueOf(equlaElCholices));

                howManyChoices=howManyChoices.multiply(BigInteger.valueOf(equlaElCholices-1));
                howManyChoices=howManyChoices.divide(BigInteger.valueOf(2));

                howManyChoices=howManyChoices.multiply(BigInteger.valueOf(nonEqualElChoices));


                System.out.println(howManyChoices.toString());
                return;
            }
            if(arr[1]==arr[2])
            {
                for(int i=3;i<n;i++)
                {
                    if(arr[1]!=arr[i])
                    {
                        equlaElCholices--;
                    }
                    if(arr[0]==arr[i])
                    {
                        nonEqualElChoices++;
                    }
                }
                howManyChoices=howManyChoices.multiply(BigInteger.valueOf(equlaElCholices));

                howManyChoices=howManyChoices.multiply(BigInteger.valueOf(equlaElCholices-1));
                howManyChoices=howManyChoices.divide(BigInteger.valueOf(2));
                howManyChoices=howManyChoices.multiply(BigInteger.valueOf(nonEqualElChoices));


                System.out.println(howManyChoices.toString());
                return;
            }
            if(arr[2]==arr[0])
            {

                for(int i=3;i<n;i++)
                {
                    if(arr[0]!=arr[i])
                    {
                        equlaElCholices--;

                    }
                    if(arr[1]==arr[i])
                    {
                        nonEqualElChoices++;
                    }
                }
                howManyChoices=howManyChoices.multiply(BigInteger.valueOf(equlaElCholices));

                howManyChoices=howManyChoices.multiply(BigInteger.valueOf(equlaElCholices-1));
                howManyChoices=howManyChoices.divide(BigInteger.valueOf(2));
                howManyChoices=howManyChoices.multiply(BigInteger.valueOf(nonEqualElChoices));


                System.out.println(howManyChoices.toString());
                return;
            }
            return;
        }
        else
        {
            BigInteger howManyChoices=  BigInteger.valueOf(1);
            int Choices1=n-2, Choices2=n-2,Choices3=n-2;
            for(int i=3;i<n;i++)
            {
                if(arr[i]!=arr[0])
                {
                    Choices1--;

                }
                if(arr[i]!=arr[1])
                {
                    Choices2--;

                }
                if(arr[i]!=arr[2])
                {
                    Choices3--;

                }
            }


            BigInteger One= BigInteger.valueOf(Choices1);
            BigInteger Two= BigInteger.valueOf(Choices2);
            BigInteger Three= BigInteger.valueOf(Choices3);

            howManyChoices=howManyChoices.multiply(One);
            howManyChoices=howManyChoices.multiply(Two);
            howManyChoices=howManyChoices.multiply(Three);
            System.out.println(howManyChoices);
            return;
        }

    }
}
