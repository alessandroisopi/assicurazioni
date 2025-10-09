package it.onyx.assicurazioni.dto;

import java.time.LocalDateTime;

public class DocumentoPolizzaDTO {

    private long id;
    private LocalDateTime dtInserimento;
    private PolizzaDTO idPolizza;
    private byte[] doc;
    private String nomeFile;
    private String utenteC;

    public DocumentoPolizzaDTO() {
    }

    public DocumentoPolizzaDTO(long id, PolizzaDTO idPolizza, String nomeFile) {
        this.id = id;
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
