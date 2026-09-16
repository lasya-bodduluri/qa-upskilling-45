package Day08;

public class Driver {

    public static void main(String[] args) {

        Vehicle[] vehicles = {
                new Car("Toyota"),
                new Bike("Honda"),
                new Truck("Volvo")
        };

        for (Vehicle vehicle : vehicles) {

            System.out.println("Brand: " + vehicle.getBrand());

            vehicle.start();

            if (vehicle instanceof Drivable) {
                Drivable d = (Drivable) vehicle;
                d.drive();
            }

            System.out.println("----------------");
        }
    }
}