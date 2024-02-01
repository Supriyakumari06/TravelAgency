package org.traveldirectory;

import java.util.ArrayList;
import java.util.List;


public class Destination {
    private String name;
    private List<Activity> activities;

    public Destination(String name) {
        this.name = name;
        this.activities = new ArrayList<>();
    }

    // Add activity to the destination
    public void addActivity(Activity activity) {
        activities.add(activity);
    }

    //Get name of the destination.
    public String getName() {
        return name;
    }

    //Get the list of all activities present in the specific destination.
    public List<Activity> getAllActivities() {
        return activities;
    }

    // Print activities with available spaces
    public void printActivitiesWithSpaces() {
        System.out.println("Activities with Available Spaces at " + name + ":");
        for (Activity activity : activities) {
            if (activity.getRemainingCapacity() > 0) {
                System.out.println("Name: " + activity.getName() + ", Remaining Capacity: " + activity.getRemainingCapacity());
            }
        }
    }

    // Print all activities
    public void printActivities() {
        System.out.println("Activities at " + name + ":");
        for (Activity activity : activities) {
            System.out.println("Name: " + activity.getName() + ", Cost: " + activity.getCost() + ", Capacity: " + activity.getCapacity());
        }
    }
}
