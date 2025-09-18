package it.onyx.assicurazioni.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.time.LocalDate;

@Entity
@Table(name = "COSTO_POLIZZA_COMUNE")
public class CostoPolizzaComune {
    @EmbeddedId
    private CostoPolizzaComuneEmbeddedId id;

    @Column(name = "INCREMENTO")
    private int incremento;

    @Column(name = "DT_FINE")
    private LocalDate dtFine;

    public CostoPolizzaComune(CostoPolizzaComuneEmbeddedId id, int incremento, LocalDate dtFine) {
        this.id = id;
        this.incremento = incremento;
        this.dtFine = dtFine;
    }

    public CostoPolizzaComune() {
    }

    public CostoPolizzaComuneEmbeddedId getId() {
        return id;
    }

    public void setId(CostoPolizzaComuneEmbeddedId id) {
        this.id = id;
    }

    public int getIncremento() {
        return incremento;
    }

    public void setIncremento(int incremento) {
        this.incremento = incremento;
    }

    public LocalDate getDtFine() {
        return dtFine;
    }

    public void setDtFine(LocalDate dtFine) {
        this.dtFine = dtFine;
    }
}
