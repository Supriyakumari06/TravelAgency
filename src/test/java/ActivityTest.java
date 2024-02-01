import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.traveldirectory.Activity;
import org.traveldirectory.Destination;
import org.traveldirectory.Passenger;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class ActivityTest {

    @Test
    public void testSignUpPassenger_Success() {
        // Create a mock Destination
        Destination destinationMock = Mockito.mock(Destination.class);

        // Create an activity
        Activity activity = new Activity("Hiking", "Enjoy nature", 50.0, 10, destinationMock);

        // Create a mock Passenger
        Passenger passengerMock = Mockito.mock(Passenger.class);

        // Sign up a passenger
        boolean result = activity.signUpPassenger(passengerMock);

        // Verify that the passenger is signed up
        assertTrue(result);
        assertEquals(9, activity.getRemainingCapacity());
    }

    @Test
    public void testSignUpPassenger_Failure() {
        // Create a mock Destination
        Destination destinationMock = Mockito.mock(Destination.class);

        // Create an activity with maximum capacity already reached
        Activity activity = new Activity("Hiking", "Enjoy nature", 50.0, 1, destinationMock);

        // Create mock passengers
        Passenger passengerMock1 = Mockito.mock(Passenger.class);
        Passenger passengerMock2 = Mockito.mock(Passenger.class);

        // Sign up the first passenger (should succeed)
        assertTrue(activity.signUpPassenger(passengerMock1));

        // Sign up the second passenger (should fail)
        boolean result = activity.signUpPassenger(passengerMock2);

        // Verify that the passenger is not signed up
        assertFalse(result);
        assertEquals(0, activity.getRemainingCapacity());
    }
}
