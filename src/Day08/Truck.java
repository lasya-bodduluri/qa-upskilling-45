package Day08;

public class Truck extends Vehicle implements Drivable {

    public Truck(String brand) {
        super(brand);
    }

    @Override
    public void start() {
        System.out.println(getBrand() + " truck starts with a heavy engine");
    }

    @Override
    public void drive() {
        System.out.println(getBrand() + " truck is driving");
    }
}