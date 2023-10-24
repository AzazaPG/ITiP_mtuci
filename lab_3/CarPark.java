import java.util.HashMap;
import java.util.Map;

public class CarPark {
    private Map<String, Car> carMap;

    public CarPark() {
        carMap = new HashMap<>();
    }

    public void addCar(String licensePlate, Car car) {
        carMap.put(licensePlate, car);
    }

    public Car findCar(String licensePlate) {
        return carMap.get(licensePlate);
    }

    public void removeCar(String licensePlate) {
        carMap.remove(licensePlate);
    }

    public static void main(String[] args) {
        Car car1 = new Car("Toyota", "Camry", 2020);
        Car car2 = new Car("Honda", "Accord", 2019);
        Car car3 = new Car("Ford", "Mustang", 2021);

        CarPark carPark = new CarPark();
        carPark.addCar("ABC123", car1);
        carPark.addCar("DEF456", car2);
        carPark.addCar("GHI789", car3);

        Car foundCar = carPark.findCar("DEF456");
        if (foundCar != null) {
            System.out.println("Found car: " + foundCar.getBrand() + " " + foundCar.getModel());
        } else {
            System.out.println("Car not found");
        }

        carPark.removeCar("GHI789");
        foundCar = carPark.findCar("GHI789");
        if (foundCar != null) {
            System.out.println("Found car: " + foundCar.getBrand() + " " + foundCar.getModel());
        } else {
            System.out.println("Car not found");
        }
    }
}