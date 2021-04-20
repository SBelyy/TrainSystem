package domain.user.driver;

import domain.user.Age;
import domain.user.passenger.Passenger;
import domain.user.passenger.Ticket;
import domain.user.passenger.TicketType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TrainDriverTest {

    @Test
    public void settersTest() {
        TrainDriver driver = new TrainDriver("Sashko", "Belly",
                Age.valueOf(23), LicenseType.VALID);

        assertEquals(23, driver.getAge().intValue());
        assertEquals(LicenseType.VALID, driver.getTypeLicense());

        Age newAge = Age.valueOf(24);
        driver.setTypeLicense(LicenseType.INVALID);
        driver.setAge(newAge);

        assertEquals(24, driver.getAge().intValue());
        assertEquals(LicenseType.INVALID, driver.getTypeLicense());
    }

}