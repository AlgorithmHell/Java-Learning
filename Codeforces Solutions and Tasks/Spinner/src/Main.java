/**
 * Created by Helga on 7/31/2017.
 */
// v - 118, < - 60, ^ - 94, > - 62
import java.util.*;
public class Main {
    public static void main(String... args)
    {
        Scanner input=new Scanner(System.in);
        String buf=input.nextLine();
        int begginingPosition=(int)buf.charAt(0);
        int finalPosition=(int)buf.charAt(2);
        int seconds=input.nextInt();
        int begin=0;int end=0;
         int[] positions=new int[5];
         positions[0]=0;
         positions[1]=118;
         positions[2]=60;
         positions[3]=94;
         positions[4]=62;
         boolean beginDone=false,endDone=false;
         for(int i=1;i<=4;i++)
         {
             if(begginingPosition==positions[i])
             {
                 begin=i;
                 beginDone=true;
             }
             if(finalPosition==positions[i])
             {
                 end=i;
                 endDone=true;
             }
             if(beginDone&&endDone)
             {
                 break;
             }
         }
         int connection=seconds%4;
         if(connection==2||connection==0)
         {
             System.out.println("undefined");
             return;
         }
         int difference=(end-begin);
         if(difference<0)
         {
             difference=4+difference;
         }


         if (difference==connection)
         {
             System.out.println("cw");
         }
         else
         {
             System.out.println("ccw");
         }
        //System.out.println(begginingPosition+" "+finalPosition+" "+seconds+" "+connection+" "+end+" "+begin+" "+difference);

    }
}
