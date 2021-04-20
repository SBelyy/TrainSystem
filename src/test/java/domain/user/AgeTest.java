package domain.user;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AgeTest {

    @Test
    void valueOf() {
        assertThrows(IllegalArgumentException.class, () -> Age.valueOf(-1));
        assertThrows(IllegalArgumentException.class, () -> Age.valueOf(127));
    }

    @Test
    void intValue() {
        Age age = Age.valueOf(10);
        assertEquals(10, age.intValue());
    }

}