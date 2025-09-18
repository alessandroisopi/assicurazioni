package it.onyx.assicurazioni.entity;

import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.time.LocalDate;

@Embeddable
public class CostoPolizzaEtaEmbeddedId implements Serializable {

    private int etaInizio;
    private int etaFine;
    private LocalDate dtInizio;

    public CostoPolizzaEtaEmbeddedId(int etaInizio, int etaFine, LocalDate dtInizio) {
        this.etaInizio = etaInizio;
        this.etaFine = etaFine;
        this.dtInizio = dtInizio;
    }

    public CostoPolizzaEtaEmbeddedId() {
    }

    public int getEtaInizio() {
        return etaInizio;
    }

    public void setEtaInizio(int etaInizio) {
        this.etaInizio = etaInizio;
    }

    public int getEtaFine() {
        return etaFine;
    }

    public void setEtaFine(int etaFine) {
        this.etaFine = etaFine;
    }

    public LocalDate getDtInizio() {
        return dtInizio;
    }

    public void setDtInizio(LocalDate dtInizio) {
        this.dtInizio = dtInizio;
    }
}
