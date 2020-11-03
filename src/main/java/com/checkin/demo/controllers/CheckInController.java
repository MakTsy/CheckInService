package com.checkin.demo.controllers;



import com.checkin.demo.services.CheckInService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
public class CheckInController {
    private final CheckInService checkInService;

    @Autowired
    public CheckInController(CheckInService checkInService) {
        this.checkInService = checkInService;
    }

    @PostMapping("/check_in")
    public ResponseEntity<String> checkInClient(@RequestParam("ticket_id") UUID id) {
        UUID uuid = this.checkInService.checkInClient(id);
        return new ResponseEntity<String>(String.valueOf(uuid), HttpStatus.OK);

    }

    @RequestMapping(value = "/getPassengers", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<String> sendFlights() {
        Gson json = new Gson();
        String ans = json.toJson(this.checkInService.getAllPassengers());
        System.out.println(ans);
        return new ResponseEntity<String>(ans, HttpStatus.OK);
    }


}
