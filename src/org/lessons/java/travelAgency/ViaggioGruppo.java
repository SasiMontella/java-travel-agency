package org.lessons.java.travelAgency;

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
    public void getTravelInfo (){
        System.out.println("La tua fascia di età è: " + fasciaEta + "\n" + "Hai prenotato una vacanza per: " + getDestinazione() + " di " + calcoloGiorniVacanza() + " giorni, (dal " + getDataInizio() + " al " + getDataFine()+")" +
        "\n" + "Il gruppo sarà di: " + numeroGruppo + " persone");
    }

}
