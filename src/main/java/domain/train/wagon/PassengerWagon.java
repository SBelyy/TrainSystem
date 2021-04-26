package domain.train.wagon;

import domain.user.passenger.Passenger;
import domain.user.passenger.Ticket;
import domain.user.passenger.TicketType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static com.google.common.base.Preconditions.checkArgument;

public class PassengerWagon extends Wagon {

    private final int maxSeatsNumber;
    private final Set<Passenger> passengers;
    private final Logger logger = LoggerFactory.getLogger(PassengerWagon.class);

    public PassengerWagon(int maxSeatsNumber) {
        checkArgument(maxSeatsNumber >= 0, "maxSeatsNumber must be positive");
        this.maxSeatsNumber = maxSeatsNumber;
        passengers = new HashSet<>();
    }

    public boolean addPassenger(Passenger passenger) {
        checkArgument(getAvailableSeats() != 0, "There is no seat available");

        List<Ticket> tickets = passenger.getTicketList();
        for (Ticket ticket : tickets) {
            if (getNumber() == ticket.getWaggonNumber() &&
                    ticket.getTicketType() != TicketType.INVALID) {
                passengers.add(passenger);
                logger.debug("{} added to {}", passenger, this);
                ticket.setTicketType(TicketType.INVALID);
                return true;
            }
        }

        return false;
    }

    public void passengersGetsOut(Passenger passenger) {
        if (passengers.remove(passenger)) {
            logger.debug("{} removed from {}", passenger, this);
        }
    }

    public int getMaxSeatsNumber() {
        return maxSeatsNumber;
    }

    public int getAvailableSeats() {
        return maxSeatsNumber - passengers.size();
    }

    public List<Passenger> getPassengers() {
        return new ArrayList<>(passengers);
    }

    @Override
    public String toString() {
        return "PassengerWagon{" +
                "number=" + getNumber() +
                ", maxSeatsNumber=" + maxSeatsNumber +
                '}';
    }
}
