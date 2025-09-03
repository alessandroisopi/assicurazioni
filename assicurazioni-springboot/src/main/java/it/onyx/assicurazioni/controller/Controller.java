package it.onyx.assicurazioni.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/polizza")
public class Controller {

    @PostMapping(path = "/insert", produces = "application/json", consumes = "application/json")
    public String index() {
        return "Hello World";
    }
}
