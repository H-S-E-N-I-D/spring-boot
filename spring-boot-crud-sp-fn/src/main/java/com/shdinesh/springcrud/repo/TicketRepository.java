package com.shdinesh.springcrud.repo;

import com.shdinesh.springcrud.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Integer> {

    @Procedure(name = "updateTicketCount")
    void updateTickets(@Param("ticketId") int ticketId, @Param("quantity") int ticketCount);

    /*
    Procedure Method 2
    */
    @Procedure(procedureName = "update_ticket_count")
    void updateTicketsV2(int ticketId, int ticketCount);

    /*
    Function call
    */
    @Query(value = "SELECT calculate_ticket_price(:ticketId)", nativeQuery = true)
    Double calculateTicketPrice(int ticketId);
}
