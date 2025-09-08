package it.onyx.assicurazioni.controller;

import it.onyx.assicurazioni.dto.PolizzaDTO;
import it.onyx.assicurazioni.groupvalidator.OnCreate;
import it.onyx.assicurazioni.groupvalidator.OnUpdate;
import it.onyx.assicurazioni.service.PolizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/polizza")
public class PolizzaController {

    @Autowired
    private PolizzaService polizzaService;

    @PostMapping(path = "/insert", produces = "application/json", consumes = "application/json")
    public ResponseEntity<PolizzaDTO> insert(@Validated(OnCreate.class) @RequestBody PolizzaDTO dto) {
        PolizzaDTO polizzaDTO = polizzaService.insert(dto);
        if (polizzaDTO != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(polizzaDTO);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping(path = "/getAll", produces = "application/json")
    public ResponseEntity<List<PolizzaDTO>> getAll() {
        List<PolizzaDTO> polizzaDTO = polizzaService.getAll();
        if (!polizzaDTO.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK).body(polizzaDTO);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping(path = "/getById/{id}", produces = "application/json")
    public ResponseEntity<PolizzaDTO> getById(@PathVariable("id") long id) {
        PolizzaDTO polizzaDTO = polizzaService.getById(id);
        if (polizzaDTO != null) {
            return ResponseEntity.status(HttpStatus.OK).body(polizzaDTO);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PutMapping(path = "/update", produces = "application/json", consumes = "application/json")
    public ResponseEntity<PolizzaDTO> update(@Validated(OnUpdate.class) @RequestBody PolizzaDTO dto) {
        PolizzaDTO polizzaDTO = polizzaService.update(dto);
        if (polizzaDTO != null) {
            return ResponseEntity.status(HttpStatus.OK).body(polizzaDTO);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @DeleteMapping(path = "/delete/{id}", produces = "application/json")
    public ResponseEntity<Void> delete(@PathVariable("id") long id) {
        boolean result = polizzaService.delete(id);
        if (result) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
