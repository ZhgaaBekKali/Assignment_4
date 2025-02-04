package Assignment_4;

import java.util.ArrayList;
import java.util.List;

public class CarDealership {
    private String name;
    private List<Car> cars;

    public CarDealership(String name) {
        this.name = name;
        this.cars = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void addCar(Car car) {
        cars.add(car);
        car.setCarDealership(this);
    }

    public Car findCarByBrand(String brandName) {
        for (Car car : cars) {
            if (car.getBrandName().equalsIgnoreCase(brandName)) {
                return car;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("CarDealership: " + name + "\n");
        sb.append("Cars in dealership:\n");
        for (Car car : cars) {
            sb.append("   ").append(car).append("\n");
        }
        return sb.toString();
    }
    
    public boolean removeCar(String brandToRemove) {
        return cars.removeIf(car -> car.getBrandName().equalsIgnoreCase(brandToRemove));
    }
}

