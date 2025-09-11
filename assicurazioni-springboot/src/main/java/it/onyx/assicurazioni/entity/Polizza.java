package it.onyx.assicurazioni.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

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

    @Column(name = "ID_INTESTATARIO")
    private long idIntestatario; //indentificativo intestatario polizza

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

    public Polizza() {
    }

    public Polizza(long idPolizza, LocalDate dtInserimento, TipoPolizza idTipoPolizza, Classe idClasse, long idIntestatario, StatoPolizza idStatoPolizza, String numPolizza, LocalDate dtInizio, LocalDate dtFine, String note) {
        this.idTipoPolizza = idTipoPolizza;
        this.idClasse = idClasse;
        this.idIntestatario = idIntestatario;
        this.idStatoPolizza = idStatoPolizza;
        this.numPolizza = numPolizza;
        this.dtInizio = dtInizio;
        this.dtFine = dtFine;
        this.note = note;
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

    public long getIdIntestatario() {
        return idIntestatario;
    }

    public void setIdIntestatario(long idIntestatario) {
        this.idIntestatario = idIntestatario;
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

    @Override
    public String toString() {
        return "Polizza{" +
                "idPolizza=" + id.getIdPolizza() +
                "dtInserimento=" + id.getIdPolizza() +
                ", idTipoPolizza=" + idTipoPolizza +
                ", idClasse=" + idClasse +
                ", idIntestatario=" + idIntestatario +
                ", idStatoPolizza=" + idStatoPolizza +
                ", numPolizza='" + numPolizza + '\'' +
                ", dtInizio=" + dtInizio +
                ", dtFine=" + dtFine +
                ", note='" + note + '\'' +
                '}';
    }
}
