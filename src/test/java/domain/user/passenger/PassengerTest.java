package domain.user.passenger;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class PassengerTest {

    @Test
    public void addTicketTest() {
        Ticket ticketOne = new Ticket(1, TicketType.REGULAR);
        Passenger passenger = new Passenger("Vasia", "Pupkin",
                LocalDate.EPOCH, ticketOne);

        Ticket ticketTwo = new Ticket(1, TicketType.REGULAR);
        passenger.addTicket(ticketTwo);

        assertTrue(passenger.getTicketList().contains(ticketOne));
        assertTrue(passenger.getTicketList().contains(ticketTwo));
    }

}