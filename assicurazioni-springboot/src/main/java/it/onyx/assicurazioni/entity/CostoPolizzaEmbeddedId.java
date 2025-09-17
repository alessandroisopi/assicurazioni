package it.onyx.assicurazioni.entity;

import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.time.LocalDate;

@Embeddable
public class CostoPolizzaEmbeddedId implements Serializable {

    private long idClasse;
    private LocalDate dtInizio;

    public CostoPolizzaEmbeddedId(long idClasse, LocalDate dtInizio) {
        this.idClasse = idClasse;
        this.dtInizio = dtInizio;
    }

    public CostoPolizzaEmbeddedId() {
    }

    public long getIdClasse() {
        return idClasse;
    }

    public void setIdClasse(long idClasse) {
        this.idClasse = idClasse;
    }

    public LocalDate getDtInizio() {
        return dtInizio;
    }

    public void setDtInizio(LocalDate dtInizio) {
        this.dtInizio = dtInizio;
    }
}
