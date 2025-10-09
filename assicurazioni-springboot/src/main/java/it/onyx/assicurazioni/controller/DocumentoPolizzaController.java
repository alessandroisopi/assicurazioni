package it.onyx.assicurazioni.controller;

import it.onyx.assicurazioni.dto.DocumentoPolizzaDTO;
import it.onyx.assicurazioni.service.DocumentoPolizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/documentoPolizza")
public class DocumentoPolizzaController {

    @Autowired
    private DocumentoPolizzaService documentoPolizzaService;

    @PostMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity<DocumentoPolizzaDTO> insert(@RequestBody DocumentoPolizzaDTO dto) throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body(documentoPolizzaService.insert(dto));
    }
}
