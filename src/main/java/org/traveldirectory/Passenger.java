package org.traveldirectory;

import java.util.ArrayList;
import java.util.List;

public class Passenger {
    private String name;
    private int passengerNumber;
    private PassengerType passengerType;
    private double balance;
    private List<Activity> signedUpActivities;

    public Passenger(String name, int passengerNumber, PassengerType passengerType, double balance) {
        this.name = name;
        this.passengerNumber = passengerNumber;
        this.passengerType = passengerType;
        this.balance = balance;
        this.signedUpActivities = new ArrayList<>();
    }

    // Sign up for an activity
    public boolean signUpForActivity(Activity activity) {
        if (activity.signUpPassenger(this)) {
            signedUpActivities.add(activity);
            if (passengerType == PassengerType.STANDARD) {
                balance -= activity.getCost(); // Deduct the cost for standard passengers
            } else if (passengerType == PassengerType.GOLD) {
                double discountedCost = activity.getCost() * 0.9;
                balance -= discountedCost; // Deduct the discounted cost for gold passengers
            }
            // Premium passengers don't pay, so no balance deduction for them
            return true;
        } else {
            System.out.println("Failed to sign up for activity: " + activity.getName());
            return false;
        }
    }

    // Print details of the passenger
    public void printDetails() {
        System.out.println("Passenger Details - Name: " + name + ", Number: " + passengerNumber);
        System.out.println("Type: " + passengerType + ", Balance: " + balance);
        System.out.println("Signed Up Activities:");
        for (Activity activity : signedUpActivities) {
            System.out.println("Activity: " + activity.getName() +
                    ", Destination: " + activity.getDestination().getName() +
                    ", Price Paid: " + (activity.getCost() * (passengerType == PassengerType.GOLD ? 0.9 : 1.0)));
        }
    }

    // Get the name of the passenger
    public String getName() {
        return name;
    }

    // Get the passenger number
    public int getPassengerNumber() {
        return passengerNumber;
    }


}
