package it.onyx.assicurazioni.dto;

import it.onyx.assicurazioni.adapter.LocalDateAdapter;
import it.onyx.assicurazioni.adapter.LocalDateTimeAdapter;
import it.onyx.assicurazioni.groupvalidator.OnCreate;
import it.onyx.assicurazioni.groupvalidator.OnUpdate;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class PolizzaDTO {

    @Min(value = 1, message = "Il valore deve essere maggiore o uguale a 1", groups = {OnUpdate.class, OnCreate.class})
    @NotNull(message = "il valore non può essere nullo", groups = {OnUpdate.class, OnCreate.class})
    private long idPolizza;
    @NotNull(message = "il valore non può essere nullo", groups = {OnCreate.class, OnUpdate.class})
    private LocalDateTime dtInserimento;
    @NotNull(message = "il valore non può essere nullo", groups = {OnCreate.class})
    private TipoPolizzaDTO idTipoPolizza;
    @NotNull(message = "il valore non può essere nullo", groups = {OnCreate.class})
    private ClasseDTO idClasse;
    @NotNull(message = "il valore non può essere nullo", groups = {OnCreate.class})
    private String cdIntestatario;
    @NotNull(message = "il valore non può essere nullo", groups = {OnCreate.class})
    private StatoPolizzaDTO idStatoPolizza;
    @Null(message = "Il valore deve essere nullo", groups = {OnCreate.class, OnUpdate.class})
    private String numPolizza;
    @NotNull(message = "il valore non può essere nullo", groups = {OnCreate.class})
    private LocalDate dtInizio;
    @NotNull(message = "il valore non può essere nullo", groups = {OnCreate.class})
    private LocalDate dtFine;
    private String note;
    @Null(message = "Il valore deve essere nullo", groups = {OnCreate.class, OnUpdate.class})
    private String utenteC;

    public PolizzaDTO() {}

    public PolizzaDTO(long idPolizza, LocalDateTime dtInserimento, TipoPolizzaDTO idTipoPolizza, ClasseDTO idClasse, String cdIntestatario, StatoPolizzaDTO idStatoPolizza, LocalDate dtInizio, LocalDate dtFine, String note) {
        this.idPolizza = idPolizza;
        this.dtInserimento = dtInserimento;
        this.idTipoPolizza = idTipoPolizza;
        this.idClasse = idClasse;
        this.cdIntestatario = cdIntestatario;
        this.idStatoPolizza = idStatoPolizza;
        this.numPolizza = cdIntestatario + "|" + idTipoPolizza.getIdTipoPolizza();
        this.dtInizio = dtInizio;
        this.dtFine = dtFine;
        this.note = note;
    }

    public PolizzaDTO(long idPolizza, LocalDateTime dtInserimento, TipoPolizzaDTO idTipoPolizza, ClasseDTO idClasse, String cdIntestatario, StatoPolizzaDTO idStatoPolizza, LocalDate dtInizio, LocalDate dtFine, String note, String utenteC) {
        this.idPolizza = idPolizza;
        this.dtInserimento = dtInserimento;
        this.idTipoPolizza = idTipoPolizza;
        this.idClasse = idClasse;
        this.cdIntestatario = cdIntestatario;
        this.idStatoPolizza = idStatoPolizza;
        this.numPolizza = cdIntestatario + "|" + idTipoPolizza.getIdTipoPolizza();
        this.dtInizio = dtInizio;
        this.dtFine = dtFine;
        this.note = note;
        this.utenteC = utenteC;
    }

    public PolizzaDTO(long idPolizza) {
        this.idPolizza = idPolizza;
    }

    public long getIdPolizza() {
        return idPolizza;
    }

    public void setIdPolizza(long idPolizza) {
        this.idPolizza = idPolizza;
    }

    @XmlJavaTypeAdapter(LocalDateTimeAdapter.class)
    public LocalDateTime getDtInserimento() {
        return dtInserimento;
    }

    public void setDtInserimento(LocalDateTime dtInserimento) {
        this.dtInserimento = dtInserimento;
    }

    public TipoPolizzaDTO getIdTipoPolizza() {
        return idTipoPolizza;
    }

    public void setIdTipoPolizza(TipoPolizzaDTO idTipoPolizza) {
        this.idTipoPolizza = idTipoPolizza;
    }

    public ClasseDTO getIdClasse() {
        return idClasse;
    }

    public void setIdClasse(ClasseDTO idClasse) {
        this.idClasse = idClasse;
    }

    public StatoPolizzaDTO getIdStatoPolizza() {
        return idStatoPolizza;
    }

    public void setIdStatoPolizza(StatoPolizzaDTO idStatoPolizza) {
        this.idStatoPolizza = idStatoPolizza;
    }

    public String getNumPolizza() {
        return numPolizza;
    }

    public String getCdIntestatario() {
        return cdIntestatario;
    }

    public void setCdIntestatario(String cdIntestatario) {
        this.cdIntestatario = cdIntestatario;
    }

    public void setNumPolizza(String numPolizza) {
        this.numPolizza = numPolizza;
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

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getUtenteC() {
        return utenteC;
    }

    public void setUtenteC(String utenteC) {
        this.utenteC = utenteC;
    }

    @Override
    public String toString() {
        return "PolizzaDTO{" +
                "idPolizza=" + idPolizza +
                ", dtInserimento=" + dtInserimento +
                ", idTipoPolizza=" + idTipoPolizza +
                ", idClasse=" + idClasse +
                ", cdIntestatario=" + cdIntestatario +
                ", idStatoPolizza=" + idStatoPolizza +
                ", numPolizza='" + numPolizza + '\'' +
                ", dtInizio=" + dtInizio +
                ", dtFine=" + dtFine +
                ", note='" + note + '\'' +
                ", utenteC='" + utenteC + '\'' +
                '}';
    }

    public void setCombinato() {
        this.numPolizza = cdIntestatario + "|" + idTipoPolizza.getIdTipoPolizza();
    }
}
