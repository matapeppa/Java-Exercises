import java.util.Scanner;

class Car {
    private String plateNumber;
    private String model;
    private int kilometers;
    private boolean isRented;

    public Car(String plateNumber, String model, int kilometers) {
        this.plateNumber = plateNumber;
        this.model = model;
        this.kilometers = kilometers;
        this.isRented = false;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public boolean isRented() {
        return isRented;
    }

    public void rentCar() {
        if (!isRented) {
            isRented = true;
            System.out.println("Car " + plateNumber + " has been rented.");
        } else {
            System.out.println("Car " + plateNumber + " is already rented.");
        }
    }

    public void returnCar(int newKilometers) {
        if (isRented) {
            if (newKilometers >= kilometers) {
                kilometers = newKilometers;
                isRented = false;
                System.out.println("Car " + plateNumber + " has been returned.");
            } else {
                System.out.println("Invalid kilometers. The value must be greater than or equal to " + kilometers);
            }
        } else {
            System.out.println("Car " + plateNumber + " was not rented.");
        }
    }

    public void displayCar() {
        System.out.println("Plate: " + plateNumber + ", Model: " + model + ", KM: " + kilometers + ", Rented: " + (isRented ? "Yes" : "No"));
    }
}

public class CarRental {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Car[] cars = new Car[5];
        cars[0] = new Car("ABC123", "Toyota Corolla", 25000);
        cars[1] = new Car("XYZ789", "Honda Civic", 32000);
        cars[2] = new Car("LMN456", "Ford Focus", 41000);
        cars[3] = new Car("QWE987", "BMW X3", 18000);
        cars[4] = new Car("RTY654", "Mercedes C-Class", 29000);

        while (true) {
            System.out.println("\nCar Rental System");
            System.out.println("1. Rent a Car");
            System.out.println("2. Return a Car");
            System.out.println("3. Display All Cars");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            if (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next(); // Consume invalid input
                continue;
            }
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter plate number to rent: ");
                    String rentPlate = scanner.nextLine();
                    boolean found = false;
                    for (Car car : cars) {
                        if (car.getPlateNumber().equalsIgnoreCase(rentPlate)) {
                            car.rentCar();
                            found = true;
                            break;
                        }
                    }
                    if (!found) System.out.println("Car not found.");
                    break;

                case 2:
                    System.out.print("Enter plate number to return: ");
                    String returnPlate = scanner.nextLine();
                    found = false;
                    for (Car car : cars) {
                        if (car.getPlateNumber().equalsIgnoreCase(returnPlate)) {
                            int newKm;
                            while (true) {
                                System.out.print("Enter new kilometers: ");
                                if (scanner.hasNextInt()) {
                                    newKm = scanner.nextInt();
                                    scanner.nextLine(); // Consume newline
                                    break;
                                } else {
                                    System.out.println("Invalid input. Please enter a valid number.");
                                    scanner.next(); // Consume invalid input
                                }
                            }
                            car.returnCar(newKm);
                            found = true;
                            break;
                        }
                    }
                    if (!found) System.out.println("Car not found.");
                    break;

                case 3:
                    System.out.println("\nAvailable Cars:");
                    for (Car car : cars) {
                        car.displayCar();
                    }
                    break;

                case 4:
                    System.out.println("Exiting Car Rental System.");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }
}
