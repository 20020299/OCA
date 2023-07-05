package Workshop.WS10;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Car> cars = new ArrayList<>();
        Car car1 = new Car("A", 1, "A");
        Car car2 = new Car("B", 1, "A");
        Car car3 = new Car("C", 1, "A");
        Car car4 = new Car("D", 1, "A");
        Car car5 = new Car("E", 1, "A");
        cars.add(car1);
        cars.add(car2);
        cars.add(car3);
        cars.add(car4);
        GenericCar<Car> genericCar = new GenericCar<>(cars);
        genericCar.display();
        genericCar.add(car5);
        genericCar.display();
        System.out.println(genericCar.checkEmpty());
        genericCar.delete(3);
        genericCar.display();

    }
}
