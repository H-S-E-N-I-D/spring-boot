package com.shdinesh.springcrud.service;

import com.shdinesh.springcrud.entity.Ticket;
import com.shdinesh.springcrud.repo.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TicketService {

    @Autowired
    private TicketRepository ticketRepository;

    public Ticket updateTickets(int ticketId, int ticketCount) {
        ticketRepository.updateTickets(ticketId, ticketCount);
        return ticketRepository.findById(ticketId).get();

    }

    public Ticket updateTicketsV2(int ticketId, int ticketCount) {
        ticketRepository.updateTicketsV2(ticketId, ticketCount);
        return ticketRepository.findById(ticketId).get();

    }

    public Double calculateTicketPrice(int ticketId) {
        return ticketRepository.calculateTicketPrice(ticketId);
    }
}
