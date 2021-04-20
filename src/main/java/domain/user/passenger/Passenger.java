package domain.user.passenger;

import domain.user.Age;
import domain.user.User;

public class Passenger extends User {

    private Ticket ticket;

    public Passenger(String firstName, String lastName, Age age, Ticket ticket) {
        super(firstName, lastName, age);
        this.ticket = ticket;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    @Override
    public String toString() {
        return "Passenger name: " + getFirstName() +
                " " + getLastName() +
                "\n" + getAge() +
                "\n" + ticket;
    }

}
