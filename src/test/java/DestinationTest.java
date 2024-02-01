import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.traveldirectory.Activity;
import org.traveldirectory.Destination;

public class DestinationTest {

    @Test
    public void testPrintActivitiesWithSpaces() {
        // Create mock activities
        Activity activity1 = Mockito.mock(Activity.class);
        Activity activity2 = Mockito.mock(Activity.class);

        // Set up remaining capacities
        Mockito.when(activity1.getRemainingCapacity()).thenReturn(5);
        Mockito.when(activity2.getRemainingCapacity()).thenReturn(0); // No remaining capacity

        // Set up activity names
        Mockito.when(activity1.getName()).thenReturn("Hiking");
        Mockito.when(activity2.getName()).thenReturn("Sightseeing");

        // Create a destination and add mock activities
        Destination destination = new Destination("Mountain Valley");
        destination.addActivity(activity1);
        destination.addActivity(activity2);

        // Test printActivitiesWithSpaces method
        destination.printActivitiesWithSpaces(); // This will print the activities with available spaces

    }

    @Test
    public void testPrintActivities() {
        // Create mock activities
        Activity activity1 = Mockito.mock(Activity.class);
        Activity activity2 = Mockito.mock(Activity.class);

        // Set up activity details
        Mockito.when(activity1.getName()).thenReturn("Hiking");
        Mockito.when(activity1.getCost()).thenReturn(50.0);
        Mockito.when(activity1.getCapacity()).thenReturn(10);

        Mockito.when(activity2.getName()).thenReturn("Sightseeing");
        Mockito.when(activity2.getCost()).thenReturn(30.0);
        Mockito.when(activity2.getCapacity()).thenReturn(20);

        // Create a destination and add mock activities
        Destination destination = new Destination("Mountain Valley");
        destination.addActivity(activity1);
        destination.addActivity(activity2);

        // Test printActivities method
        destination.printActivities(); // This will print all activities

    }
}
