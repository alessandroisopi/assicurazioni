package it.onyx.assicurazioni.dto;

import it.onyx.assicurazioni.groupvalidator.OnCreate;
import it.onyx.assicurazioni.groupvalidator.OnUpdate;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public class PolizzaDTO {


    @Min(value = 1, message = "Il valore deve essere maggiore o uguale a 1", groups = {OnUpdate.class})
    @NotNull(message = "il valore non può essere nullo", groups = {OnUpdate.class})
    private long idPolizza;
    @Min(value=1, message = "Il valore deve essere maggiore o uguale a 1", groups = {OnCreate.class})
    @NotNull(message = "il valore non può essere nullo", groups = {OnCreate.class})
    private long idTipoPolizza;
    @Min(value=1, message = "Il valore deve essere maggiore o uguale a 1", groups = {OnCreate.class})
    @NotNull(message = "il valore non può essere nullo", groups = {OnCreate.class})
    private long idClasse;
    @Min(value=1, message = "Il valore deve essere maggiore o uguale a 1", groups = {OnCreate.class})
    @NotNull(message = "il valore non può essere nullo", groups = {OnCreate.class})
    private long idIntestatario;
    @Min(value=1, message = "Il valore deve essere maggiore o uguale a 1", groups = {OnCreate.class})
    @NotNull(message = "il valore non può essere nullo", groups = {OnCreate.class})
    private long idStatoPolizza;
    private String numPolizza;
    @NotNull(message = "il valore non può essere nullo", groups = {OnCreate.class})
    private LocalDate dtInizio;
    @NotNull(message = "il valore non può essere nullo", groups = {OnCreate.class})
    private LocalDate dtFine;
    private String note;

    public PolizzaDTO() {}

    public PolizzaDTO(long idPolizza, long idTipoPolizza, long idClasse, long idIntestatario, long idStatoPolizza, LocalDate dtInizio, LocalDate dtFine, String note) {
        this.idPolizza = idPolizza;
        this.idTipoPolizza = idTipoPolizza;
        this.idClasse = idClasse;
        this.idIntestatario = idIntestatario;
        this.idStatoPolizza = idStatoPolizza;
        this.numPolizza = idIntestatario + "|" + idTipoPolizza;
        this.dtInizio = dtInizio;
        this.dtFine = dtFine;
        this.note = note;
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

    public String getNumPolizza() {
        return numPolizza;
    }

    public void setNumPolizza(String numPolizza) {
        this.numPolizza = numPolizza;
    }

    public void setCombinato(long idIntestatario, long idTipoPolizza) { //a differenza del set principale questo usa i campi primari
        this.numPolizza = idIntestatario + "|" + idTipoPolizza;
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

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "PolizzaDTO{" +
                "idPolizza=" + idPolizza +
                ", idTipoPolizza=" + idTipoPolizza +
                ", idClasse=" + idClasse +
                ", idIntestatario=" + idIntestatario +
                ", idStatoPolizza=" + idStatoPolizza +
                ", dtInizio=" + dtInizio +
                ", dtFine=" + dtFine +
                ", note='" + note + '\'' +
                '}';
    }
}
