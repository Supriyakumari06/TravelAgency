package org.traveldirectory;

import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static TravelPackage travelPackage;

    // Initialize this with your existing travel package object

    public static void main(String[] args) {
        System.out.println("Welcome to the Travel Agency System!");
        // Prompt user for package name and passenger capacity
        System.out.print("Enter the name of the travel package: ");
        String packageName = scanner.nextLine();

        System.out.print("Enter the passenger capacity of the travel package: ");
        int passengerCapacity = scanner.nextInt();
        scanner.nextLine(); // Consume newline character

        // Create a new TravelPackage object with user-provided values
         travelPackage = new TravelPackage(packageName, passengerCapacity);

        boolean exit = false;
        while (!exit) {
            System.out.println("\nSelect your role:");
            System.out.println("1. Admin");
            System.out.println("2. Passenger");
            System.out.println("3. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    handleAdminActions();
                    break;
                case 2:
                    handlePassengerActions();
                    break;
                case 3:
                    exit = true;
                    System.out.println("Exiting the system. Goodbye!");
                    travelPackage.printItinerary();
                    travelPackage.printPassengerList();
                    break;
                default:
                    System.out.println("Invalid choice. Please select again.");
                    break;
            }
        }

        scanner.close();
    }


    // Method to handle admin actions
    public static void handleAdminActions() {
        System.out.println("Admin Actions:");

        System.out.print("Do you want to add a new destination or activity? (destination/activity): ");
        String actionType = scanner.nextLine();

        if (actionType.equalsIgnoreCase("destination")) {
            addNewDestination();
        } else if (actionType.equalsIgnoreCase("activity")) {
            addNewActivity();
        } else {
            System.out.println("Invalid action type!");
        }
    }

    // Method to add a new destination
    public static void addNewDestination() {
        System.out.print("Enter the name of the new destination: ");
        String destinationName = scanner.nextLine();
        Destination newDestination = new Destination(destinationName);
        travelPackage.addDestination(newDestination);
        System.out.println("New destination added: " + destinationName);
    }

    // Method to add a new activity to an existing destination
    public static void addNewActivity() {
        System.out.println("Existing Destinations:");
        for (Destination destination : travelPackage.getDestinations()) {
            System.out.println(destination.getName());
        }

        System.out.print("Enter the name of the destination to add activity to: ");
        String destinationName = scanner.nextLine();

        Destination existingDestination = null;
        for (Destination destination : travelPackage.getDestinations()) {
            if (destination.getName().equalsIgnoreCase(destinationName)) {
                existingDestination = destination;
                break;
            }
        }

        if (existingDestination == null) {
            System.out.println("Destination not found!");
            return;
        }

        System.out.print("Enter the name of the new activity: ");
        String activityName = scanner.nextLine();
        System.out.print("Enter the description of the new activity: ");
        String activityDescription = scanner.nextLine();
        System.out.print("Enter the cost of the new activity: ");
        double activityCost = scanner.nextDouble();
        System.out.print("Enter the capacity of the new activity: ");
        int activityCapacity = scanner.nextInt();

        Activity newActivity = new Activity(activityName, activityDescription, activityCost, activityCapacity, existingDestination);
        existingDestination.addActivity(newActivity);
        System.out.println("New activity added to " + destinationName + ": " + activityName);
    }

    // Method to handle passenger actions
    public static void handlePassengerActions() {
        System.out.println("Passenger Actions:");
        System.out.print("Enter the name of the new passenger: ");
        String name = scanner.nextLine();
        System.out.print("Enter the phone number of the new passenger: ");
        int phoneNumber = scanner.nextInt();
        scanner.nextLine(); // Consume newline character
        System.out.print("Enter the type of the new passenger (standard/gold/premium): ");
        String typeStr = scanner.nextLine();

        // Convert string to enum
        PassengerType type;
        switch (typeStr.toLowerCase()) {
            case "standard":
                type = PassengerType.STANDARD;
                break;
            case "gold":
                type = PassengerType.GOLD;
                break;
            case "premium":
                type = PassengerType.PREMIUM;
                break;
            default:
                System.out.println("Invalid passenger type!");
                return;
        }

        System.out.print("Enter the initial balance of the new passenger: ");
        double initialBalance = scanner.nextDouble();
        scanner.nextLine(); // Consume newline character

        // Create a new Passenger object
        Passenger newPassenger = new Passenger(name, phoneNumber, type, initialBalance);

        // Add the new passenger to the travel package
        travelPackage.addPassenger(newPassenger);
        System.out.println("New passenger added: " + name);


        // Display available destinations and activities
        System.out.println("Available Destinations:");
        for (Destination destination : travelPackage.getDestinations()) {
            System.out.println(destination.getName());
        }

        System.out.println("Enter the name of the destination you want to visit: ");
        String selectedDestinationName = scanner.nextLine();

        // Find the selected destination
        Destination selectedDestination = null;
        for (Destination destination : travelPackage.getDestinations()) {
            if (destination.getName().equalsIgnoreCase(selectedDestinationName)) {
                selectedDestination = destination;
                break;
            }
        }

        if (selectedDestination == null) {
            System.out.println("Destination not found!");
            return;
        }

        // Display available activities in the selected destination
        System.out.println("Available Activities in " + selectedDestination.getName() + ":");
        for (Activity activity : selectedDestination.getAllActivities()) {
            System.out.println(activity.getName());
            System.out.println(activity.getDescription());
            System.out.println(activity.getCost());

        }

        System.out.println("Enter the name of the activity you want to participate in: ");
        String selectedActivityName = scanner.nextLine();

        // Find the selected activity
        Activity selectedActivity = null;
        for (Activity activity : selectedDestination.getAllActivities()) {
            if (activity.getName().equalsIgnoreCase(selectedActivityName)) {
                selectedActivity = activity;
                break;
            }
        }

        if (selectedActivity == null) {
            System.out.println("Activity not found!");
            return;
        }

        // Check if there is available capacity for the selected activity
        if (selectedActivity.getRemainingCapacity() <= 0) {
            System.out.println("Sorry, the selected activity is already fully booked!");
            newPassenger.printDetails();
            return;
        }

        //Adding activity in passenger profile.
        newPassenger.signUpForActivity(selectedActivity);
        System.out.println("You have successfully signed up for the activity: " + selectedActivity.getName());

        //Printing passenger profile
        newPassenger.printDetails();
    }

}
