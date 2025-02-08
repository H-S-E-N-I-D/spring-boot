package com.shdinesh.springcrud.entity;

import javax.persistence.*;

/*
Procedure Method 1
*/

@NamedStoredProcedureQueries(
        @NamedStoredProcedureQuery(
                name = "updateTicketCount",
                procedureName = "update_ticket_count",
                parameters = {
                        @StoredProcedureParameter(name = "ticketId", mode = ParameterMode.IN, type = Integer.class),
                        @StoredProcedureParameter(name = "quantity", mode = ParameterMode.IN, type = Integer.class)
                }
        )
)
@Entity
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private Double price;
    @Column(name = "remaining_qty")
    private Integer qty;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }
}
