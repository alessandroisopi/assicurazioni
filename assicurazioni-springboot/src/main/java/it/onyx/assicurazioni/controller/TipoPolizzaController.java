package it.onyx.assicurazioni.controller;

import it.onyx.assicurazioni.dto.TipoPolizzaDTO;
import it.onyx.assicurazioni.groupvalidator.OnUpdate;
import it.onyx.assicurazioni.service.TipoPolizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(path = "/tipoPolizza")
public class TipoPolizzaController {
    @Autowired
    private TipoPolizzaService tipoPolizzaService;

    @GetMapping(path = "/getAll", produces = "application/json")
    public ResponseEntity<List<TipoPolizzaDTO>> getAll() {
        List<TipoPolizzaDTO> result = tipoPolizzaService.getAll();
        if (!result.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK).body(result);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping(path = "/getById/{id}", produces = "application/json")
    public ResponseEntity<TipoPolizzaDTO> getById(@PathVariable(name = "id") long id) {
        TipoPolizzaDTO result = tipoPolizzaService.getById(id);
        if (result != null) {
            return ResponseEntity.status(HttpStatus.OK).body(result);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PutMapping(path = "/update", consumes = "application/json", produces = "application/json")
    public ResponseEntity<TipoPolizzaDTO> update(@Validated(OnUpdate.class) @RequestBody TipoPolizzaDTO dto) {
        TipoPolizzaDTO result = tipoPolizzaService.update(dto);
        if (result != null) {
            return ResponseEntity.status(HttpStatus.OK).body(result);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
