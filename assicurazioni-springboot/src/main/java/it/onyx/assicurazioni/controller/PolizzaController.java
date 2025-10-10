package it.onyx.assicurazioni.controller;

import it.onyx.assicurazioni.dto.PolizzaDTO;
import it.onyx.assicurazioni.dtoNoEntity.PolizzaInsert;
import it.onyx.assicurazioni.groupvalidator.OnCreate;
import it.onyx.assicurazioni.groupvalidator.OnUpdate;
import it.onyx.assicurazioni.service.PolizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping(path = "/polizza")
public class PolizzaController {

    @Autowired
    private PolizzaService polizzaService;

    @PostMapping(produces = "application/json", consumes = "application/json")
    public ResponseEntity<PolizzaDTO> insert(@Validated(OnCreate.class) @RequestBody PolizzaDTO dto) {
        PolizzaDTO polizzaDTO = polizzaService.insert(dto); //avvia l'insert e salva il risultato
        if (polizzaDTO != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(polizzaDTO);  //se l'insert va a buon fine torna lo stato ok e l'oggetto completo
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();   //se qualcosa non va torna lo stato bad request
        }
    }

    @GetMapping(path = "/getAll", produces = "application/json")
    public ResponseEntity<List<PolizzaDTO>> getAll() {
        List<PolizzaDTO> polizzaDTO = polizzaService.getAll();  //ottiene la lista con i risltati
        if (!polizzaDTO.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK).body(polizzaDTO);   //se c'è almeno un risultato torna lo stato ok e la lista
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build(); //se non trova nulla torna lo stato not found
        }
    }

    @GetMapping(path = "/getById/{id}", produces = "application/json")
    public ResponseEntity<PolizzaDTO> getById(@PathVariable("id") long id) {
        PolizzaDTO polizzaDTO = polizzaService.getById(id);  //ottiene il risultato
        if (polizzaDTO != null) {
            return ResponseEntity.status(HttpStatus.OK).body(polizzaDTO);   //se c'è un riscontro torna lo stato ok e l'oggetto
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build(); //se non è nulla torna lo stato not found
        }
    }

    @PutMapping(produces = "application/json", consumes = "application/json")
    public ResponseEntity<PolizzaDTO> update(@Validated(OnUpdate.class) @RequestBody PolizzaDTO dto) {
        PolizzaDTO polizzaDTO = polizzaService.update(dto); //esegue update
        if (polizzaDTO != null) {
            return ResponseEntity.status(HttpStatus.OK).body(polizzaDTO);   //se c'è un risultato torna lo stato ok e il nuovo oggetto modificato
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build(); //se non trova l'oggetto o ci sono stati problemi torna lo stato not found
        }
    }

    @DeleteMapping(path = "/{id}", produces = "application/json")
    public ResponseEntity<Void> delete(@PathVariable("id") long id) {
        boolean result = polizzaService.delete(id);  //esegue la delete
        if (result) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();    //se torna true la delete è andata bene e torna lo stato no content
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();     //se non trova l'oggetto da eliminare torna lo stato not found
        }
    }

    @GetMapping(path = "/verificaStatoPolizza/{cd}")
    public ResponseEntity<Boolean> verificaStatoPolizza(@PathVariable("cd") String cd) {
        if (polizzaService.verificaStatoPolizza(cd)) {
            return ResponseEntity.status(HttpStatus.OK).body(true);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(false);
    }

    @PostMapping(path = "/insert", consumes = "application/json", produces = "application/json")
    public ResponseEntity<PolizzaDTO> insertControllata(@RequestBody PolizzaInsert dto) throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body(polizzaService.insertControllata(dto));
    }

    @GetMapping(path = "/getByParams", consumes = "application/json", produces = "application/json")
    public ResponseEntity<List<PolizzaDTO>> getByParams(@RequestBody PolizzaDTO dto) {
        return ResponseEntity.status(HttpStatus.OK).body(polizzaService.getByParams(dto));
    }
}
