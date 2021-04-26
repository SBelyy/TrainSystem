package domain.train.wagon;

import domain.cargo.Cargo;
import domain.cargo.CargoType;
import domain.cargo.Weight;
import domain.train.Train;
import domain.user.driver.LicenseType;
import domain.user.driver.TrainDriver;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class FreightWagonTest {

    private Train train;

    @BeforeEach
    public void before() {
        TrainDriver driver = new TrainDriver("Vasia", "Pupkin",
                LocalDate.of(2000, 3, 12), LicenseType.VALID);
        Locomotive locomotive = new Locomotive(driver);
        train = new Train(locomotive, 1);
    }

    @Test
    void addCargoTest() {
        FreightWagon wagon = new FreightWagon(CargoType.DANGEROUS, new Weight(200_000));
        train.addWagon(wagon);

        Cargo cargo1 = new Cargo(1, new Weight(100), CargoType.BULK);
        assertThrows(IllegalArgumentException.class, () -> wagon.addCargo(cargo1));

        Cargo cargo2 = new Cargo(1, new Weight(300_000), CargoType.DANGEROUS);
        assertThrows(IllegalArgumentException.class, () -> wagon.addCargo(cargo2));

        Cargo cargo3 = new Cargo(1, new Weight(100), CargoType.DANGEROUS);
        assertTrue(wagon.addCargo(cargo3));
        assertTrue(wagon.getCargos().contains(cargo3));
        assertEquals(cargo3.getWeight(), wagon.getCurrentWeightCargo());
    }

    @Test
    void removeCargoTest() {
        FreightWagon wagon = new FreightWagon(CargoType.BULK, new Weight(200));
        train.addWagon(wagon);
        Weight initialWeightCargos = wagon.getCurrentWeightCargo();

        Cargo cargo = new Cargo(1, new Weight(100), CargoType.BULK);
        wagon.addCargo(cargo);

        wagon.removeCargo(cargo);
        assertFalse(wagon.getCargos().contains(cargo));
        assertEquals(initialWeightCargos, wagon.getCurrentWeightCargo());
    }

}