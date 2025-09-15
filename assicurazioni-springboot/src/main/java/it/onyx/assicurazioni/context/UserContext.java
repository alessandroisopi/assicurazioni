package it.onyx.assicurazioni.context;

import it.onyx.assicurazioni.entity.Utente;

// UserContext.java
public class UserContext {

    // Crea una variabile "thread-safe" che conterrà l'oggetto Utente.
    // Ogni thread avrà la sua copia indipendente di questa variabile.
    private static final ThreadLocal<Utente> context = new ThreadLocal<>();

    public static void setUtente(Utente utente) {
        context.set(utente); // Associa l'utente al thread corrente
    }

    public static Utente getUtente() {
        return context.get(); // Recupera l'utente associato al thread corrente
    }

    public static void clear() {
        // FONDAMENTALE: Rimuove l'oggetto dal thread alla fine della richiesta.
        // Questo previene memory leak e l'uso accidentale dei dati in richieste successive.
        context.remove();
    }
}