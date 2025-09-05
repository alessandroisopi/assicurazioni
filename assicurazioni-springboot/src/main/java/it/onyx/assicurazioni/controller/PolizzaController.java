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
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
//http.cat per i codici
@RestController
@RequestMapping(path = "/polizza")
public class PolizzaController {

    @Autowired
    private PolizzaService polizzaService;

    @PostMapping(path = "/insert", produces = "application/json", consumes = "application/json")
    public ResponseEntity<PolizzaDTO> insert(@Validated(OnCreate.class) @RequestBody PolizzaDTO dto) {
        try {
            PolizzaDTO polizzaDTO = polizzaService.insert(dto); //avviene l'insert
            if (polizzaDTO != null) {   //controlla cosa ha tornato la service
                return ResponseEntity.status(HttpStatus.CREATED).body(polizzaDTO);   //successo codice 201
            } else {    //altrimento torna un messaggio di errore
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();       //codice 400
            }
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());    //codice 500
        }
    }

    @GetMapping(path = "/getAll", produces = "application/json")
    public ResponseEntity<List<PolizzaDTO>> getAll() {
        try {
            List<PolizzaDTO> polizzaDTO = polizzaService.getAll();  //prende tutti gli elementi
            if  (!polizzaDTO.isEmpty()) {  //controlla se ci sono risultati
                return ResponseEntity.status(HttpStatus.OK).body(polizzaDTO);   //successo codice 200
            } else {    //altrimenti da messaggi di errore
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();     //codice 404
            }
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());    //codice 500
        }
    }

    @GetMapping(path = "/getById/{id}", produces = "application/json")
    public ResponseEntity<PolizzaDTO> getById(@PathVariable("id") long id) {
        try {
            PolizzaDTO polizzaDTO = polizzaService.getById(id); //ricerca per id
            if (polizzaDTO != null) {   //controlla se ci sono stati risultati
                return ResponseEntity.status(HttpStatus.OK).body(polizzaDTO);   //successo codice 200
            } else {    //altrimenti da messaggio di errore
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();     //codice 404
            }
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());    //codice 500
        }
    }

    @PutMapping(path = "/update", produces = "application/json", consumes = "application/json")
    public ResponseEntity<PolizzaDTO> update(@Validated(OnUpdate.class) @RequestBody PolizzaDTO dto) {
        try {
            PolizzaDTO polizzaDTO = polizzaService.update(dto); //cerca di fare l'update
            if (polizzaDTO != null) {   //controlla se ci sono stati risultati
                return ResponseEntity.status(HttpStatus.NO_CONTENT).body(polizzaDTO);   //successo codice 204
            } else {    //altrimenti da messaggio di errore
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build(); //codice 404
            }
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());    //codice 500
        }
    }

    @DeleteMapping(path = "/delete/{id}", produces = "application/json")
    public ResponseEntity<Void> delete(@PathVariable("id") long id) {
        try {
            boolean result = polizzaService.delete(id); //cerca di eliminare la polizza tramite id
            if (result) {   //controlla cosa viene tornato
                return ResponseEntity.status(HttpStatus.NO_CONTENT).build();    //messaggio di successo codice 204
            } else {    //altrimenti da messaggio di errore
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();     //codice 404
            }
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());    //codice 500
        }
    }
}
