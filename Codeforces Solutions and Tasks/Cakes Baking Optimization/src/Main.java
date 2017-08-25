/**
 * Created by Helga on 7/30/2017.
 */
import  java.util.*;
public class Main {
    public static void main(String... args)
    {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        int t=in.nextInt();
        int k=in.nextInt();
        int d=in.nextInt();
        int cakesToBeBaked = n;
        int bakingTime = t;
        int cakesPerBakingTime = k;
        int buildingTime = d;
        int result = 0;
        int optimizedResult = 0;
        int BakedCakes = 0;
        while (BakedCakes<cakesToBeBaked)
        {
            result += bakingTime;
            BakedCakes += cakesPerBakingTime;
        }
        BakedCakes = 0;
        int i = 1;
        int a = 0;
        for (; BakedCakes<cakesToBeBaked; i++)
        {
            if (i%bakingTime == 0)
            {

                BakedCakes += cakesPerBakingTime;
            }
            if (i > buildingTime)
            {
                a++;
                if (a%bakingTime == 0)
                {

                    BakedCakes += cakesPerBakingTime;
                }
            }
        }
        optimizedResult = --i;
        System.out.println(result+" "+optimizedResult);
        System.out.println(result>optimizedResult?"YES":"NO");
    }
}
