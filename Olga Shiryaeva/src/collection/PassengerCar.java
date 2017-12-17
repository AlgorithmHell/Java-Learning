package collection;

/**
 * Created by Helga on 12/4/2017.
 */
public class PassengerCar extends Car {

    public enum Material {
        FUR, DENIM, LEATHER, SUEDE
    }

    private Material material;

    public PassengerCar(String name, String color, Fuel fuel, Material material) {
        super(name, color, fuel);
        this.material = material;
    }

    @Override
    public String toString() {
        return super.toString()+" Material : " + material;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        PassengerCar that = (PassengerCar) o;

        return material == that.material;
    }

}
