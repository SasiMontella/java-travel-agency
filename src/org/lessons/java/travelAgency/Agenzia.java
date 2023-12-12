package org.lessons.java.travelAgency;

import java.time.LocalDate;
import java.util.Scanner;

public class Agenzia {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);


        //chiedere se si vuole prenotare una vacanza
        boolean check = false;
        while (!check) {
            System.out.print("Vuoi prenotare una vacanza? (y/n)");
            String choise = scan.nextLine();
            if (choise.equals("y")) {

                System.out.println("vuoi una di queste vacanze specifiche?(inserisci il numero relativo alla scelta) 1-Viaggio di nozze 2-Viaggio di gruppo 3-No");
                String extra = scan.nextLine();
                if (extra.equals("1") || extra.equals("2") || extra.equals("3")) {

                    String destinazione = null;
                    while (destinazione == null || destinazione.isEmpty()) {
                        System.out.print("Scegli una destinazione: ");
                        String destinazioneScelta = scan.nextLine();
                        if (destinazioneScelta.isEmpty()) {
                            System.out.println("destinazione non valida");
                        }
                        destinazione = new String(destinazioneScelta);
                    }


                    LocalDate dataPartenza = null;
                    while (dataPartenza == null) {

                        System.out.println("inserisci la data di partenza yyyy-mm-gg");
                        String data = scan.nextLine();
                        if (data.isEmpty()) {
                            System.out.println("La data non può essere vuota");
                            continue;
                        }
                        LocalDate dataInizio = LocalDate.parse(data);
                        LocalDate dataAttuale = LocalDate.now();
                        if (dataInizio.isBefore(dataAttuale)) {
                            System.out.println("Non è una macchina del tempo");
                            continue;
                        }
                        dataPartenza = dataInizio;
                    }

                    LocalDate dataRitorno = null;
                    while (dataRitorno == null) {
                        System.out.println("inserisci la data di ritorno yyyy-mm-gg");
                        String data2 = scan.nextLine();
                        if (data2.isEmpty()) {
                            System.out.println("La data non può essere vuota");
                            continue;
                        }
                        LocalDate dataFine = LocalDate.parse(data2);
                        if (dataFine.isBefore(dataPartenza)) {
                            System.out.println("Non è una macchina del tempo");
                            continue;
                        }
                        dataRitorno = dataFine;
                    }


                    if (extra.equals("1")){
                        System.out.println("Aggiungi extra al tuo viaggio di nozze:");
                        System.out.println("Vuoi un massaggio di coppia? (y/n) ");
                        String massageChoice = scan.nextLine();
                        boolean massage = massageChoice.equals("y");
                        System.out.println("Vuoi l'accesso alla SPA? (y/n) ");
                        String spaChoice = scan.nextLine();
                        boolean spa = spaChoice.equals("y");
                        System.out.println("Vuoi i drink illimitati? (y/n) ");
                        String drinkChoice = scan.nextLine();
                        boolean drink = drinkChoice.equals("y");
                        ViaggioNozze nozze = new ViaggioNozze(destinazione, dataPartenza, dataRitorno, massage, spa, drink);
                        nozze.getTravelInfo();
                    }else if (extra.equals("2")){
                        System.out.println("In quanti siete?");
                        int numeroGruppo = Integer.parseInt(scan.nextLine());
                        System.out.println("Indicami la tua età");
                        int eta = Integer.parseInt(scan.nextLine());
                        String fasciaEta;
                        if (eta < 18){
                            fasciaEta = "minorenne";
                        }else if (eta > 60){
                            fasciaEta = "over 60";
                        } else {
                            fasciaEta = "maggiorenne";
                        }
                        ViaggioGruppo gruppo = new ViaggioGruppo(destinazione, dataPartenza, dataRitorno, numeroGruppo, fasciaEta);
                        gruppo.getTravelInfo();

                    }else if(extra.equals("3")){
                        System.out.println("Non sono stati selezionati extra");
                        Vacanza vacanza = new Vacanza(destinazione, dataPartenza, dataRitorno);
                        vacanza.getTravelInfo();
                    }


                    check = true;
                    break;
                }

            } else if (choise.equals("n")) {
                System.out.println("okay! Arrivederci");
                check = true;
                break;
            } else {
                System.out.println("attieniti alle regole");
            }
        }

        scan.close();
    }
}
