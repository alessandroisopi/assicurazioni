package it.onyx.assicurazioni.entity;

import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.time.LocalDate;

@Embeddable
public class CostoPolizzaComuneEmbeddedId implements Serializable {
    private long idComune;
    private LocalDate dtInizio;

    public CostoPolizzaComuneEmbeddedId(long idComune, LocalDate dtInizio) {
        this.idComune = idComune;
        this.dtInizio = dtInizio;
    }

    public CostoPolizzaComuneEmbeddedId() {
    }

    public long getIdComune() {
        return idComune;
    }

    public void setIdComune(long idComune) {
        this.idComune = idComune;
    }

    public LocalDate getDtInizio() {
        return dtInizio;
    }

    public void setDtInizio(LocalDate dtInizio) {
        this.dtInizio = dtInizio;
    }
}
