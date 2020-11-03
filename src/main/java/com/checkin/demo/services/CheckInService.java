package com.checkin.demo.services;

import com.checkin.demo.controllers.DataGetter;
import com.checkin.demo.entities.BoardingPass;
import com.checkin.demo.entities.Passenger;
import com.checkin.demo.entities.dto.TicketDTO;
import com.checkin.demo.repo.BoardingPassRepository;
import com.checkin.demo.repo.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

@Service
public class CheckInService {

    private final PassengerRepository passengerRepository;
    private final BoardingPassRepository boardingPassRepository;
    private final DataGetter dataGetter;


    @Autowired
    public CheckInService(PassengerRepository passengerRepository, BoardingPassRepository boardingPassRepository, DataGetter dataGetter) {
        this.passengerRepository = passengerRepository;
        this.boardingPassRepository = boardingPassRepository;
        this.dataGetter = dataGetter;
    }

    @Transactional
    public UUID checkInClient(UUID ticketId) {
        Passenger passenger = new Passenger();
        TicketDTO ticket = dataGetter.getTicket(ticketId);
        BoardingPass boardingPass = new BoardingPass(ticket, 21, "DefaultGate");
        this.boardingPassRepository.save(boardingPass);
        passenger.setBoardingPass(boardingPass);
        this.passengerRepository.save(passenger);
        return passenger.getPassangerId();
    }

    @Transactional
    public BoardingPass getBoardingPass(UUID id) {
        Passenger passenger = passengerRepository.findById(id).orElseThrow();
        return passenger.getBoardingPass();
    }

    @Transactional
    public List<Passenger> getAllPassengers() {
        return this.passengerRepository.findAll();
    }
}
