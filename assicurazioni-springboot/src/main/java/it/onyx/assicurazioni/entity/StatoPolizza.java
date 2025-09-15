package it.onyx.assicurazioni.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDate;

@Entity
@Table(name = "STATO_POLIZZA")
public class StatoPolizza {
    @Id
    @Column(name = "ID_STATO_POLIZZA")
    private long idStatoPolizza;

    @Column(name = "DS_STATO_POLIZZA")
    private String dsStatoPolizza;

    @Column(name = "DT_INIZIO")
    private LocalDate  dtInizio;

    @Column(name = "DT_FINE")
    private LocalDate dtFine;

    public StatoPolizza() {
    }

    public StatoPolizza(long idStatoPolizza, String dsStatoPolizza, LocalDate dtInizio, LocalDate dtFine) {
        this.idStatoPolizza = idStatoPolizza;
        this.dsStatoPolizza = dsStatoPolizza;
        this.dtInizio = dtInizio;
        this.dtFine = dtFine;
    }

    public long getIdStatoPolizza() {
        return idStatoPolizza;
    }

    public void setIdStatoPolizza(long idStatoPolizza) {
        this.idStatoPolizza = idStatoPolizza;
    }

    public String getDsStatoPolizza() {
        return dsStatoPolizza;
    }

    public void setDsStatoPolizza(String dsStatoPolizza) {
        this.dsStatoPolizza = dsStatoPolizza;
    }

    public LocalDate getDtInizio() {
        return dtInizio;
    }

    public void setDtInizio(LocalDate dtInizio) {
        this.dtInizio = dtInizio;
    }

    public LocalDate getDtFine() {
        return dtFine;
    }

    public void setDtFine(LocalDate dtFine) {
        this.dtFine = dtFine;
    }
}
