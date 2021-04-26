package domain.train.wagon;

import domain.train.Train;
import domain.user.driver.LicenseType;
import domain.user.driver.TrainDriver;
import domain.user.passenger.Passenger;
import domain.user.passenger.Ticket;
import domain.user.passenger.TicketType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class PassengerWagonTest {

    private Train train;

    @BeforeEach
    public void before() {
        TrainDriver driver = new TrainDriver("Vasia", "Pupkin",
                LocalDate.of(2000, 3, 12), LicenseType.VALID);
        Locomotive locomotive = new Locomotive(driver);
        train = new Train(locomotive, 1);
    }

    @Test
    void addPassengerTest() {
        PassengerWagon wagon = new PassengerWagon(1);
        train.addWagon(wagon);

        Passenger invalidPassenger = getPassengerForTicket(new Ticket(wagon.getNumber(), TicketType.INVALID));
        assertFalse(wagon.addPassenger(invalidPassenger));

        Passenger invalidPassenger2 = getPassengerForTicket(new Ticket(wagon.getNumber() - 1, TicketType.INVALID));
        assertFalse(wagon.addPassenger(invalidPassenger2));

        Passenger validPassenger = getPassengerForTicket(new Ticket(wagon.getNumber(), TicketType.REGULAR));
        assertTrue(wagon.addPassenger(validPassenger));
        assertTrue(wagon.getPassengers().contains(validPassenger));
    }

    @Test
    void passengersGetsOut() {
        PassengerWagon wagon = new PassengerWagon( 30);
        train.addWagon(wagon);
        int initialAvailableSeats = wagon.getAvailableSeats();

        Passenger passenger = getPassengerForTicket(new Ticket(wagon.getNumber(), TicketType.REGULAR));
        wagon.addPassenger(passenger);

        wagon.passengersGetsOut(passenger);
        assertFalse(wagon.getPassengers().contains(passenger));
        assertEquals(initialAvailableSeats, wagon.getAvailableSeats());
    }

    private Passenger getPassengerForTicket(Ticket ticket) {
        return new Passenger("Ivan", "Ivanov",
                LocalDate.of(2000, 3, 15), ticket);
    }

}