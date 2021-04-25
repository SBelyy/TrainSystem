package domain.train.wagon;

import domain.user.passenger.Passenger;
import domain.user.passenger.Ticket;
import domain.user.passenger.TicketType;

import java.util.ArrayList;
import java.util.List;

import static com.google.common.base.Preconditions.checkArgument;

public class PassengerWagon extends Wagon {

    private final int maxSeatsNumber;
    private final List<Passenger> passengers;

    private int availableSeats;

    public PassengerWagon(int maxSeatsNumber) {
        checkArgument(maxSeatsNumber >= 0, "maxSeatsNumber must be positive");
        this.maxSeatsNumber = maxSeatsNumber;
        availableSeats = maxSeatsNumber;
        passengers = new ArrayList<>();
    }

    public boolean addPassenger(Passenger passenger) {
        checkArgument(availableSeats >= 0, "AvailableSeats must be positive");

        checkArgument(availableSeats != 0, "There is no seat available");

        List<Ticket> tickets = passenger.getTicketList();
        for (Ticket ticket : tickets) {
            if (getNumber() == ticket.getWaggonNumber() &&
                    ticket.getTicketType() != TicketType.INVALID) {
                passengers.add(passenger);
                availableSeats--;
                return true;
            }
        }

        return false;
    }

    public void passengersGetsOut(Passenger passenger) {
        if (passengers.contains(passenger)) {
            passengers.remove(passenger);
            availableSeats++;
        }
    }

    public int getMaxSeatsNumber() {
        return maxSeatsNumber;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public List<Passenger> getPassengers() {
        return new ArrayList<>(passengers);
    }

}
