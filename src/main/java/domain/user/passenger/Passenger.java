package domain.user.passenger;

import domain.user.Age;
import domain.user.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Passenger extends User {

    private final List<Ticket> ticketList;

    public Passenger(String firstName, String lastName, Age age, Ticket... tickets) {
        super(firstName, lastName, age);
        ticketList = new ArrayList<>();
        ticketList.addAll(Arrays.asList(tickets));
    }

    public List<Ticket> getTicketList() {
        return new ArrayList<>(ticketList);
    }

    public void addTicket(Ticket ticket) {
        ticketList.add(ticket);
    }

    @Override
    public String toString() {
        return "Passenger name: " + getFirstName() +
                " " + getLastName() +
                "\n" + getAge() +
                "\n" + ticketList;
    }

}
