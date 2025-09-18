package it.onyx.assicurazioni.entity;

import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.time.LocalDate;

@Embeddable
public class CostoPolizzaEmbeddedId implements Serializable {

    private long idTipoPolizza;
    private LocalDate dtInizio;

    public CostoPolizzaEmbeddedId(long idTipoPolizza, LocalDate dtInizio) {
        this.idTipoPolizza = idTipoPolizza;
        this.dtInizio = dtInizio;
    }

    public CostoPolizzaEmbeddedId() {
    }

    public long getIdTipoPolizza() {
        return idTipoPolizza;
    }

    public void setIdTipoPolizza(long idTipoPolizza) {
        this.idTipoPolizza = idTipoPolizza;
    }

    public LocalDate getDtInizio() {
        return dtInizio;
    }

    public void setDtInizio(LocalDate dtInizio) {
        this.dtInizio = dtInizio;
    }
}
