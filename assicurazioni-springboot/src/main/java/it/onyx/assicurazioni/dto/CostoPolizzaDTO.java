package it.onyx.assicurazioni.dto;

import it.onyx.assicurazioni.adapter.LocalDateAdapter;
import it.onyx.assicurazioni.groupvalidator.OnCreate;
import it.onyx.assicurazioni.groupvalidator.OnUpdate;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import java.time.LocalDate;

public class CostoPolizzaDTO {
    @NotNull(message = "il valore non può essere nullo", groups = {OnUpdate.class, OnCreate.class})
    private TipoPolizzaDTO idTipoPolizza;

    @NotNull(message = "il valore non può essere nullo", groups = {OnCreate.class})
    private float costo;

    @NotNull(message = "il valore non può essere nullo", groups = {OnUpdate.class, OnCreate.class})
    private LocalDate dtInizio;

    private LocalDate dtFine;

    @Null(message = "il valore deve essere nullo", groups = {OnUpdate.class, OnCreate.class})
    private String UtenteC;

    public CostoPolizzaDTO(TipoPolizzaDTO idTipoPolizza, float costo, LocalDate dtInizio, LocalDate dtFine, String utenteC) {
        this.idTipoPolizza = idTipoPolizza;
        this.costo = costo;
        this.dtInizio = dtInizio;
        this.dtFine = dtFine;
        UtenteC = utenteC;
    }

    public CostoPolizzaDTO() {
    }

    public TipoPolizzaDTO getIdTipoPolizza() {
        return idTipoPolizza;
    }

    public void setIdTipoPolizza(TipoPolizzaDTO idTipoPolizza) {
        this.idTipoPolizza = idTipoPolizza;
    }

    public float getCosto() {
        return costo;
    }

    public void setCosto(float costo) {
        this.costo = costo;
    }

    @XmlJavaTypeAdapter(LocalDateAdapter.class)
    public LocalDate getDtInizio() {
        return dtInizio;
    }

    public void setDtInizio(LocalDate dtInizio) {
        this.dtInizio = dtInizio;
    }

    @XmlJavaTypeAdapter(LocalDateAdapter.class)
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

    @Override
    public String toString() {
        return "CostoPolizzaDTO{" +
                "idTipoPolizza=" + idTipoPolizza +
                ", costo=" + costo +
                ", dtInizio=" + dtInizio +
                ", dtFine=" + dtFine +
                ", UtenteC='" + UtenteC + '\'' +
                '}';
    }
}
