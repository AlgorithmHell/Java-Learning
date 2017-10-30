using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace User_Generator
{
    class PersonData
    {
        private String[] names;
        private String[] surnames;
        private String[] streets;
        private String[] cities;
        private String[] numbers;
        private Random randomValue;
        public PersonData(String path)
        {
            names=System.IO.File.ReadAllLines(@path + "_surname.txt", Encoding.GetEncoding(1251));
            surnames=System.IO.File.ReadAllLines(@path + "_name.txt", Encoding.GetEncoding(1251));
            cities=System.IO.File.ReadAllLines(@path + "_cities.txt", Encoding.GetEncoding(1251));
            streets=System.IO.File.ReadAllLines(@path + "_streets.txt", Encoding.GetEncoding(1251));
            numbers=System.IO.File.ReadAllLines(@path + "_numbers.txt", Encoding.GetEncoding(1251));
            randomValue = new Random();
        }
        public String getRandomPersonData()
        {
            
            return names[randomValue.Next(0,names.Length)]+" " + surnames[randomValue.Next(0, surnames.Length)]+" "+
                   streets[randomValue.Next(0, streets.Length)] + " " + cities[randomValue.Next(0, cities.Length)] + " "+
                   numbers[randomValue.Next(0, numbers.Length)]+"\n";
        }
          
    }
}
