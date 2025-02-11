package com.shdinesh.springcrud.service;

import com.shdinesh.springcrud.model.TicketStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OptimisticTicketBookingService {

    @Autowired
    private MovieTicketBookingService ticketBookingService;

    public void bookTicketsOptimistic(Integer ticketId) throws InterruptedException {
        // 2 threads
        Thread th1 = new Thread(() -> {
            try {
                System.out.println(Thread.currentThread().getName() + " is attempting to book the ticket");
                TicketStore ticketStore = ticketBookingService.bookTicketsOptimistic(ticketId);
                System.out.println(Thread.currentThread().getName() + " successfully booked the ticket with version " + ticketStore.getVersion());
            } catch (Exception ex) {
                System.out.println(Thread.currentThread().getName() + " failed : " + ex.getMessage());
            }
        });

        Thread th2 = new Thread(() -> {
            try {
                System.out.println(Thread.currentThread().getName() + " is attempting to book the ticket");
                TicketStore ticketStore = ticketBookingService.bookTicketsOptimistic(ticketId);
                System.out.println(Thread.currentThread().getName() + " successfully booked the ticket with version " + ticketStore.getVersion());
            } catch (Exception ex) {
                System.out.println(Thread.currentThread().getName() + " failed : " + ex.getMessage());
            }
        });

        th1.setName("MovieTicketBookingThread-1");
        th2.setName("MovieTicketBookingThread-2");
        th1.start();
        th2.start();
        th1.join();
        th2.join();
    }
}
