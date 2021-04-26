package domain.cargo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

class WeightTest {

    private Weight weight;

    @BeforeEach
    public void before() {
        weight = new Weight(234_050F);
    }

    @Test
    public void constructorTest() {
        assertThrows(IllegalArgumentException.class, () -> new Weight(-1F));
    }

    @Test
    public void addTest() {
        Weight addedWeight = new Weight(50);
        Weight totalWeight = new Weight(234_100F);

        assertEquals(totalWeight, weight.add(addedWeight));
    }

    @Test
    public void subtractTest() {
        Weight subtractedWeight = new Weight(50);
        Weight totalWeight = new Weight(234_000F);

        assertEquals(totalWeight, weight.subtract(subtractedWeight));
    }

    @Test
    public void getGramsTest() {
        assertEquals(234_050F, weight.getGrams());
    }

    @Test
    public void getKiloTest() {
        assertEquals(234.050F, weight.getKilo());
    }

    @Test
    public void getTonTest() {
        assertEquals(0.234_050F, weight.getTon());
    }

}