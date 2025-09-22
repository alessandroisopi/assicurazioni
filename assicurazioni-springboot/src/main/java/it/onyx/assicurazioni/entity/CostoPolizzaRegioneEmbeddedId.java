package it.onyx.assicurazioni.entity;

import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.time.LocalDate;

@Embeddable
public class CostoPolizzaRegioneEmbeddedId implements Serializable {
    private long idRegione;
    private LocalDate dtInizio;

    public CostoPolizzaRegioneEmbeddedId(long idComune, LocalDate dtInizio) {
        this.idRegione = idComune;
        this.dtInizio = dtInizio;
    }

    public CostoPolizzaRegioneEmbeddedId() {
    }

    public long getIdRegione() {
        return idRegione;
    }

    public void setIdRegione(long idRegione) {
        this.idRegione = idRegione;
    }

    public LocalDate getDtInizio() {
        return dtInizio;
    }

    public void setDtInizio(LocalDate dtInizio) {
        this.dtInizio = dtInizio;
    }
}
