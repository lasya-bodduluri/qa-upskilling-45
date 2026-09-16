package Day08;

public class Car extends Vehicle implements Drivable{

    public Car(String brand) {
        super(brand);
    }

    @Override
    public void start() {
        System.out.println(getBrand() + " car starts with a key");
    }

    @Override
    public void drive() {
        System.out.println(getBrand() + " car is driving");
    }
}
