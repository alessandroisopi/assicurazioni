package it.onyx.assicurazioni.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.time.LocalDate;

@Entity(name = "CLASSE")
public class Classe {
    @Id
    @Column(name = "ID_CLASSE")
    private long idClasse;

    @Column(name = "CD_CLASSE")
    private String cdClasse;

    @Column(name = "DS_CLASSE")
    private String dsClasse;

    @Column(name = "DT_INIZIO")
    private LocalDate dtInizio;

    @Column(name = "DT_FINE")
    private LocalDate dtFine;

    public Classe() {
    }

    public Classe(long idClasse, String cdClasse, String dsClasse, LocalDate dtInizio, LocalDate dtFine) {
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
        return "Classe{" +
                "idClasse=" + idClasse +
                ", cdClasse='" + cdClasse + '\'' +
                ", dsClasse='" + dsClasse + '\'' +
                ", dtInizio=" + dtInizio +
                ", dtFine=" + dtFine +
                '}';
    }
}
