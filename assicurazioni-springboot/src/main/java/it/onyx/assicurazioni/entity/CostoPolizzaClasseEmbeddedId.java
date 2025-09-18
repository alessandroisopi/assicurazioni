package it.onyx.assicurazioni.entity;

import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.time.LocalDate;

@Embeddable
public class CostoPolizzaClasseEmbeddedId implements Serializable {

    private long idClasse;
    private LocalDate dtInizio;

    public CostoPolizzaClasseEmbeddedId(long idClasse, LocalDate dtInizio) {
        this.idClasse = idClasse;
        this.dtInizio = dtInizio;
    }

    public CostoPolizzaClasseEmbeddedId() {
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
