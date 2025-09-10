package it.onyx.assicurazioni.dto;

import it.onyx.assicurazioni.groupvalidator.OnCreate;
import it.onyx.assicurazioni.groupvalidator.OnUpdate;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public class ClasseDTO {

    @Min(value = 1, message = "Il valore deve essere maggiore o uguale a 1", groups = {OnUpdate.class, OnCreate.class})
    @NotNull(message = "il valore non può essere nullo", groups = {OnUpdate.class, OnCreate.class})
    private long idClasse;

    @NotNull(message = "il valore non può essere nullo", groups = {OnUpdate.class, OnCreate.class})
    private String cdClasse;

    @NotNull(message = "il valore non può essere nullo", groups = {OnUpdate.class, OnCreate.class})
    private String dsClasse;

    @NotNull(message = "il valore non può essere nullo", groups = {OnUpdate.class, OnCreate.class})
    private LocalDate dtInizio;

    private LocalDate dtFine;

    public ClasseDTO() {
    }

    public ClasseDTO(long idClasse) {
        this.idClasse = idClasse;
    }

    public ClasseDTO(long idClasse, String cdClasse, String dsClasse, LocalDate dtInizio, LocalDate dtFine) {
        this.idClasse = idClasse;
        this.cdClasse = cdClasse;
        this.dsClasse = dsClasse;
        this.dtInizio = dtInizio;
        this.dtFine = dtFine;
    }

    public long getIdClasse() {
        return idClasse;
    }

    public void setIdClasse(long idClasse) {
        this.idClasse = idClasse;
    }

    public String getCdClasse() {
        return cdClasse;
    }

    public void setCdClasse(String cdClasse) {
        this.cdClasse = cdClasse;
    }

    public String getDsClasse() {
        return dsClasse;
    }

    public void setDsClasse(String dsClasse) {
        this.dsClasse = dsClasse;
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
        return "ClasseDTO{" +
                "idClasse=" + idClasse +
                ", cdClasse='" + cdClasse + '\'' +
                ", dsClasse='" + dsClasse + '\'' +
                ", dtInizio=" + dtInizio +
                ", dtFine=" + dtFine +
                '}';
    }
}
