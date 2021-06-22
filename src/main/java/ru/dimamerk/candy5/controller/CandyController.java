package ru.dimamerk.candy5.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.dimamerk.candy5.model.CandyType;
import ru.dimamerk.candy5.service.QueueService;

@RestController
@RequestMapping("/candy")
public class CandyController {

    private QueueService queueService;

    public CandyController(QueueService queueService) {
        this.queueService = queueService;
    }

    @GetMapping("/chocolate")
    public ResponseEntity addChocolate() {
        queueService.pushToQueue(CandyType.CHOCOLATE);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/caramel")
    public ResponseEntity addCaramel() {
        queueService.pushToQueue(CandyType.CARAMEL);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/log")
    public ResponseEntity logQueue() {
        queueService.logQueue();
        return new ResponseEntity(HttpStatus.OK);
    }

}
