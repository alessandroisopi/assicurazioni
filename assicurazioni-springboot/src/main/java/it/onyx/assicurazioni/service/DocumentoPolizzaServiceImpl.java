package it.onyx.assicurazioni.service;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfReader;
import it.onyx.assicurazioni.context.UserContext;
import it.onyx.assicurazioni.dto.DocumentoPolizzaDTO;
import it.onyx.assicurazioni.entity.DocumentoPolizza;
import it.onyx.assicurazioni.repository.DocumentoPolizzaRepository;
import it.onyx.assicurazioni.repository.PolizzaRepository;
import it.onyx.assicurazioni.util.DocumentoPolizzaMapper;
import it.onyx.assicurazioni.util.PolizzaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;

@Service
public class DocumentoPolizzaServiceImpl implements DocumentoPolizzaService {

    @Autowired
    private DocumentoPolizzaRepository documentoPolizzaRepository;

    @Autowired
    private PolizzaRepository polizzaRepository;

    @Autowired
    private PolizzaService polizzaService;

    @Value("${insert.documentoPolizza}")
    private boolean insertDocumento;

    @Override
    public DocumentoPolizzaDTO insert(DocumentoPolizzaDTO dto) throws Exception {
        if (!insertDocumento) {
            throw new Exception("Impossibile aggiungere nuovi documenti");
        }
        if (polizzaRepository.getById(dto.getIdPolizza().getIdPolizza()) == null) {
            throw new Exception("Impossibile trovate la polizza desiderata");
        } else {
            dto.setIdPolizza(PolizzaMapper.toDto(polizzaRepository.getById(dto.getIdPolizza().getIdPolizza())));
        }
        dto.setDtInserimento(LocalDateTime.now());
        polizzaService.generatePdfFile(dto.getIdPolizza().getIdPolizza(), dto.getNomeFile());
        String pathNomeFile = "assicurazioni-springboot/src/main/resources/risultati/pdfGenerati/" + dto.getNomeFile() + ".pdf";
        Path pdfPath = Paths.get(pathNomeFile);
        dto.setDoc(Files.readAllBytes(pdfPath));
        dto.setUtenteC(UserContext.getUtente().getCodiceFiscale());
        DocumentoPolizza entity = DocumentoPolizzaMapper.toEntity(dto);
        return DocumentoPolizzaMapper.toDto(documentoPolizzaRepository.save(entity));
    }
}
