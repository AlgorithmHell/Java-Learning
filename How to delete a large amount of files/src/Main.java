/**
 * Created by Helga on 8/25/2017.
 */
import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.util.*;
import static java.nio.file.StandardCopyOption.*;
public class Main {
    public static void main(String[] args)
    {
        File Origin = new File("E:\\look\\2607");
        File[] OriginFiles = Origin.listFiles();
        File ToBeEdited = new File("E:\\base_done\\Evroopt 26.07");

        File[] ToBeEditedFiles = ToBeEdited.listFiles();
        boolean[] Exists=new boolean[ToBeEditedFiles.length];
        Sort(ToBeEditedFiles);
        Sort(OriginFiles);
        int originAmount=0, toBeEditedAmount=0;
        for (File i: OriginFiles)
        {
            originAmount++;
            System.out.println(i.getName());
        }
        for (File i: ToBeEditedFiles)
        {
            toBeEditedAmount++;
            System.out.println(i.getName());
        }
        System.out.println(OriginFiles.length+" "+toBeEditedAmount);

        boolean isHere=false;
        for (int j=0;j<ToBeEditedFiles.length;j++)
        {
            isHere=false;

         for(int i=0;i<OriginFiles.length;i++)
         {

             if(ToBeEditedFiles[j].getName().compareTo(OriginFiles[i].getName())==0)
             {
                 isHere=true;
                 break;
             }
         }
         if(isHere)

         {
            Exists[j]=true;
            Exists[j-1]=true;

         }
         else
         {
             Exists[j]=false;
         }
        }
        for(int i=0;i<ToBeEditedFiles.length;i++)
        {
            if(Exists[i]==false)
            {
                ToBeEditedFiles[i].delete();
            }
        }
    }

    public static int Sort(File[] arr)
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
                    if(arr[j-1].getName().compareTo(arr[j].getName())>0)
                    {
                        File buf=arr[j-1];
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
}
