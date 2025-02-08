package com.shdinesh.springcrud.controller;

import com.shdinesh.springcrud.entity.Ticket;
import com.shdinesh.springcrud.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/tickets")
public class TicketController {

    @Autowired
    private TicketService ticketService;

    @PutMapping("/update/{ticketId}/{qty}")
    public ResponseEntity<Ticket> updateTickets(@PathVariable Integer ticketId, @PathVariable Integer qty) {
        Ticket ticket = ticketService.updateTickets(ticketId, qty);
        return ResponseEntity.ok(ticket);
    }

    @PutMapping("v2/update/{ticketId}/{qty}")
    public ResponseEntity<Ticket> updateTicketsV2(@PathVariable Integer ticketId, @PathVariable Integer qty) {
        Ticket ticket = ticketService.updateTicketsV2(ticketId, qty);
        return ResponseEntity.ok(ticket);
    }

    @GetMapping("/total/{ticketId}")
    public ResponseEntity<Double> calculateTicketPrice(@PathVariable Integer ticketId) {
        Double ticketPrice = ticketService.calculateTicketPrice(ticketId);
        return ResponseEntity.ok(ticketPrice);
    }
}
