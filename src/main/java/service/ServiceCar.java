package service;

import model.Car;

import java.util.List;

public interface ServiceCar {
    List<Car> addCar();

    List<Car> getCarCount(Integer count);
}
