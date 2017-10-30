using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading;

namespace User_Generator
{
    class Program
    {        
        static void Main(string[] args)
        {
            try
            {
                if (args.Length != 2) throw new ArgumentsMismatchException(args.Length.ToString());
                Console.OutputEncoding = Encoding.UTF8;
                PersonData personData = new PersonData(args[0]);
                for (int i = 0; i < Convert.ToInt32(args[1]); i++)
                {
                    Console.Write(personData.getRandomPersonData());
                }
            }
            //catch(System.IO.FileNotFoundException e)
            // {
            //     Console.WriteLine(e.Message);
            // }
            // catch(System.IndexOutOfRangeException e)
            // {
            //     Console.WriteLine(e.Message);
            // }
            // catch(System.FormatException e)
            // {
            //     Console.WriteLine(e.Message);
            // }
            //catch (ArgumentsMismatchException e)
            //{
            //    Console.WriteLine("Arguments mismatch : " + e.Message);
            //}
            catch (Exception e)
            {
                Console.WriteLine(e.Message);
            }
            Console.WriteLine("Press any key to exit.");
            System.Console.ReadKey();
            System.Console.ReadKey();
        }      
    }
}
