package it.onyx.assicurazioni.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "COSTO_POLIZZA")
public class CostoPolizza {

    @EmbeddedId
    private CostoPolizzaEmbeddedId id;

    @ManyToOne
    @MapsId("idClasse")
    @JoinColumn(name = "ID_CLASSE", referencedColumnName = "ID_CLASSE")
    private Classe idClasse;

    @Column(name = "COSTO")
    private float costo;

    @Column(name = "DT_FINE")
    private LocalDate dtFine;

    @Column(name = "UTENTE_C")
    private String utenteC;

    public CostoPolizza() {
    }

    public CostoPolizza(Classe idClasse, float costo, LocalDate dtInizio, LocalDate dtFine, String utenteC) {
        this.id = new CostoPolizzaEmbeddedId(idClasse.getIdClasse(), dtInizio);
        this.idClasse = idClasse;
        this.costo = costo;
        this.dtFine = dtFine;
        this.utenteC = utenteC;
    }

    public CostoPolizzaEmbeddedId getId() {
        return id;
    }

    public void setId(CostoPolizzaEmbeddedId id) {
        this.id = id;
    }

    public Classe getIdClasse() {
        return idClasse;
    }

    public void setIdClasse(Classe idClasse) {
        this.idClasse = idClasse;
    }

    public float getCosto() {
        return costo;
    }

    public void setCosto(float costo) {
        this.costo = costo;
    }

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
}
