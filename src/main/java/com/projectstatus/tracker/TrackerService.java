package com.projectstatus.tracker;

import com.projectstatus.tracker.pojo.Status;
import com.projectstatus.tracker.pojo.Ticket;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.*;

@Service
public class TrackerService {
    List<Ticket> ticketList = new ArrayList<>();

    public List<Ticket> getTickets() {
        /*List<Ticket> ticketList = Arrays.asList(
                new Ticket("1234", new Date(), "First Ticket - Eventually, I want to convert the list to comma delimeted string. I would like to check if the item is the last element. So I must loop by index first.", "Raju",  "Kishore", Status.InProgress),
                new Ticket("5648", new Date(), "Second Ticket", "Sudhakar",  "Vishnu", Status.InProgress),
                new Ticket("2135", new Date(), "Third Ticket", "Chandra",  "Phani", Status.New),
                new Ticket("8964", new Date(), "Fourth Ticket", "Deepa",  "Vijay", Status.InProgress),
                new Ticket("4586", new Date(), "Fifth Ticket", "Ragini",  "Akash", Status.Closed)
        );*/

        return ticketList;
    }

    public void saveTicket(Ticket ticket) {
        Optional<Ticket> result = getTicket(ticket.getTicketNumber());
        if(result.isPresent()) {
            deleteTicket(ticket.getTicketNumber());
        }
        ticketList.add(ticket);
    }

    public void deleteTicket(String ticketNumber) {
        ticketList.removeIf(t -> t.getTicketNumber().equalsIgnoreCase(ticketNumber));
    }

    public Optional<Ticket> getTicket(String ticketNumber) {
        return ticketList.stream().filter(t -> t.getTicketNumber().equalsIgnoreCase(ticketNumber)).findFirst();
    }
}
