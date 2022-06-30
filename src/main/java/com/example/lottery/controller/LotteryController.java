package com.example.lottery.controller;

import com.example.lottery.enity.Participan;
import com.example.lottery.enity.Winner;
import com.example.lottery.service.Service;
import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/lottery")
public class LotteryController {
    @Autowired
    private Service service;

    @GetMapping("/participant")
    private List<Participan> allParticipant(){
        return service.allParticipant();
    }

    @PostMapping("/participant")
    private ResponseEntity Participant(@RequestBody Participan participan){
        return service.participant(participan);
    }

    @GetMapping("/start")
    private ResponseEntity<Winner> startLottery() throws Exception {
        return service.lottery();
    }

    @GetMapping("/winners")
    private List<Winner> winners() throws Exception {
        return service.winner();
    }
}
