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

public class ClasseDTO {

    @Min(value = 1, message = "Il valore deve essere maggiore o uguale a 1", groups = {OnUpdate.class, OnCreate.class})
    @NotNull(message = "il valore non può essere nullo", groups = {OnUpdate.class, OnCreate.class})
    private long idClasse;

    @NotNull(message = "il valore non può essere nullo", groups = {OnCreate.class})
    private String cdClasse;

    @NotNull(message = "il valore non può essere nullo", groups = {OnCreate.class})
    private String dsClasse;

    @NotNull(message = "il valore non può essere nullo", groups = {OnCreate.class})
    private LocalDate dtInizio;

    private LocalDate dtFine;

    @Null(message = "Il valore deve essere nullo", groups = {OnCreate.class, OnUpdate.class})
    private String utenteC;

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

    public ClasseDTO(long idClasse, String cdClasse, String dsClasse, LocalDate dtInizio, LocalDate dtFine, String utenteC) {
        this.idClasse = idClasse;
        this.cdClasse = cdClasse;
        this.dsClasse = dsClasse;
        this.dtInizio = dtInizio;
        this.dtFine = dtFine;
        this.utenteC = utenteC;
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
        return "ClasseDTO{" +
                "idClasse=" + idClasse +
                ", cdClasse='" + cdClasse + '\'' +
                ", dsClasse='" + dsClasse + '\'' +
                ", dtInizio=" + dtInizio +
                ", dtFine=" + dtFine +
                ", utenteC='" + utenteC + '\'' +
                '}';
    }
}
