package Day08;

public class Bike extends Vehicle implements Drivable {

    public Bike(String brand) {
        super(brand);
    }

    @Override
    public void start() {
        System.out.println(getBrand() + " bike starts with a button");
    }

    @Override
    public void drive() {
        System.out.println(getBrand() + " bike is riding");
    }
}