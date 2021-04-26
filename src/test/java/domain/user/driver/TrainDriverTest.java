package domain.user.driver;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TrainDriverTest {

    @Test
    public void settersTest() {
        TrainDriver driver = new TrainDriver("Sashko", "Belly",
                LocalDate.of(2000, 1, 12), LicenseType.VALID);

        assertEquals(21, driver.getAge());
        assertEquals(LicenseType.VALID, driver.getTypeLicense());

        driver.setTypeLicense(LicenseType.INVALID);

        assertEquals(LicenseType.INVALID, driver.getTypeLicense());
    }

}