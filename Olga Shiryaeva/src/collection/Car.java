package collection;

/**
 * Created by Helga on 12/4/2017.
 */
public abstract class Car {

    protected String name;

    protected String color;

    public enum Fuel {
        PETROL, DIESEL
    }

    protected Fuel fuel;

    public Car(String name, String color, Fuel fuel) {
        this.name = name;
        this.color = color;
        this.fuel = fuel;
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public Fuel getFuel() {
        return fuel;
    }

    @Override
    public String toString() {
        return " Name : " + name + " Color : "+ color +" Fuel : " + fuel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Car car = (Car) o;

        if (name != null ? !name.equals(car.name) : car.name != null) return false;
        if (color != null ? !color.equals(car.color) : car.color != null) return false;
        return fuel != null ? fuel.equals(car.fuel) : car.fuel == null;
    }

}
