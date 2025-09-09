package it.onyx.assicurazioni.entity;

import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.time.LocalDate;

@Embeddable
public class PolizzaEmbeddedId implements Serializable {
    private long idPolizza;
    private LocalDate dtInserimento;

    public PolizzaEmbeddedId() {
    }

    public PolizzaEmbeddedId(long idPolizza, LocalDate dtInserimento) {
        this.idPolizza = idPolizza;
        this.dtInserimento = dtInserimento;
    }

    public long getIdPolizza() {
        return idPolizza;
    }

    public void setIdPolizza(long idPolizza) {
        this.idPolizza = idPolizza;
    }

    public LocalDate getDtInserimento() {
        return dtInserimento;
    }

    public void setDtInserimento(LocalDate dtInserimento) {
        this.dtInserimento = dtInserimento;
    }
}
