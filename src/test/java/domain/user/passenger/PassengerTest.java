package domain.user.passenger;

import domain.user.Age;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PassengerTest {

    @Test
    public void addTicketTest() {
        Ticket ticketOne = new Ticket(1, TicketType.REGULAR);
        Passenger passenger = new Passenger("Vasia", "Pupkin",
                Age.valueOf(18), ticketOne);

        Ticket ticketTwo = new Ticket(1, TicketType.REGULAR);
        passenger.addTicket(ticketTwo);

        assertTrue(passenger.getTicketList().contains(ticketOne));
        assertTrue(passenger.getTicketList().contains(ticketTwo));
    }

}