package main;

import collection.Bus;
import collection.Car;
import collection.CarInfo;
import collection.PassengerCar;
import exception.InvalidFileInfoException;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;

/**
 * Created by Helga on 12/3/2017.
 */
public class Main {

    public static void main (String... args) {

        try {

            CarInfo carInfo1 = new CarInfo(new File("input1.txt"));
            CarInfo carInfo2 = new CarInfo(new File("input2.txt"));

            carInfo1.toString();

            System.out.println("Searching for car BMW Black Diesel Suede");
            System.out.println(carInfo1.binarySearch(new PassengerCar("BMW","Black", Car.Fuel.valueOf("DIESEL"),
                    PassengerCar.Material.valueOf("SUEDE"))));

            System.out.println("Calculating for car BMW Black Diesel Leather");
            System.out.println(carInfo1.calculate(new PassengerCar("BMW","Black", Car.Fuel.valueOf("DIESEL"),
                    PassengerCar.Material.valueOf("LEATHER"))));
            System.out.println("Max : "+carInfo1.max());

            System.out.println("***   ***   ***  ***  ***  ***");

            carInfo2.toString();

            System.out.println("Searching for car BMW Pink Diesel 38 4");
            System.out.println(carInfo2.binarySearch(new Bus("BMW","Pink", Car.Fuel.valueOf("DIESEL"),38,4)));

            System.out.println("Calculating for car BMW Black Diesel 100 3");
            System.out.println(carInfo2.calculate(new Bus("BMW","Black", Car.Fuel.valueOf("DIESEL"),100,3)));
            System.out.println("Max : "+carInfo2.max());

        } catch (NumberFormatException e) {
            System.out.println("Input Mismatch: " + e.getMessage());
        }
        catch(FileNotFoundException e)
        {
            System.out.println("File not found "+e.getMessage());
        }
        catch(InputMismatchException e)
        {
            System.out.println("Incorrect Data ");
        }
        catch (InvalidFileInfoException e){
            System.out.println(e.getMessage());
        }
        catch (IllegalArgumentException e) {
            System.out.println("Illegal argument "+e.getMessage());
        }
    }

}
