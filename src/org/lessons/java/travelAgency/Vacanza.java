package org.lessons.java.travelAgency;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;

public class Vacanza {
    private String destinazione;
    private LocalDate dataInizio;
    private LocalDate dataFine;

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

    private void validateDestination(String destinazione) throws IllegalArgumentException{
        if(destinazione.isEmpty() || destinazione == null){
            throw new IllegalArgumentException("Dovresti decidere dove andare.");
        }
    }
    public long calcoloGiorniVacanza(){
        return ChronoUnit.DAYS.between(dataInizio, dataFine);
    }
    public void getTravelInfo (){
        System.out.println("Hai prenotato una vacanza per: " + getDestinazione() + " di " + calcoloGiorniVacanza() + " giorni, (dal " + getDataInizio() + " al " + getDataFine()+")");
    }
}
