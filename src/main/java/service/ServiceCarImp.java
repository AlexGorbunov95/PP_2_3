package service;
import model.Car;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

@Component

public class ServiceCarImp implements ServiceCar {
    private int COUNT;
    private List<Car> cars;

    {
        cars = new ArrayList<>();
        cars.add(new Car(++COUNT, "Kia", 123, "black"));
        cars.add(new Car(++COUNT, "Lada", 111, "Red"));
        cars.add(new Car(++COUNT, "Mazda", 777, "While"));
        cars.add(new Car(++COUNT, "Volvo", 987, "grey"));
        cars.add(new Car(++COUNT, "Ford", 345, "blue"));
    }

    @Override
    public List<Car> addCar() {
        return cars;
    }

    @Override
    public List<Car> getCarCount(Integer count) {
        List<Car> cars1 = new ArrayList<>();
        for (Car car : cars) {
            if (count != null && count >= car.getId()) {
                cars1.add(car);
            }
        }
        return cars1;
    }
}
