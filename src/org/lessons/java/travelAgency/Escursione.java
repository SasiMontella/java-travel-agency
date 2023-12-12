package org.lessons.java.travelAgency;

import java.math.BigDecimal;

public class Escursione {
    private String nomeCitta;
    private int durata;
    private BigDecimal prezzo;

    public Escursione(String nomeCitta, int durata) {
        this.nomeCitta = nomeCitta;
        this.durata = durata;
        this.prezzo = getPrezzoTotale();
    }

    public String getNomeCitta() {
        return nomeCitta;
    }

    public void setNomeCitta(String nomeCitta) {
        this.nomeCitta = nomeCitta;
    }

    public int getDurata() {
        return durata;
    }

    public void setDurata(int durata) {
        this.durata = durata;
    }

    public BigDecimal getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(BigDecimal prezzo) {
        this.prezzo = prezzo;
    }

    public BigDecimal getPrezzoTotale(){
        return prezzo = BigDecimal.valueOf(durata * 20.00);
    }
    public String toString(){
        return("Il prezzo base è di 20€ all'ora. La tua spesa totale è: " + prezzo);
    }
}

