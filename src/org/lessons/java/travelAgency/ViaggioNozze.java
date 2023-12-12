package org.lessons.java.travelAgency;

import java.math.BigDecimal;
import java.time.LocalDate;



public class ViaggioNozze extends Vacanza{
    //Attributi
    private boolean massage;
    private boolean spa;
    private boolean drink;

    public ViaggioNozze(String destinazione, LocalDate dataInizio, LocalDate dataFine, boolean massage, boolean spa, boolean drink) throws IllegalArgumentException {
        super(destinazione, dataInizio, dataFine);
        this.massage = massage;
        this.spa = spa;
        this. drink = drink;
    }

    public boolean isMassage() {
        return massage;
    }

    public boolean isSpa() {
        return spa;
    }

    public boolean isDrink() {
        return drink;
    }

    @Override
    public String toString(){
        String info;
        BigDecimal prezzo12 = BigDecimal.valueOf(0.00);
        info = ("Hai prenotato una vacanza per: " + getDestinazione() + " di " + calcoloGiorniVacanza() + " giorni, (dal " + getDataInizio() + " al " + getDataFine()+")" +
                "\n" + "I tuoi extra prenotati sono: " + "\n" + "Drink illimitati: " + drink +  "\n" + "Accesso alla spa: " + spa + "\n" + "Massaggi di coppia: " + massage);
        for (Escursione escursione : getEscursioni()){
            info += ("\n" + "La città scelta per l'escursione  è:  " + escursione.getNomeCitta() + " il prezzo totale è di: " + escursione.getPrezzoTotale() + " euro");
            prezzo12 = prezzo12.add(escursione.getPrezzoTotale());

        }
        info += ("\n" + "Il prezzo totale della tua vacanza è di:" + prezzo12 + " euro");
        return info;

    }
}
