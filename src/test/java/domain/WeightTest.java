package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

class WeightTest {

    private Weight weight;

    @BeforeEach
    public void before() {
        weight = new Weight(234_050_345F);
    }

    @Test
    void constructorTest() {
        assertThrows(IllegalArgumentException.class, () -> new Weight(-1F));
    }

    @Test
    void getGramsTest() {
        assertEquals(234_050_345F, weight.getGrams());
    }

    @Test
    void getKiloTest() {
        assertEquals(234_050.345F, weight.getKilo());
    }

    @Test
    void getTonTest() {
        assertEquals(234.050_345F, weight.getTon());
    }

}