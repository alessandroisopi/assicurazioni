package it.onyx.assicurazioni.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "COSTO_POLIZZA_CLASSE")
public class CostoPolizzaClasse {

    @EmbeddedId
    private CostoPolizzaClasseEmbeddedId id;

    @ManyToOne
    @MapsId("idClasse")
    @JoinColumn(name = "ID_CLASSE", referencedColumnName = "ID_CLASSE")
    private Classe idClasse;

    @Column(name = "INCREMENTO")
    private int incremento;

    @Column(name = "DT_FINE")
    private LocalDate dtFine;

    public CostoPolizzaClasse(CostoPolizzaClasseEmbeddedId id, Classe idClasse, int incremento, LocalDate dtFine) {
        this.id = id;
        this.idClasse = idClasse;
        this.incremento = incremento;
        this.dtFine = dtFine;
    }

    public CostoPolizzaClasse() {
    }

    public CostoPolizzaClasseEmbeddedId getId() {
        return id;
    }

    public void setId(CostoPolizzaClasseEmbeddedId id) {
        this.id = id;
    }

    public Classe getIdClasse() {
        return idClasse;
    }

    public void setIdClasse(Classe idClasse) {
        this.idClasse = idClasse;
    }

    public int getIncremento() {
        return incremento;
    }

    public void setIncremento(int incremento) {
        this.incremento = incremento;
    }

    public LocalDate getDtFine() {
        return dtFine;
    }

    public void setDtFine(LocalDate dtFine) {
        this.dtFine = dtFine;
    }
}
