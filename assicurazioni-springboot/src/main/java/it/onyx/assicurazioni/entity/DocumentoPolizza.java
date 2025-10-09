package it.onyx.assicurazioni.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "DOCUMENTO_POLIZZA")
public class DocumentoPolizza {

    @EmbeddedId
    private DocumentoPolizzaEmbeddedId id;

    @Column(name = "ID_POLIZZA")
    private long idPolizza;

    @Column(name = "DOC")
    private byte[] doc;

    @Column(name = "NOME_FILE")
    private String nomeFile;

    @Column(name = "UTENTE_C")
    private String utenteC;

    @Transient
    private Polizza polizza;

    public DocumentoPolizza() {
    }

    public DocumentoPolizza(long id, LocalDateTime dtInserimento, long idPolizza, byte[] doc, String nomeFile, String utenteC, Polizza polizza) {
        this.id = new DocumentoPolizzaEmbeddedId(id, dtInserimento);
        this.idPolizza = idPolizza;
        this.doc = doc;
        this.nomeFile = nomeFile;
        this.utenteC = utenteC;
        this.polizza = polizza;
    }

    public DocumentoPolizzaEmbeddedId getId() {
        return id;
    }

    public void setId(DocumentoPolizzaEmbeddedId id) {
        this.id = id;
    }

    public long getIdPolizza() {
        return idPolizza;
    }

    public void setIdPolizza(long idPolizza) {
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

    public Polizza getPolizza() {
        return polizza;
    }

    public void setPolizza(Polizza polizza) {
        this.polizza = polizza;
    }
}
