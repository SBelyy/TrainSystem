package domain.user.passenger;

import domain.user.Age;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PassengerTest {

    @Test
    public void settersTest() {
        Ticket ticket = new Ticket(2, TicketType.DISCOUNT);
        Passenger passenger = new Passenger("Sashko", "Belly",
                Age.valueOf(23), ticket);

        assertEquals(23, passenger.getAge().intValue());
        assertEquals(ticket, passenger.getTicket());

        Ticket newTicket = new Ticket(3, TicketType.REGULAR);
        Age newAge = Age.valueOf(24);
        passenger.setTicket(newTicket);
        passenger.setAge(newAge);

        assertEquals(24, passenger.getAge().intValue());
        assertEquals(newTicket, passenger.getTicket());
    }

}