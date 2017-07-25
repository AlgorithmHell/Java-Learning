package StandartAlgos;

/**
 * Created by Helga on 7/16/2017.
 */
public class Sort {
    public static int BubbleSort(int[] arr)
    {
        int iterations=0;
        boolean isSwapped=true;
        while(isSwapped)
        {
            isSwapped=false;
            for(int i=0;i<arr.length;i++)
            {
                for(int j=arr.length-1;j!=i;j--)
                {
                    if(arr[j-1]>arr[j])
                    {
                        int buf=arr[j-1];
                        arr[j-1]=arr[j];
                        arr[j]=buf;
                        isSwapped=true;
                        iterations++;
                    }
                }
            }
        }
        return iterations;
    }
    public static int SelectSort(int[] arr)
    {
        int iterations=0;
        for(int i=0;i<arr.length-1;i++)
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
                iterations++;
            }
            arr[smallestIndex]=arr[i];
            arr[i]=smallestElement;
        }
        return iterations;
    }
    public static int InsertSort(int[] arr)
    {
        int iterations=0;
        for(int i=1;i<arr.length;i++)
        {
            int x=arr[i];
            int j;
            for( j=i-1;j>=0&&arr[j]>x;j--)
            {
                arr[j+1]=arr[j];
                iterations++;
            }
            arr[j+1]=x;
        }
        return iterations;

    }
}
