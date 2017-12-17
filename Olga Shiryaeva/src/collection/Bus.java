package collection;

/**
 * Created by Helga on 12/4/2017.
 */
public class Bus extends Car {

    private int seating;

    private int doors;

    public Bus(String name, String color, Fuel fuel, int seating, int doors) {
        super(name,color,fuel);
        this.seating = seating;
        this.doors = doors;
    }

    public int getSeating() {
        return seating;
    }

    public int getDoors() {
        return doors;
    }

    @Override
    public String toString() {
        return super.toString()+" Seating : " + seating +" Doors : " + doors;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Bus bus = (Bus) o;
        if (seating != bus.seating) return false;
        return doors == bus.doors;
    }

}

