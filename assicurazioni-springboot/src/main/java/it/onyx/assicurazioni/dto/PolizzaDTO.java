package it.onyx.assicurazioni.dto;

import java.time.LocalDate;

public class PolizzaDTO {

    private long idPolizza;
    private long idTipoPolizza;
    private long idClasse;
    private long idIntestatario;
    private long idStatoPolizza;
    private LocalDate dtInizio;
    private LocalDate dtFine;

    public PolizzaDTO() {}

    public PolizzaDTO(long idPolizza, long idTipoPolizza, long idClasse, long idIntestatario,
                      long idStatoPolizza, LocalDate dtInizio, LocalDate dtFine) {
        this.idPolizza = idPolizza;
        this.idTipoPolizza = idTipoPolizza;
        this.idClasse = idClasse;
        this.idIntestatario = idIntestatario;
        this.idStatoPolizza = idStatoPolizza;
        this.dtInizio = dtInizio;
        this.dtFine = dtFine;
    }

    public long getIdPolizza() {
        return idPolizza;
    }

    public void setIdPolizza(long idPolizza) {
        this.idPolizza = idPolizza;
    }

    public long getIdTipoPolizza() {
        return idTipoPolizza;
    }

    public void setIdTipoPolizza(long idTipoPolizza) {
        this.idTipoPolizza = idTipoPolizza;
    }

    public long getIdClasse() {
        return idClasse;
    }

    public void setIdClasse(long idClasse) {
        this.idClasse = idClasse;
    }

    public long getIdIntestatario() {
        return idIntestatario;
    }

    public void setIdIntestatario(long idIntestatario) {
        this.idIntestatario = idIntestatario;
    }

    public long getIdStatoPolizza() {
        return idStatoPolizza;
    }

    public void setIdStatoPolizza(long idStatoPolizza) {
        this.idStatoPolizza = idStatoPolizza;
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
