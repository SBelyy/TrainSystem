package domain.train.wagon;

import domain.user.Age;
import domain.user.passenger.Passenger;
import domain.user.passenger.Ticket;
import domain.user.passenger.TicketType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PassengerWagonTest {

    @Test
    void passengerEnters() {
        PassengerWagon wagon = new PassengerWagon( 1);

        Passenger passengerIncorrectNumber = getPassengerForTicket(new Ticket(2, TicketType.REGULAR));
        assertFalse(wagon.addPassenger(passengerIncorrectNumber));

        Passenger passengerIncorrectType = getPassengerForTicket(new Ticket(1, TicketType.INVALID));
        assertFalse(wagon.addPassenger(passengerIncorrectType));

        Passenger passengerCorrect = getPassengerForTicket(new Ticket(1, TicketType.REGULAR));
        assertTrue(wagon.addPassenger(passengerCorrect));
        assertTrue(wagon.getPassengers().contains(passengerCorrect));
        assertEquals(0, wagon.getAvailableSeats());

        Passenger passengerCorrect2 = getPassengerForTicket(new Ticket(1, TicketType.REGULAR));
        assertFalse(wagon.addPassenger(passengerCorrect2));
    }

    @Test
    void passengersGetsOut() {
        PassengerWagon wagon = new PassengerWagon( 30);
        int initialAvailableSeats = wagon.getAvailableSeats();

        Passenger passenger = getPassengerForTicket(new Ticket(1, TicketType.REGULAR));
        wagon.addPassenger(passenger);

        wagon.passengersGetsOut(passenger);
        assertFalse(wagon.getPassengers().contains(passenger));
        assertEquals(initialAvailableSeats, wagon.getAvailableSeats());
    }

    @Test
    void inspection() {
        PassengerWagon wagon = new PassengerWagon( 30);

        Passenger passenger = getPassengerForTicket(new Ticket(1, TicketType.REGULAR));
        wagon.addPassenger(passenger);

        passenger.addTicket(new Ticket(1, TicketType.INVALID));
        //wagon.inspection();
        assertFalse(wagon.getPassengers().contains(passenger));
    }

    private Passenger getPassengerForTicket(Ticket ticket) {
        return new Passenger("Ivan", "Ivanov",
                Age.valueOf(18), ticket);
    }

}