package it.onyx.assicurazioni.dto;

import it.onyx.assicurazioni.groupvalidator.OnCreate;
import it.onyx.assicurazioni.groupvalidator.OnUpdate;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public class TipoPolizzaDTO {

    @Min(value = 1, message = "Il valore deve essere maggiore o uguale a 1", groups = {OnUpdate.class, OnCreate.class})
    @NotNull(message = "il valore non può essere nullo", groups = {OnUpdate.class, OnCreate.class})
    private long idTipoPolizza;
    @NotNull(message = "il valore non può essere nullo", groups = {OnCreate.class})
    private String dsTipoPolizza;
    @NotNull(message = "il valore non può essere nullo", groups = {OnCreate.class})
    private LocalDate dtInizio;
    @NotNull(message = "il valore non può essere nullo", groups = {OnCreate.class})
    private LocalDate dtFine;

    public TipoPolizzaDTO(long idTipoPolizza, String dsTipoPolizza, LocalDate dtInizio, LocalDate dtFine) {
        this.idTipoPolizza = idTipoPolizza;
        this.dsTipoPolizza = dsTipoPolizza;
        this.dtInizio = dtInizio;
        this.dtFine = dtFine;
    }

    public TipoPolizzaDTO() {
    }

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

    @Override
    public String toString() {
        return "TipoPolizzaDTO{" +
                "idTipoPolizza=" + idTipoPolizza +
                ", dsTipoPolizza='" + dsTipoPolizza + '\'' +
                ", dtInizio=" + dtInizio +
                ", dtFine=" + dtFine +
                '}';
    }
}
