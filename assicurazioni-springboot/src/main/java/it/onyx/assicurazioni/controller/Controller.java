package it.onyx.assicurazioni.controller;

import it.onyx.assicurazioni.dto.PolizzaDTO;
import it.onyx.assicurazioni.groupvalidator.OnCreate;
import it.onyx.assicurazioni.groupvalidator.OnUpdate;
import it.onyx.assicurazioni.service.PolizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/polizza")
public class Controller {

    @Autowired
    private PolizzaService polizzaService;

    @PostMapping(path = "/insert", produces = "application/json", consumes = "application/json")
    public String insert(@Validated(OnCreate.class) @RequestBody PolizzaDTO dto) {
        PolizzaDTO polizzaDTO = polizzaService.insert(dto); //avviene l'insert
        if (polizzaDTO != null) {   //controlla cosa ha tornato la service
            return polizzaDTO.toString();   //successo
        } else {    //altrimento torna un messaggio di errore
            return "Non è stato possibile aggiungere la polizza";
        }
    }

    @GetMapping(path = "/getAll", produces = "application/json")
    public String getAll() {
        List<PolizzaDTO> polizzaDTO = polizzaService.getAll();  //prende tutti gli elementi
        if  (polizzaDTO != null) {  //controlla se ci sono risultati
            return polizzaDTO.toString();   //successo
        } else {    //altrimenti da messaggi di errore
            return "Non è stato possibile ricevere risultati";
        }
    }

    @GetMapping(path = "/getById/{id}", produces = "application/json")
    public String getById(@PathVariable("id") long id) {
        PolizzaDTO polizzaDTO = polizzaService.getById(id); //ricerca per id
        if (polizzaDTO != null) {   //controlla se ci sono stati risultati
            return polizzaDTO.toString();   //successo
        } else {    //altrimenti da messaggio di errore
            return "Non è stato possibile ricevere risultati";
        }
    }

    @PutMapping(path = "/update", produces = "application/json", consumes = "application/json")
    public String update(@Validated(OnUpdate.class) @RequestBody PolizzaDTO dto) {
        PolizzaDTO polizzaDTO = polizzaService.update(dto); //cerca di fare l'update
        if (polizzaDTO != null) {   //controlla se ci sono stati risultati
            return polizzaDTO.toString();   //successo
        } else {    //altrimenti da messaggio di errore
            return "Non è stato possibile aggiornare la polizza";
        }
    }

    @DeleteMapping(path = "/delete/{id}", produces = "application/json")
    public String delete(@PathVariable("id") long id) {
        boolean result = polizzaService.delete(id); //cerca di eliminare la polizza tramite id
        if (result) {   //controlla cosa viene tornato
            return "Polizza eliminata con successo";    //messaggio di successo
        } else {    //altrimenti da messaggio di errore
            return "Polizza non eliminata";
        }
    }
}
