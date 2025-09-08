package it.onyx.assicurazioni.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.time.LocalDate;

@Entity(name = "TIPO_POLIZZA")
public class TipoPolizza {
    @Id
    private long idTipoPolizza;

    @Column(name = "DS_TIPO_POLIZZA")
    private String dsTipoPolizza;

    @Column(name = "DT_INIZIO")
    private LocalDate dtInizio;

    @Column(name = "DT_FINE")
    private LocalDate dtFine;

    public TipoPolizza(long idTipoPolizza, String dsTipoPolizza, LocalDate dtInizio, LocalDate dtFine) {
        this.idTipoPolizza = idTipoPolizza;
        this.dsTipoPolizza = dsTipoPolizza;
        this.dtInizio = dtInizio;
        this.dtFine = dtFine;
    }
    public TipoPolizza() {}

    public long getIdTipoPolizza() {
        return idTipoPolizza;
    }

    public void setIdTipoPolizza(long idTipoPolizza) {
        this.idTipoPolizza = idTipoPolizza;
    }

    public String getDsTipoPolizza() {
        return dsTipoPolizza;
    }

    public void setDsTipoPolizza(String dsTipoPolizza) {
        this.dsTipoPolizza = dsTipoPolizza;
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
