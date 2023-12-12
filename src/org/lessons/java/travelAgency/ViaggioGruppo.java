package org.lessons.java.travelAgency;

import java.math.BigDecimal;
import java.time.LocalDate;

public class ViaggioGruppo extends Vacanza{
    private int numeroGruppo;
    private String fasciaEta;

    public ViaggioGruppo(String destinazione, LocalDate dataInizio, LocalDate dataFine, int numeroGruppo, String fasciaEta) throws IllegalArgumentException {
        super(destinazione, dataInizio, dataFine);
        this.numeroGruppo = numeroGruppo;
        this.fasciaEta = fasciaEta;

    }

    public int getNumeroGruppo() {
        return numeroGruppo;
    }

    public String getFasciaEta() {
        return fasciaEta;
    }
    @Override
    public  String toString(){
        String info;
        BigDecimal prezzo12 = BigDecimal.valueOf(0.00);
        info = ("La tua fascia di età è: " + fasciaEta + "\n" + "Hai prenotato una vacanza per: " + getDestinazione() + " di " + calcoloGiorniVacanza() + " giorni, (dal " + getDataInizio() + " al " + getDataFine()+")" +
        "\n" + "Il gruppo sarà di: " + numeroGruppo + " persone");
        for (Escursione escursione : getEscursioni()){
            info += ("\n" + "La città scelta per l'escursione  è:  " + escursione.getNomeCitta() + " il prezzo totale è di: " + escursione.getPrezzoTotale() + " euro");
            prezzo12 = prezzo12.add(escursione.getPrezzoTotale());


        }
        info += ("\n" + "Il prezzo totale della tua vacanza è di:" + prezzo12 + " euro");
        return info;

    }

}
