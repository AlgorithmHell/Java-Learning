/**
 * Created by Helga on 7/30/2017.
 */

    import java.util.*;

    public class Main {
        public static void main(String... args) {

            Scanner input = new Scanner(System.in);
            int n = input.nextInt();
            int a = input.nextInt();
            int b = input.nextInt();

            int[] guests = new int[n];
            for(int i=0;i<n;i++)
            {
                guests[i]=input.nextInt();
            }
            int extra=0;
           int halfTable=0;

            for (int i = 0; i<n; i++)
            {

                if(guests[i]==2)
                {
                    if(b!=0)
                    {
                        b--;
                        continue;
                    }
                    else
                    {
                        extra+=2;
                        continue;
                    }

                }

                if(guests[i]==1)
                {
                    if(a!=0)
                    {
                        a--;
                        continue;
                    }
                    else
                    {
                        if(b!=0)
                        {
                            b--;
                            halfTable++;
                            continue;

                        }
                        else
                        {
                            if(halfTable!=0)
                            {
                                halfTable--;
                                continue;
                            }
                            else
                            {
                                extra++;
                            }
                        }
                    }
                }
            }


            System.out.println(extra);
        }
    }