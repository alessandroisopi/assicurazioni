package it.onyx.assicurazioni.dto;

import it.onyx.assicurazioni.adapter.LocalDateTimeAdapter;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import java.time.LocalDateTime;

public class DocumentoPolizzaDTO {

    @Null(message = "Non puo essere specificato il valore")
    private long id;
    @Null(message = "Non puo essere specificato il valore")
    private LocalDateTime dtInserimento;
    @NotNull(message = "Il valore deve essere specificato")
    private PolizzaDTO idPolizza;
    @Null(message = "Non puo essere specificato il valore")
    private byte[] doc;
    @NotNull(message = "Il valore deve essere specificato")
    private String nomeFile;
    @Null(message = "Non puo essere specificato il valore")
    private String utenteC;

    public DocumentoPolizzaDTO() {
    }

    public DocumentoPolizzaDTO(PolizzaDTO idPolizza, String nomeFile) {
        this.idPolizza = idPolizza;
        this.nomeFile = nomeFile;
    }

    public DocumentoPolizzaDTO(long id, LocalDateTime dtInserimento, PolizzaDTO idPolizza, byte[] doc, String nomeFile, String utenteC) {
        this.id = id;
        this.dtInserimento = dtInserimento;
        this.idPolizza = idPolizza;
        this.doc = doc;
        this.nomeFile = nomeFile;
        this.utenteC = utenteC;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @XmlJavaTypeAdapter(LocalDateTimeAdapter.class)
    public LocalDateTime getDtInserimento() {
        return dtInserimento;
    }

    public void setDtInserimento(LocalDateTime dtInserimento) {
        this.dtInserimento = dtInserimento;
    }

    public PolizzaDTO getIdPolizza() {
        return idPolizza;
    }

    public void setIdPolizza(PolizzaDTO idPolizza) {
        this.idPolizza = idPolizza;
    }

    public byte[] getDoc() {
        return doc;
    }

    public void setDoc(byte[] doc) {
        this.doc = doc;
    }

    public String getNomeFile() {
        return nomeFile;
    }

    public void setNomeFile(String nomeFile) {
        this.nomeFile = nomeFile;
    }

    public String getUtenteC() {
        return utenteC;
    }

    public void setUtenteC(String utenteC) {
        this.utenteC = utenteC;
    }
}
