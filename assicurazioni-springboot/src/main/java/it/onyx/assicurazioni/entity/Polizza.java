package it.onyx.assicurazioni.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.time.LocalDate;

@Entity(name = "POLIZZA")
public class Polizza {
    @Id
    private long idPolizza; //indentificativo polizza

    @Column(name = "ID_TIPO_POLIZZA")
    private long idTipoPolizza; //indentificativo tipo polizza

    @Column(name = "ID_CLASSE")
    private long idClasse; //indentificativo classe polizza

    @Column(name = "ID_INTESTATARIO")
    private long idIntestatario; //indentificativo intestatario polizza

    @Column(name = "ID_STATO_POLIZZA")
    private long idStatoPolizza; //indentificativo stato polizza

    @Column(name = "DT_INIZIO")
    private LocalDate dtInizio; //data inizio polizza

    @Column(name = "DT_FINE")
    private LocalDate dtFine; //data fine polizza

    @Column(name = "NOTE")
    private String note; //note polizza

    public Polizza(long idPolizza, long idTipoPolizza, long idClasse, long idIntestatario, long idStatoPolizza, LocalDate dtInizio, LocalDate dtFine, String note) {
        this.idPolizza = idPolizza;
        this.idTipoPolizza = idTipoPolizza;
        this.idClasse = idClasse;
        this.idIntestatario = idIntestatario;
        this.idStatoPolizza = idStatoPolizza;
        this.dtInizio = dtInizio;
        this.dtFine = dtFine;
        this.note = note;
    }

    public Polizza() {
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
