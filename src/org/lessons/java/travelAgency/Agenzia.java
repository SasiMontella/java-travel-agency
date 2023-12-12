package org.lessons.java.travelAgency;

import java.time.LocalDate;
import java.util.Scanner;

public class Agenzia {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String destinazione;
        LocalDate dataPartenza;
        LocalDate dataRitorno;
        //chiedere se si vuole prenotare una vacanza
        boolean check = false;
        while (!check) {
            System.out.println("Vuoi prenotare una vacanza? (y/n)");
            String choise = scan.nextLine();
            if (choise.equals("y")) {
                 destinazione = null;
                while (destinazione == null || destinazione.isEmpty()) {

                    System.out.print("Scegli una destinazione");
                    String destinazioneScelta = scan.nextLine();
                   if (destinazioneScelta.isEmpty()){
                       System.out.println("destinazione non valida");
                   }
                   destinazione = new String(destinazioneScelta);
                }

                boolean validDate = false;
                while (!validDate) {
                    validDate = true;
                    System.out.println("inserisci la data di partenza yyyy-mm-gg");
                    String data = scan.nextLine();
                    if(data.isEmpty()){
                        System.out.println("La data non può essere vuota");
                        validDate = false;
                        continue;
                    }
                    LocalDate dataInizio = LocalDate.parse(data);
                    LocalDate dataAttuale = LocalDate.now();
                    if (dataInizio.isBefore(dataAttuale)) {
                        System.out.println("Non è una macchina del tempo");
                        validDate = false;
                        continue;
                    }
                    dataPartenza = dataInizio;

                    System.out.println("inserisci la data di ritorno yyyy-mm-gg");
                    String data2 = scan.nextLine();
                    if(data2.isEmpty()){
                        System.out.println("La data non può essere vuota");
                        validDate = false;
                        continue;
                    }
                    LocalDate dataFine = LocalDate.parse(data2);
                    if (dataFine.isBefore(dataPartenza)) {
                        System.out.println("Non è una macchina del tempo");
                        validDate = false;
                        continue;
                    }
                    dataRitorno = dataFine;
                }
                Vacanza vacanza = new Vacanza(destinazione, dataPartenza, dataRitorno);

                check = true;
                break;

            } else if (choise.equals("n")) {
                System.out.println("okay! Arrivederci");
                check = true;
                break;
            } else {
                System.out.println("attieniti alle regole");
            }
        }


        //scegliere destinazione, data inizio e fine
        //generare oggetto vacanza
        //stampare prenotazione


    }
}
