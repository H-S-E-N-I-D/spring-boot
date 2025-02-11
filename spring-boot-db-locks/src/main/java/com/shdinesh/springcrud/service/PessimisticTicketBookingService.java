package com.shdinesh.springcrud.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PessimisticTicketBookingService {

    @Autowired
    private MovieTicketBookingService ticketBookingService;

    public void bookTicketsOptimistic(Integer ticketId) throws InterruptedException {
        // 2 threads
        Thread th1 = new Thread(() -> {
            try {
                ticketBookingService.bookTicketsPessimistic(ticketId);
            } catch (RuntimeException ex) {
                System.out.println(Thread.currentThread().getName() + " booking failed : " + ex.getMessage());
            }
        });

        Thread th2 = new Thread(() -> {
            try {
                ticketBookingService.bookTicketsPessimistic(ticketId);
            } catch (RuntimeException ex) {
                System.out.println(Thread.currentThread().getName() + " booking failed : " + ex.getMessage());
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
