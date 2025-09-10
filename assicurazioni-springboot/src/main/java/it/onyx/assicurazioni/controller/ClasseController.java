package it.onyx.assicurazioni.controller;

import it.onyx.assicurazioni.dto.ClasseDTO;
import it.onyx.assicurazioni.groupvalidator.OnUpdate;
import it.onyx.assicurazioni.service.ClasseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/classe")
public class ClasseController {

    @Autowired
    private ClasseService classeService;

    @GetMapping(path = "/getAll", produces = "application/json")
    public ResponseEntity<List<ClasseDTO>> getAll() {
        List<ClasseDTO> result = classeService.getAll();    //ottiene la lista di risultati
        if (!result.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK).body(result);   //se c'è almeno un risultato torna lo stato ok con la lista
        } else  {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build(); //se non c'è nulla torna lo stato not found
        }
    }

    @GetMapping(path = "/getById/{id}", produces = "application/json")
    public ResponseEntity<ClasseDTO> getById(@PathVariable("id") long id) {
        ClasseDTO result = classeService.getById(id);   //ottiene il risultato
        if (result != null) {
            return ResponseEntity.status(HttpStatus.OK).body(result);   //se c'è un riscontro torna lo stato ok e l'oggetto
        }  else  {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build(); //se non c'è nulla torna lo stato not found
        }
    }

    @PutMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity<ClasseDTO> update(@Validated(OnUpdate.class) @RequestBody ClasseDTO dto) {
        ClasseDTO result = classeService.update(dto);   //ottiene il risultato
        if (result != null) {
            return ResponseEntity.status(HttpStatus.OK).body(result);   //se update va a buon fine torna lo stato ok e l'oggetto
        } else   {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build(); //se non trova l'oggetto torna lo stato not found
        }
    }
}
