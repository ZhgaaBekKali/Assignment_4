package Assignment_4;

import java.util.ArrayList;
import java.util.List;

public class Car {
    private String brandName;
    private int maxPassengers;
    private double cost;
    private int quantityInStock;

    private CarDealership carDealership;
    private List<PurchaseRequest> purchaseRequests;

    public Car(String brandName, int maxPassengers, double cost, int quantityInStock) {
        this.brandName = brandName;
        this.maxPassengers = maxPassengers;
        this.cost = cost;
        this.quantityInStock = quantityInStock;
        this.purchaseRequests = new ArrayList<>();
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public int getMaxPassengers() {
        return maxPassengers;
    }

    public void setMaxPassengers(int maxPassengers) {
        this.maxPassengers = maxPassengers;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public int getQuantityInStock() {
        return quantityInStock;
    }

    public void setQuantityInStock(int quantityInStock) {
        this.quantityInStock = quantityInStock;
    }

    public boolean isAvailability() {
        return quantityInStock > purchaseRequests.size();
    }

    public CarDealership getCarDealership() {
        return carDealership;
    }

    public void setCarDealership(CarDealership carDealership) {
        this.carDealership = carDealership;
    }

    public List<PurchaseRequest> getPurchaseRequests() {
        return purchaseRequests;
    }

    public void addPurchaseRequest(PurchaseRequest request) {
        purchaseRequests.add(request);
    }

    public void removePurchaseRequest(PurchaseRequest request) {
        purchaseRequests.remove(request);
    }

    @Override
    public String toString() {
        return "Car{" +
                "brandName='" + brandName + '\'' +
                ", maxPassengers=" + maxPassengers +
                ", cost=" + cost +
                ", quantityInStock=" + quantityInStock +
                ", availability=" + isAvailability() +
                '}';
    }
}
