package org.lessons.java.travelAgency;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.ArrayList;
import java.util.List;

public class Vacanza {
    private String destinazione;
    private LocalDate dataInizio;
    private LocalDate dataFine;
    private List<Escursione> escursioni = new ArrayList<>();

    public Vacanza(String destinazione, LocalDate dataInizio, LocalDate dataFine) throws IllegalArgumentException {
        validateDestination(destinazione);
        this.destinazione = destinazione;
        this.dataInizio = dataInizio;
        this.dataFine = dataFine;
    }

    public String getDestinazione() {
        return destinazione;
    }

    public void setDestinazione(String destinazione) {
        this.destinazione = destinazione;
    }

    public LocalDate getDataInizio() {
        return dataInizio;
    }

    public void setDataInizio(LocalDate dataInizio) {
        this.dataInizio = dataInizio;
    }

    public LocalDate getDataFine() {
        return dataFine;
    }

    public void setDataFine(LocalDate dataFine) {
        this.dataFine = dataFine;
    }

    public List<Escursione> getEscursioni() {
        return escursioni;
    }

    public void setEscursioni(List<Escursione> escursioni) {
        this.escursioni = escursioni;
    }

    private void validateDestination(String destinazione) throws IllegalArgumentException{
        if(destinazione.isEmpty() || destinazione == null){
            throw new IllegalArgumentException("Dovresti decidere dove andare.");
        }
    }
    public long calcoloGiorniVacanza(){
        return ChronoUnit.DAYS.between(dataInizio, dataFine);
    }

    public String toString (){
        String info;
        BigDecimal prezzo12 = BigDecimal.valueOf(0.00);
        info = ("Hai prenotato una vacanza per: " + getDestinazione() + " di " + calcoloGiorniVacanza() + " giorni, (dal " + getDataInizio() + " al " + getDataFine()+")");
        for (Escursione escursione : escursioni){
            info += ("\n" + "La città scelta per l'escursione  è:  " + escursione.getNomeCitta() + " il prezzo totale è di: " + escursione.getPrezzoTotale() + " euro");
            prezzo12 = prezzo12.add(escursione.getPrezzoTotale());

        }
        info += ("\n" + "Il prezzo totale della tua vacanza è di:" + prezzo12 + " euro");

        return info;
    }
}
