package domain.user.passenger;

import java.util.Objects;
import java.util.UUID;

import static com.google.common.base.Preconditions.*;

public class Ticket {

    private final String numberTicket;
    private final int numberTrain;
    private final TicketType typeTicket;

    public Ticket(int numberTrain, TicketType typeTicket) {
        checkArgument(numberTrain > 0, "Train number must be positive");
        this.numberTrain = numberTrain;
        this.typeTicket = typeTicket;
        numberTicket = UUID.randomUUID().toString();
    }

    public String getNumberTicket() {
        return numberTicket;
    }

    public int getNumberTrain() {
        return numberTrain;
    }

    public TicketType getTypeTicket() {
        return typeTicket;
    }

    @Override
    public String toString() {
        return "Ticket {" +
                "NumberTicket = " + numberTicket +
                ", NumberTrain = " + numberTrain +
                ", TypeTicket = " + typeTicket +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ticket ticket = (Ticket) o;
        return numberTrain == ticket.numberTrain && typeTicket == ticket.typeTicket;
    }

    @Override
    public int hashCode() {
        return Objects.hash(numberTrain, typeTicket);
    }
}
