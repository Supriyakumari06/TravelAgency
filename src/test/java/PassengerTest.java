import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.traveldirectory.Activity;
import org.traveldirectory.Passenger;
import org.traveldirectory.PassengerType;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PassengerTest {
    Activity activity = Mockito.mock(Activity.class);

    @Test
    public void signUpForActivityTest_Success(){
        Passenger passenger=new Passenger("abc",123, PassengerType.STANDARD,100.0);
        Mockito.when(activity.signUpPassenger(passenger)).thenReturn(true);
        boolean result = passenger.signUpForActivity(activity);
        assertTrue(result);
    }

    @Test
    public void signUpForActivityTest_Failure(){
        Passenger passenger=new Passenger("abc",123, PassengerType.PREMIUM,100.0);
        Mockito.when(activity.signUpPassenger(passenger)).thenReturn(false);
        boolean result = passenger.signUpForActivity(activity);
        assertFalse(result);
    }


}
