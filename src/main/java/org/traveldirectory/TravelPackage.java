package org.traveldirectory;

import java.util.ArrayList;
import java.util.List;

public class TravelPackage {
    private String packageName;
    private int passengerCapacity;
    private static List<Destination> destinations;
    private List<Passenger> passengerList;

    public TravelPackage(String packageName, int passengerCapacity) {
        this.packageName = packageName;
        this.passengerCapacity = passengerCapacity;
        this.destinations = new ArrayList<>();
        this.passengerList = new ArrayList<>();
    }

    // Add destination to the travel package
    public void addDestination(Destination destination) {
        destinations.add(destination);
    }

    // Add passenger to the travel package
    public void addPassenger(Passenger passenger) {
        if (passengerList.size() < passengerCapacity) {
            passengerList.add(passenger);
        } else {
            System.out.println("Travel package is full. Cannot add more passengers.");
        }
    }

    // Print itinerary details
    public void printItinerary() {
        System.out.println("Travel Package: " + packageName);
        System.out.println("Destinations and Activities:");
        for (Destination destination : destinations) {
            System.out.println(destination.getName());
            destination.printActivities();
            destination.printActivitiesWithSpaces();
        }
    }

    //Get list of all destination present
    public static List<Destination> getDestinations() {
        return destinations;
    }

    //Get list of all passenger
    public List<Passenger> getPassengerList() {
        return passengerList;
    }

    // Print passenger list details
    public void printPassengerList() {
        System.out.println("Passenger List for " + packageName);
        System.out.println("Capacity: " + passengerCapacity);
        System.out.println("Enrolled Passengers: " + passengerList.size());
        for (Passenger passenger : passengerList) {
            System.out.println("Name: " + passenger.getName() + ", Number: " + passenger.getPassengerNumber());
        }
    }
}
