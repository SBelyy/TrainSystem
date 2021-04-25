package domain.train.wagon;

import domain.cargo.Cargo;
import domain.cargo.CargoType;
import domain.cargo.Weight;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FreightWagonTest {

    @Test
    void putCargo() {
        FreightWagon wagon = new FreightWagon( CargoType.DANGEROUS, new Weight(200_000));

        Cargo cargo1 = new Cargo(1, new Weight(100), CargoType.BULK);
        assertFalse(wagon.addCargo(cargo1));

        Cargo cargo2 = new Cargo(1, new Weight(300_000), CargoType.DANGEROUS);
        assertFalse(wagon.addCargo(cargo2));

        Cargo cargo3 = new Cargo(1, new Weight(100), CargoType.DANGEROUS);
        assertTrue(wagon.addCargo(cargo3));
        assertTrue(wagon.getCargos().contains(cargo3));
        assertEquals(cargo3.getWeight(), wagon.getCurrentWeightCargo());
    }

    @Test
    void removeCargo() {
        FreightWagon wagon = new FreightWagon( CargoType.BULK, new Weight(200));
        Weight initialWeightCargos = wagon.getCurrentWeightCargo();

        Cargo cargo = new Cargo(1, new Weight(100), CargoType.BULK);
        wagon.addCargo(cargo);
        assertTrue(wagon.getCargos().contains(cargo));

        wagon.removeCargo(cargo);
        assertFalse(wagon.getCargos().contains(cargo));
        assertEquals(initialWeightCargos, wagon.getCurrentWeightCargo());
    }

    @Test
    void inspection() {
        FreightWagon wagon = new FreightWagon(CargoType.BULK, new Weight(200));

        Cargo cargo = new Cargo(1, new Weight(100), CargoType.BULK);
        wagon.addCargo(cargo);

        //wagon.setTypeTransportedCargo(CargoType.DANGEROUS);
        //wagon.inspection();

        assertTrue(wagon.getCargos().isEmpty());
    }

}