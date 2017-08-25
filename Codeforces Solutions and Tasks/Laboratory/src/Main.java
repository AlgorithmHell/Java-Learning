/**
 * Created by Helga on 7/31/2017.
 */
import java.util.Scanner;
public class Main {
    public static void main(String... args)
    {
        Scanner input=new Scanner(System.in);
        int n= input.nextInt();
        int[][] lab=new int[n][n];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                lab[i][j]=input.nextInt();

            }
        }
        boolean BadLab = false;
        for (int i=0; i<n; i++)
        {
            if (BadLab) break;
            for (int j=0; j<n; j++)
            {
                if (lab[i][j] != 1)
                {

                    boolean gotit = false;
                    for (int a=0; a<n; a++)
                    {


                        for (int b=0; b<n; b++)
                        {

                            if (lab[i][a] + lab[b][j] == lab[i][j] && a != j&&b != i)
                            {
                                gotit = true;
                                break;
                            }
                        }
                        if (gotit) break;

                    }
                    if (gotit)
                    {
                        continue;
                    }
                    else
                    {
                        BadLab = true;
                        break;
                    }
                }
                if (BadLab) break;
            }
        }
        System.out.println(BadLab?"No":"Yes");
    }
}
