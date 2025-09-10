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
        List<ClasseDTO> result = classeService.getAll();
        if (!result.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK).body(result);
        } else  {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping(path = "/getById/{id}", produces = "application/json")
    public ResponseEntity<ClasseDTO> getById(@PathVariable("id") long id) {
        ClasseDTO result = classeService.getById(id);
        if (result != null) {
            return ResponseEntity.status(HttpStatus.OK).body(result);
        }  else  {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PutMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity<ClasseDTO> update(@Validated(OnUpdate.class) @RequestBody ClasseDTO dto) {
        ClasseDTO result = classeService.update(dto);
        if (result != null) {
            return ResponseEntity.status(HttpStatus.OK).body(result);
        } else   {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
