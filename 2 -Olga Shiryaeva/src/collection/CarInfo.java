package collection;

import exception.InvalidFileInfoException;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * Created by Helga on 12/4/2017.
 */
public class CarInfo <T extends Car>  {

    private ArrayList<T> cars;

    public CarInfo(File file)  throws FileNotFoundException, InvalidFileInfoException {

            Scanner in = new Scanner(file);
            boolean isPassengerCar;
            if(file.getName().equals("input1.txt")) {
                isPassengerCar = true;
            }
            else {
                if (file.getName().equals("input2.txt")) {
                    isPassengerCar = false;
                } else throw new InvalidFileInfoException("Unexpected Filename");
            }

            String name;
            String color;
            String fuel;
            int seatings;
            int doors;
            cars = new ArrayList<>();

            while(in.hasNextLine()){
                StringTokenizer stringTokenizer = new StringTokenizer(in.nextLine());
                if(stringTokenizer.hasMoreTokens())
                    name = stringTokenizer.nextToken();
                else throw new InvalidFileInfoException("Invalid File Info");
                if(stringTokenizer.hasMoreTokens())
                    color = stringTokenizer.nextToken();
                else throw new InvalidFileInfoException("Invalid File Info");
                if(stringTokenizer.hasMoreTokens())
                    fuel = stringTokenizer.nextToken();
                else throw new InvalidFileInfoException("Invalid File Info");
                if(isPassengerCar) {
                    if(stringTokenizer.hasMoreTokens()) {
                        PassengerCar passengerCar = new PassengerCar(name,color, Car.Fuel.valueOf(fuel),
                                PassengerCar.Material.valueOf(stringTokenizer.nextToken()));
                        cars.add((T)passengerCar);
                    }
                    else throw new InvalidFileInfoException("Invalid File Info");
                } else {
                    if(stringTokenizer.hasMoreTokens())
                        seatings = Integer.parseInt(stringTokenizer.nextToken());
                    else throw new InvalidFileInfoException("Invalid File Info");
                    if(stringTokenizer.hasMoreTokens())
                        doors = Integer.parseInt(stringTokenizer.nextToken());
                    else throw new InvalidFileInfoException("Invalid File Info");
                    cars.add((T)new Bus(name,color, PassengerCar.Fuel.valueOf(fuel),seatings,doors));
                }

            }


    }

    public String toString() {
       StringBuilder stringBuilder = new StringBuilder();
        for( T i : cars) {
            stringBuilder.append(i.toString()+"\n");
        }
        return stringBuilder.toString();
    }

    public int calculate(Car car) {

        Collections.sort(cars, new Comparator<T>() {
            @Override
            public int compare(T o1, T o2) {
                return o1.getName().compareTo(o2.getName()) +
                        o1.getColor().compareTo(o2.getColor()) +
                        o1.getFuel().compareTo(o2.getFuel());
            }
        });

        if(cars.contains(car))
            return cars.lastIndexOf(car) - cars.indexOf(car) + 1;
        else return 0;
    }

    public int binarySearch(Car car) {

        Comparator<Car> comparator = new Comparator<Car>() {
            @Override
            public int compare(Car o1, Car o2) {
                if (!o1.getName().equals(o2.getName())) {
                    return o1.getName().compareTo(o2.getName());
                } else {
                    return o2.getFuel().compareTo(o1.getFuel());
                }
            }
        };
        cars.sort(comparator);
        return Collections.binarySearch(cars, car, comparator);
    }

    public Car max() {
        if(cars.isEmpty())
            return null;
        Collections.sort(cars, new Comparator<T>() {
            @Override
            public int compare(T o1, T o2) {
                if(! o1.getName().equals(o2.getName())) {
                    return o2.getName().compareTo(o1.getName());
                }
                else {
                    return o1.getFuel().compareTo(o2.getFuel());
                }
            }
        });
        return cars.get(0);
    }

}
