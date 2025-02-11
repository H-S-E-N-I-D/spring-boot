package com.shdinesh.springcrud.controller;

import com.shdinesh.springcrud.service.OptimisticTicketBookingService;
import com.shdinesh.springcrud.service.PessimisticTicketBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/tickets")
public class TicketsController {

    @Autowired
    private OptimisticTicketBookingService optimisticTicketBookingService;

    @Autowired
    private PessimisticTicketBookingService pessimisticTicketBookingService;

    @GetMapping
    public String welcome() {
        return "Welcome to Ticket Store";
    }

    @GetMapping("/optimistic/{ticketId}")
    public String testOptimistic(@PathVariable Integer ticketId) throws InterruptedException {
        optimisticTicketBookingService.bookTicketsOptimistic(ticketId);
        return "Optimistic locking test started! Check logs for results.";
    }

    @GetMapping("/pessimistic/{ticketId}")
    public String testPessimistic(@PathVariable Integer ticketId) throws InterruptedException {
        pessimisticTicketBookingService.bookTicketsOptimistic(ticketId);
        return "Pessimistic locking test started! Check logs for results.";
    }

}
