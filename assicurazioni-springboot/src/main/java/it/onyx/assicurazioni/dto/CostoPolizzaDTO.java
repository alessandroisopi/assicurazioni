package it.onyx.assicurazioni.dto;

import it.onyx.assicurazioni.groupvalidator.OnCreate;
import it.onyx.assicurazioni.groupvalidator.OnUpdate;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;

import java.time.LocalDate;

public class CostoPolizzaDTO {
    @NotNull(message = "il valore non può essere nullo", groups = {OnUpdate.class, OnCreate.class})
    private ClasseDTO idClasse;

    @NotNull(message = "il valore non può essere nullo", groups = {OnCreate.class})
    private float costo;

    @NotNull(message = "il valore non può essere nullo", groups = {OnUpdate.class, OnCreate.class})
    private LocalDate dtInizio;

    private LocalDate dtFine;

    @Null(message = "il valore deve essere nullo", groups = {OnUpdate.class, OnCreate.class})
    private String UtenteC;

    public CostoPolizzaDTO(ClasseDTO idClasse, float costo, LocalDate dtInizio, LocalDate dtFine, String utenteC) {
        this.idClasse = idClasse;
        this.costo = costo;
        this.dtInizio = dtInizio;
        this.dtFine = dtFine;
        UtenteC = utenteC;
    }

    public CostoPolizzaDTO() {
    }

    public ClasseDTO getIdClasse() {
        return idClasse;
    }

    public void setIdClasse(ClasseDTO idClasse) {
        this.idClasse = idClasse;
    }

    public float getCosto() {
        return costo;
    }

    public void setCosto(float costo) {
        this.costo = costo;
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

    public String getUtenteC() {
        return UtenteC;
    }

    public void setUtenteC(String utenteC) {
        UtenteC = utenteC;
    }
}
