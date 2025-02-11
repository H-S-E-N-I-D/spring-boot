package com.shdinesh.springcrud.repo;

import com.shdinesh.springcrud.model.TicketStore;
import jakarta.persistence.LockModeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface TicketStoreRepository extends JpaRepository<TicketStore, Integer> {

    @Lock(LockModeType.PESSIMISTIC_WRITE)
    @Query("SELECT ts FROM TicketStore ts WHERE ts.id= :ticketId")
    Optional<TicketStore> findByIdAndLock(Integer ticketId);
}
