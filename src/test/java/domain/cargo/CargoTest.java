package domain.cargo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CargoTest {

    @Test
    public void constructorTest() {
        int number = 1;
        Weight weight = new Weight(1234);
        CargoType type = CargoType.BULK;

        Cargo cargo = new Cargo(number, weight, type);

        assertEquals(number, cargo.getNumber());
        assertEquals(weight, cargo.getWeight());
        assertEquals(type, cargo.getTypeCargo());
    }

}