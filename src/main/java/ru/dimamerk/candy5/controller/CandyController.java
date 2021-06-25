package ru.dimamerk.candy5.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.dimamerk.candy5.manager.CandyHeap;
import ru.dimamerk.candy5.model.CandyCaramel;
import ru.dimamerk.candy5.model.CandyChocolate;

@RestController
@RequestMapping("/candy")
public class CandyController {

    private CandyHeap candyHeap;

    @Autowired
    public void setCandyHeap(CandyHeap candyHeap) {
        this.candyHeap = candyHeap;
    }

    @GetMapping("/chocolate")
    public ResponseEntity addChocolate() {
        candyHeap.put(new CandyChocolate());

        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/caramel")
    public ResponseEntity addCaramel() {
        candyHeap.put(new CandyCaramel());

        return new ResponseEntity(HttpStatus.OK);
    }

}
