package it.onyx.assicurazioni.controller;

import it.onyx.assicurazioni.dto.CostoPolizzaDTO;
import it.onyx.assicurazioni.groupvalidator.OnCreate;
import it.onyx.assicurazioni.groupvalidator.OnUpdate;
import it.onyx.assicurazioni.service.CostoPolizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/costoPolizza")
public class CostoPolizzaController {

    @Autowired
    private CostoPolizzaService costoPolizzaService;

    @PostMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity<CostoPolizzaDTO> insert(@Validated(OnCreate.class) @RequestBody CostoPolizzaDTO dto) {
        CostoPolizzaDTO result = costoPolizzaService.insert(dto);
        if (result != null) {
            return ResponseEntity.status(HttpStatus.OK).body(result);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping(path = "/getAll", produces = "application/json")
    public ResponseEntity<List<CostoPolizzaDTO>> getAll() {
        List<CostoPolizzaDTO> result = costoPolizzaService.getAll();
        if (!result.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK).body(result);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping(path = "/getById/{id}", produces = "application/json")
    public ResponseEntity<CostoPolizzaDTO> getById(@PathVariable("id") long id) {
        CostoPolizzaDTO result = costoPolizzaService.getById(id);
        if (result != null) {
            return ResponseEntity.status(HttpStatus.OK).body(result);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PutMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity<CostoPolizzaDTO> update(@Validated(OnUpdate.class) @RequestBody CostoPolizzaDTO dto) {
        CostoPolizzaDTO result = costoPolizzaService.update(dto);
        if (result != null) {
            return ResponseEntity.status(HttpStatus.OK).body(result);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
