package domain.train;

import domain.cargo.CargoType;
import domain.cargo.Weight;
import domain.train.wagon.FreightWagon;
import domain.train.wagon.Locomotive;
import domain.train.wagon.PassengerWagon;
import domain.user.driver.LicenseType;
import domain.user.driver.TrainDriver;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class TrainTest {

    private Train train;

    @BeforeEach
    public void before() {
        TrainDriver driver = new TrainDriver("Vasia", "Pupkin",
                LocalDate.of(2000, 3, 12), LicenseType.VALID);
        Locomotive locomotive = new Locomotive(driver);
        train = new Train(locomotive, 1);
    }

    @Test
    public void addWagonTest() {
        PassengerWagon wagonOne = new PassengerWagon(20);
        PassengerWagon wagonTwo = new PassengerWagon(30);

        train.addWagon(wagonOne);
        train.addWagon(wagonTwo);

        assertEquals(3, train.getTrainLength());
        assertEquals(wagonOne, train.getWagonByNumber(wagonOne.getNumber()));
        assertEquals(wagonTwo, train.getWagonByNumber(wagonTwo.getNumber()));
    }

    @Test
    public void removeLastWagonTest() {
        FreightWagon wagon = new FreightWagon(CargoType.DANGEROUS, new Weight(30000));
        int trainLength = train.getTrainLength();

        train.addWagon(wagon);
        int wagonNumber = wagon.getNumber();

        train.removeLastWagon();

        assertEquals(trainLength, train.getTrainLength());
        assertThrows(IllegalArgumentException.class, () -> train.getWagonByNumber(wagonNumber));
    }

    @Test
    public void addNewLocomotiveTest() {
        TrainDriver driver = new TrainDriver("Vasia", "Pupkin",
                LocalDate.of(2000, 5, 11), LicenseType.VALID);
        Locomotive locomotive = new Locomotive(driver);
        train.addNewLocomotive(locomotive);

        assertEquals(locomotive, train.getWagonByNumber(1));
    }

    @Test
    public void getWagonByNumberTest() {
        FreightWagon wagonOne = new FreightWagon(CargoType.DANGEROUS, new Weight(3000));
        FreightWagon wagonTwo = new FreightWagon(CargoType.BULK, new Weight(3000));

        train.addWagon(wagonOne);
        train.addWagon(wagonTwo);

        assertEquals(3, train.getTrainLength());
        assertEquals(wagonOne, train.getWagonByNumber(wagonOne.getNumber()));
        assertEquals(wagonTwo, train.getWagonByNumber(wagonTwo.getNumber()));
    }
}