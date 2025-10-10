package it.onyx.assicurazioni.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "POLIZZA")
public class Polizza {

    @EmbeddedId
    private PolizzaEmbeddedId id;

    @ManyToOne
    @JoinColumn(name = "ID_TIPO_POLIZZA", referencedColumnName = "ID_TIPO_POLIZZA")
    private TipoPolizza idTipoPolizza; //indentificativo tipo polizza

    @ManyToOne
    @JoinColumn(name = "ID_CLASSE", referencedColumnName = "ID_CLASSE")
    private Classe idClasse; //indentificativo classe polizza

    @Column(name = "CD_INTESTATARIO")
    private String cdIntestatario; //indentificativo intestatario polizza

    @ManyToOne
    @JoinColumn(name = "ID_STATO_POLIZZA", referencedColumnName = "ID_STATO_POLIZZA")
    private StatoPolizza idStatoPolizza; //indentificativo stato polizza

    @Column(name = "NUM_POLIZZA")
    private String numPolizza;  //numero della polizza

    @Column(name = "DT_INIZIO")
    private LocalDate dtInizio; //data inizio polizza

    @Column(name = "DT_FINE")
    private LocalDate dtFine; //data fine polizza

    @Column(name = "NOTE")
    private String note; //note polizza

    @Column(name = "UTENTE_C")
    private String utenteC;

    public Polizza() {
    }

    public Polizza(long idPolizza, LocalDateTime dtInserimento, TipoPolizza idTipoPolizza, Classe idClasse, String cdIntestatario, StatoPolizza idStatoPolizza, String numPolizza, LocalDate dtInizio, LocalDate dtFine, String note, String utenteC) {
        this.idTipoPolizza = idTipoPolizza;
        this.idClasse = idClasse;
        this.cdIntestatario = cdIntestatario;
        this.idStatoPolizza = idStatoPolizza;
        this.numPolizza = numPolizza;
        this.dtInizio = dtInizio;
        this.dtFine = dtFine;
        this.note = note;
        this.utenteC = utenteC;
        this.id =  new PolizzaEmbeddedId(idPolizza, dtInserimento);
    }

    public PolizzaEmbeddedId getId() {
        return id;
    }

    public void setId(PolizzaEmbeddedId id) {
        this.id = id;
    }

    public TipoPolizza getIdTipoPolizza() {
        return idTipoPolizza;
    }

    public void setIdTipoPolizza(TipoPolizza idTipoPolizza) {
        this.idTipoPolizza = idTipoPolizza;
    }

    public Classe getIdClasse() {
        return idClasse;
    }

    public void setIdClasse(Classe idClasse) {
        this.idClasse = idClasse;
    }

    public String getCdIntestatario() {
        return cdIntestatario;
    }

    public void setCdIntestatario(String cdIntestatario) {
        this.cdIntestatario = cdIntestatario;
    }

    public StatoPolizza getIdStatoPolizza() {
        return idStatoPolizza;
    }

    public void setIdStatoPolizza(StatoPolizza idStatoPolizza) {
        this.idStatoPolizza = idStatoPolizza;
    }

    public String getNumPolizza() {
        return numPolizza;
    }

    public void setNumPolizza(String numPolizza) {
        this.numPolizza = numPolizza;
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

    public String getUtenteC() {
        return utenteC;
    }

    public void setUtenteC(String utenteC) {
        this.utenteC = utenteC;
    }

    public void setCombinato() {
        this.numPolizza = this.cdIntestatario + "|" + this.idTipoPolizza.getIdTipoPolizza();
    }
}
