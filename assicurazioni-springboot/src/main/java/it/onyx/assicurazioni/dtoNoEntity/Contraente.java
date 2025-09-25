package it.onyx.assicurazioni.dtoNoEntity;

import java.time.LocalDate;

public class Contraente {

    private String nome;

    private String cognome;

    private String cf;

    private LocalDate dtNascita;

    public Contraente(String nome, String cognome, String cf, LocalDate dtNascita) {
        this.nome = nome;
        this.cognome = cognome;
        this.cf = cf;
        this.dtNascita = dtNascita;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getCf() {
        return cf;
    }

    public void setCf(String cf) {
        this.cf = cf;
    }

    public LocalDate getDtNascita() {
        return dtNascita;
    }

    public void setDtNascita(LocalDate dtNascita) {
        this.dtNascita = dtNascita;
    }
}
