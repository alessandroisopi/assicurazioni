package it.onyx.assicurazioni.controller;

import it.onyx.assicurazioni.dto.DocumentoPolizzaDTO;
import it.onyx.assicurazioni.service.DocumentoPolizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "/documentoPolizza")
public class DocumentoPolizzaController {

    @Autowired
    private DocumentoPolizzaService documentoPolizzaService;

    @PostMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity<DocumentoPolizzaDTO> insert(@RequestBody DocumentoPolizzaDTO dto) throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body(documentoPolizzaService.insert(dto));
    }

    @GetMapping(path = "getPdf/{id}")
    public ResponseEntity<byte[]> getDocumentoPolizzaPDF(@PathVariable("id") long id) throws Exception {
        DocumentoPolizzaDTO result = documentoPolizzaService.getById(id);
        byte[] doc = result.getDoc();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        String nomeFile = result.getNomeFile();
        headers.setContentDispositionFormData(nomeFile, nomeFile);
        headers.setCacheControl("must-revalidate, post-check=0, pre-check=0");
        return new ResponseEntity<>(doc, headers, HttpStatus.OK);
    }

    @GetMapping(path = "/{id}", produces = "application/json")
    public ResponseEntity<DocumentoPolizzaDTO> getById(@PathVariable("id") long id) throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body(documentoPolizzaService.getById(id));
    }
}
