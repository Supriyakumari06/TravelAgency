import org.junit.jupiter.api.Test;
import org.traveldirectory.Destination;
import org.traveldirectory.Passenger;
import org.traveldirectory.PassengerType;
import org.traveldirectory.TravelPackage;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import static org.mockito.Mockito.mock;

public class TravelPackageTest {

    private TravelPackage travelPackage;

    @BeforeEach
    public void setUp() {
        // Create a new TravelPackage instance before each test
        travelPackage = new TravelPackage("Package A", 20);
    }

    @Test
    public void testAddDestination() {
        // Create a mock destination
        Destination destinationMock = mock(Destination.class);

        // Add the mock destination to the travel package
        travelPackage.addDestination(destinationMock);

        // Verify that the destination is added
        assertEquals(1, travelPackage.getDestinations().size());
    }

    @Test
    public void testAddPassenger() {
        // Create a mock passenger
        Passenger passengerMock = mock(Passenger.class);

        // Add the mock passenger to the travel package
        travelPackage.addPassenger(passengerMock);

        // Verify that the passenger is added
        assertEquals(1, travelPackage.getPassengerList().size());
    }


    @Test
    public void printItenaryTest(){
        //Create two mock destination.
        Destination destination1= mock(Destination.class);
        Destination destination2= mock(Destination.class);

        //Create a Travel Package.
        TravelPackage travelPackage = new TravelPackage("ABC", 50);

        //Add destinations to travel package.
        travelPackage.addDestination(destination1);
        travelPackage.addDestination(destination2);

        //Printing itinerary.
        travelPackage.printItinerary();
    }

    @Test
    public void printPassengerListTest(){
        //Creating two mock passengers.
        Passenger passenger1=new Passenger("abc",123, PassengerType.STANDARD,100.0);
        Passenger passenger2=new Passenger("def",456, PassengerType.GOLD,300.0);

        //Creating travel package.
        TravelPackage travelPackage = new TravelPackage("ABC", 50);

        //Adding passenger to travel package.
        travelPackage.addPassenger(passenger1);
        travelPackage.addPassenger(passenger2);

        travelPackage.printPassengerList();
    }
}
