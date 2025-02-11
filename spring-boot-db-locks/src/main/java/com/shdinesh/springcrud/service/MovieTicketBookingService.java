package com.shdinesh.springcrud.service;

import com.shdinesh.springcrud.model.TicketStore;
import com.shdinesh.springcrud.repo.TicketStoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MovieTicketBookingService {

    @Autowired
    TicketStoreRepository ticketStoreRepository;

    @Transactional
    public TicketStore bookTicketsOptimistic(Integer ticketId) {
        //fetch the existing movie ticket by id
        TicketStore ticketStore = ticketStoreRepository.findById(ticketId)
                .orElseThrow(() -> new RuntimeException("Movie Ticket not found with id " + ticketId));

        System.out.println(Thread.currentThread().getName() + " Fetched ticket with version " + ticketStore.getVersion());

        if (ticketStore.getRemainingQty() == 0) {
            throw new RuntimeException("Movie Tickets already booked !");
        }
        //booking seat
        int remainingQty = ticketStore.getRemainingQty() - 1;
        ticketStore.setRemainingQty(remainingQty);
        //version check will occurs here
        return ticketStoreRepository.save(ticketStore);
    }


    @Transactional
    public void bookTicketsPessimistic(Integer ticketId) {
        System.out.println(Thread.currentThread().getName() + " is attempting to fetch the seat");
        //fetch the existing movie ticket by id
        TicketStore ticketStore = ticketStoreRepository.findByIdAndLock(ticketId)
                .orElseThrow(() -> new RuntimeException("Movie Ticket not found with id " + ticketId));

        System.out.println(Thread.currentThread().getName() + " acquired the lock for ticket id " + ticketId);

        if (ticketStore.getRemainingQty() == 0) {
            throw new RuntimeException("Movie Tickets already booked !");
        }
        //booking seat
        System.out.println(Thread.currentThread().getName() + " booking the ticket " + ticketId);
        int remainingQty = ticketStore.getRemainingQty() - 1;
        ticketStore.setRemainingQty(remainingQty);

        ticketStoreRepository.save(ticketStore);
        System.out.println(Thread.currentThread().getName() + " successfully booked the ticket with ID " + ticketId);


    }
}
