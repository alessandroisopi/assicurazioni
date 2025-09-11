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
        List<TipoPolizzaDTO> result = tipoPolizzaService.getAll();  //ottiene i risultati
        if (!result.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK).body(result);   //se c'è almeno un risultato torna lo stato ok e l'oggetto
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build(); //se non c'è nulla torna lo stato not found
        }
    }

    @GetMapping(path = "/getById/{id}", produces = "application/json")
    public ResponseEntity<TipoPolizzaDTO> getById(@PathVariable(name = "id") long id) {
        TipoPolizzaDTO result = tipoPolizzaService.getById(id);     //ottiene il risultato
        if (result != null) {
            return ResponseEntity.status(HttpStatus.OK).body(result);   //se c'è torna lo stato ok e l'oggetto
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build(); //se non c'è torna lo stato not found
        }
    }

    @PutMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity<TipoPolizzaDTO> update(@Validated(OnUpdate.class) @RequestBody TipoPolizzaDTO dto) {
        TipoPolizzaDTO result = tipoPolizzaService.update(dto); //esegue update e ottiene il risultato
        if (result != null) {
            return ResponseEntity.status(HttpStatus.OK).body(result);   //se è andato bene torna lo stato ok e l'oggetto modificato
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build(); //se non è stato trovato torna lo stato not found
        }
    }
}
