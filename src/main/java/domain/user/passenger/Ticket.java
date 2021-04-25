package domain.user.passenger;

import java.util.Objects;
import java.util.UUID;

import static com.google.common.base.Preconditions.*;

public class Ticket {

    private final String ticketNumber;
    private final int waggonNumber;
    private final TicketType ticketType;

    public Ticket(int waggonNumber, TicketType ticketType) {
        checkArgument(waggonNumber > 0, "The wagon number on the ticket must be positive");
        this.waggonNumber = waggonNumber;
        this.ticketType = ticketType;
        ticketNumber = UUID.randomUUID().toString();
    }

    public String getTicketNumber() {
        return ticketNumber;
    }

    public int getWaggonNumber() {
        return waggonNumber;
    }

    public TicketType getTicketType() {
        return ticketType;
    }

    @Override
    public String toString() {
        return "Ticket {" +
                "NumberTicket = " + ticketNumber +
                ", NumberTrain = " + waggonNumber +
                ", TypeTicket = " + ticketType +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ticket ticket = (Ticket) o;
        return waggonNumber == ticket.waggonNumber && ticketType == ticket.ticketType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(waggonNumber, ticketType);
    }
}
