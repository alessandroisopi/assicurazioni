package it.onyx.assicurazioni.dto;

import it.onyx.assicurazioni.adapter.LocalDateAdapter;
import it.onyx.assicurazioni.context.UserContext;
import it.onyx.assicurazioni.groupvalidator.OnCreate;
import it.onyx.assicurazioni.groupvalidator.OnUpdate;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import java.time.LocalDate;

public class StatoPolizzaDTO {

    @Min(value = 1, message = "Il valore deve essere maggiore o uguale a 1", groups = {OnUpdate.class, OnCreate.class})
    @NotNull(message = "il valore non può essere nullo", groups = {OnUpdate.class, OnCreate.class})
    private long  idStatoPolizza;

    @NotNull(message = "il valore non può essere nullo", groups = {OnCreate.class})
    private String dsStatoPolizza;

    @NotNull(message = "il valore non può essere nullo", groups = {OnCreate.class})
    private LocalDate dtInizio;

    private LocalDate dtFine;

    @Null(message = "Il valore deve essere nullo", groups = {OnCreate.class, OnUpdate.class})
    private String utenteC;

    public StatoPolizzaDTO() {
    }

    public StatoPolizzaDTO(long idStatoPolizza, String dsStatoPolizza, LocalDate dtInizio, LocalDate dtFine) {
        this.idStatoPolizza = idStatoPolizza;
        this.dsStatoPolizza = dsStatoPolizza;
        this.dtInizio = dtInizio;
        this.dtFine = dtFine;
    }

    public StatoPolizzaDTO(long idStatoPolizza, String dsStatoPolizza, LocalDate dtInizio, LocalDate dtFine, String utenteC) {
        this.idStatoPolizza = idStatoPolizza;
        this.dsStatoPolizza = dsStatoPolizza;
        this.dtInizio = dtInizio;
        this.dtFine = dtFine;
        this.utenteC = utenteC;
    }

    public StatoPolizzaDTO(long idStatoPolizza) {
        this.idStatoPolizza = idStatoPolizza;
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
        return utenteC;
    }

    public void setUtenteC(String utenteC) {
        this.utenteC = utenteC;
    }

    @Override
    public String toString() {
        return "StatoPolizzaDTO{" +
                "idStatoPolizza=" + idStatoPolizza +
                ", dsStatoPolizza='" + dsStatoPolizza + '\'' +
                ", dtInizio=" + dtInizio +
                ", dtFine=" + dtFine +
                ", utenteC='" + utenteC + '\'' +
                '}';
    }
}
