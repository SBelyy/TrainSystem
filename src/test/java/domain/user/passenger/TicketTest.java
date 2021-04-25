package domain.user.passenger;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TicketTest {

    @Test
    public void constructorTest() {
        assertThrows(IllegalArgumentException.class, () -> new Ticket(-1, TicketType.DISCOUNT));
    }

}