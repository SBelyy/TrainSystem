package domain.train.wagon;

import domain.train.Train;
import domain.user.driver.LicenseType;
import domain.user.driver.TrainDriver;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class LocomotiveTest {

    @Test
    void setTrainDriverTest() {
        TrainDriver invalidDriver = new TrainDriver("Vasia", "Pupkin",
                LocalDate.of(2000, 11, 11), LicenseType.INVALID);
        assertThrows(IllegalArgumentException.class, () -> new Locomotive(invalidDriver));

        TrainDriver validDriver = new TrainDriver("Vasia", "Pupkin",
                LocalDate.of(2000, 11, 11), LicenseType.VALID);
        assertDoesNotThrow(() -> new Locomotive(validDriver));
    }

}