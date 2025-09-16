package it.onyx.assicurazioni.controller;

import it.onyx.assicurazioni.dto.StatoPolizzaDTO;
import it.onyx.assicurazioni.groupvalidator.OnCreate;
import it.onyx.assicurazioni.groupvalidator.OnUpdate;
import it.onyx.assicurazioni.service.StatoPolizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/statoPolizza")
public class StatoPolizzaController {

    @Autowired
    private StatoPolizzaService statoPolizzaService;

    @PostMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity<StatoPolizzaDTO> post(@Validated(OnCreate.class) @RequestBody StatoPolizzaDTO dto) {
        StatoPolizzaDTO statoPolizzaDTO = statoPolizzaService.insert(dto);
        if (statoPolizzaDTO != null) {
            return ResponseEntity.status(HttpStatus.OK).body(statoPolizzaDTO);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping(path = "/getAll", produces = "application/json")
    public ResponseEntity<List<StatoPolizzaDTO>> getAll() {
        List<StatoPolizzaDTO> list = statoPolizzaService.getAll();
        if (!list.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK).body(list);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping(path = "/getById/{id}", produces = "application/json")
    public ResponseEntity<StatoPolizzaDTO> getById(@PathVariable("id") long id) {
        StatoPolizzaDTO statoPolizzaDTO = statoPolizzaService.getById(id);
        if (statoPolizzaDTO != null) {
            return ResponseEntity.status(HttpStatus.OK).body(statoPolizzaDTO);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PutMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity<StatoPolizzaDTO> update(@Validated(OnUpdate.class) @RequestBody StatoPolizzaDTO dto) {
        StatoPolizzaDTO statoPolizzaDTO = statoPolizzaService.update(dto);
        if (statoPolizzaDTO != null) {
            return ResponseEntity.status(HttpStatus.OK).body(statoPolizzaDTO);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") long id) {
        boolean result = statoPolizzaService.delete(id);
        if (result) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } else  {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
