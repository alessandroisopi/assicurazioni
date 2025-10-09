package it.onyx.assicurazioni.entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDateTime;

@Embeddable
public class DocumentoPolizzaEmbeddedId implements Serializable {
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "seq_documento_polizza")
    @SequenceGenerator(name = "seq_documento_polizza", sequenceName = "seq_documento_polizza", allocationSize = 1)
    private long id;
    @Column(name = "DT_INSERT")
    private LocalDateTime dtInserimento;

    public DocumentoPolizzaEmbeddedId() {
    }

    public DocumentoPolizzaEmbeddedId(long id, LocalDateTime dtInserimento) {
        this.id = id;
        this.dtInserimento = dtInserimento;
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
}
