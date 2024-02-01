package org.traveldirectory;

public class Activity {
    private String name;
    private String description;
    private double cost;
    private int capacity;
    private Destination destination;
    private int signedUpPassengers;

    public Activity(String name, String description, double cost, int capacity, Destination destination) {
        this.name = name;
        this.description = description;
        this.cost = cost;
        this.capacity = capacity;
        this.destination = destination;
        this.signedUpPassengers = 0;
    }

    // Sign up a passenger for the activity
    public boolean signUpPassenger(Passenger passenger) {
        if (signedUpPassengers < capacity && destination != null) {
            signedUpPassengers++;
            return true;
        } else {
            System.out.println("Activity at capacity or no destination set. Cannot sign up more passengers.");
            return false;
        }
    }

    // Get remaining capacity for the activity
    public int getRemainingCapacity() {
        return capacity - signedUpPassengers;
    }

    // Get the destination of the activity
    public Destination getDestination() {
        return destination;
    }

    // Get the name of the activity
    public String getName() {
        return name;
    }

    // Get the cost of the activity
    public double getCost() {
        return cost;
    }

    // Get the capacity of the activity
    public int getCapacity() {
        return capacity;
    }

    // Get the description of the activity.
    public String getDescription() {
        return description;
    }
}

