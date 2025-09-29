package it.onyx.assicurazioni.entity;

import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Embeddable
public class PolizzaEmbeddedId implements Serializable {
    private long idPolizza;
    private LocalDateTime dtInserimento;

    public PolizzaEmbeddedId() {
    }

    public PolizzaEmbeddedId(long idPolizza, LocalDateTime dtInserimento) {
        this.idPolizza = idPolizza;
        this.dtInserimento = dtInserimento;
    }

    public long getIdPolizza() {
        return idPolizza;
    }

    public void setIdPolizza(long idPolizza) {
        this.idPolizza = idPolizza;
    }

    public LocalDateTime getDtInserimento() {
        return dtInserimento;
    }

    public void setDtInserimento(LocalDateTime dtInserimento) {
        this.dtInserimento = dtInserimento;
    }
}
