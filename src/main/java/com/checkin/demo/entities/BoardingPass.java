package com.checkin.demo.entities;

import com.checkin.demo.entities.dto.TicketDTO;

import javax.persistence.*;
import java.util.UUID;

@Entity
public class BoardingPass {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private UUID idClient;
    private UUID idFlight;
    private String sitClass;
    private int seat;
    private String gate;

    public BoardingPass(TicketDTO ticket, int seat, String gate) {
        this.gate = gate;
        this.seat = seat;
        this.idClient = ticket.idClient;
        this.idFlight = ticket.idFlight;
        this.sitClass = ticket.sitClass;
    }

    public BoardingPass() {
    }



    public void setSeat(int seat) {
        this.seat = seat;
    }

    public void setSitClass(String sitClass) {
        this.sitClass = sitClass;
    }

    public void setGate(String gate) {
        this.gate = gate;
    }


    public int getSeat() {
        return seat;
    }

    public String getGate() {
        return gate;
    }

    public String getSitClass() {
        return sitClass;
    }
}
