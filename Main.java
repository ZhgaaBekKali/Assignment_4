package Assignment_4;
import java.util.Scanner;

class Task_5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        CarDealership dealership = new CarDealership("Super Cars Showroom");

        Car car1 = new Car("BMW", 5, 50000, 2);
        Car car2 = new Car("Mercedes", 4, 60000, 3);

        dealership.addCar(car1);
        dealership.addCar(car2);

        PurchaseRequest req1 = new PurchaseRequest("Alice", "123-456", car1);
        PurchaseRequest req2 = new PurchaseRequest("Bob", "987-654", car2);
        PurchaseRequest req3 = new PurchaseRequest("Charlie", "555-666", car2);

        car1.addPurchaseRequest(req1);
        car2.addPurchaseRequest(req2);
        car2.addPurchaseRequest(req3);

        int choice = -1;
        while (choice != 0) {
            System.out.println("\n=== CAR DEALERSHIP MENU ===");
            System.out.println("1) Display Dealership Info");
            System.out.println("2) Display a Car and its Purchase Requests");
            System.out.println("3) Add a new Car to the Dealership");
            System.out.println("4) Add a new Purchase Request to an existing Car");
            System.out.println("5) Search for a Car by brand name");
            System.out.println("6) Remove a Car from the Dealership");  // <-- Новый пункт
            System.out.println("0) Exit");
            System.out.print("Enter choice: ");

            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                scanner.nextLine();
            } else {
                System.out.println("Invalid input! Please enter a number.");
                scanner.nextLine();
                continue;
            }

            switch (choice) {
                case 1:
                    System.out.println(dealership);
                    break;

                case 2:
                    System.out.print("Enter brand of the car to display: ");
                    String brandToDisplay = scanner.nextLine();
                    Car foundCar = dealership.findCarByBrand(brandToDisplay);
                    if (foundCar != null) {
                        System.out.println("Car Info: " + foundCar);
                        System.out.println("Purchase Requests:");
                        for (PurchaseRequest pr : foundCar.getPurchaseRequests()) {
                            System.out.println("   " + pr);
                        }
                    } else {
                        System.out.println("No car found with brand: " + brandToDisplay);
                    }
                    break;

                case 3:
                    System.out.print("Enter brand name: ");
                    String brand = scanner.nextLine();

                    System.out.print("Enter max passengers: ");
                    int maxPassengers = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Enter cost: ");
                    double cost = scanner.nextDouble();
                    scanner.nextLine();

                    System.out.print("Enter quantity in stock: ");
                    int qty = scanner.nextInt();
                    scanner.nextLine();

                    Car newCar = new Car(brand, maxPassengers, cost, qty);
                    dealership.addCar(newCar);

                    System.out.println("New car added to the dealership.");
                    break;

                case 4:
                    System.out.print("Enter the brand of the car for the request: ");
                    String carBrand = scanner.nextLine();
                    Car carForRequest = dealership.findCarByBrand(carBrand);

                    if (carForRequest == null) {
                        System.out.println("No car found with brand: " + carBrand);
                    } else {
                        System.out.print("Enter buyer name: ");
                        String buyerName = scanner.nextLine();

                        System.out.print("Enter phone number: ");
                        String phone = scanner.nextLine();

                        PurchaseRequest newRequest = new PurchaseRequest(buyerName, phone, carForRequest);
                        carForRequest.addPurchaseRequest(newRequest);
                        System.out.println("Purchase request added for car: " + carForRequest.getBrandName());
                    }
                    break;

                case 5:
                    System.out.print("Enter brand name to search: ");
                    String searchBrand = scanner.nextLine();
                    Car result = dealership.findCarByBrand(searchBrand);
                    if (result != null) {
                        System.out.println("Car found: " + result);
                    } else {
                        System.out.println("Car with brand '" + searchBrand + "' not found.");
                    }
                    break;

                case 6:
                    System.out.print("Enter the brand of the car to remove: ");
                    String brandToRemove = scanner.nextLine();
                    boolean removed = dealership.removeCar(brandToRemove);
                    if (removed) {
                        System.out.println("Car with brand '" + brandToRemove + "' removed successfully.");
                    } else {
                        System.out.println("No car found with brand: " + brandToRemove);
                    }
                    break;

                case 0:
                    System.out.println("Exiting program...");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }


        scanner.close();
    }
}
