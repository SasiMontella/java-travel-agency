package org.lessons.java.travelAgency;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Agenzia {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);



        //chiedere se si vuole prenotare una vacanza
        boolean check = false;
        while (!check) {
            System.out.println("Vuoi prenotare una vacanza? (y/n)");
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

                        List <Escursione> escursioneUtente = askEscursioni(scan);
                        nozze.setEscursioni(escursioneUtente);

                        nozze.toString();
                    }
                    else if (extra.equals("2")){
                        System.out.println("Hai scelto un viaggio di gruppo.");
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

                        List <Escursione> escursioneUtente = askEscursioni(scan);
                        gruppo.setEscursioni(escursioneUtente);

                        gruppo.toString();

                    }else if(extra.equals("3")){
                        System.out.println("Non sono stati selezionati extra");
                        Vacanza vacanza = new Vacanza(destinazione, dataPartenza, dataRitorno);
                        List <Escursione> escursioneUtente = askEscursioni(scan);
                        vacanza.setEscursioni(escursioneUtente);
                        vacanza.toString();
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
       /* Escursione escursione = new Escursione("Roma", 23);
        System.out.println(escursione.toString());*/

        scan.close();
    }
    public static List<Escursione> askEscursioni (Scanner scan){
        ArrayList <Escursione> escursioni = new ArrayList<>();
        boolean stop = false;
        while (!stop) {
            System.out.println("Vuoi aggiungere un'escursione alla tua vacanza? (y/n)");
            String gita = scan.nextLine();
            if (gita.equals("y")) {
                System.out.println("In che città vuoi fare l'escursione? ");
                String citta = scan.nextLine();
                System.out.println("Quanto vuoi far durare l'escursione? ");
                int durata = Integer.parseInt(scan.nextLine());
                Escursione escursione = new Escursione(citta, durata);
                escursioni.add(escursione);

            } else if (gita.equals("n")) {
                System.out.println("okay :c");
                //vacanza.setEscursioni(escursioni);
                stop = true;
            } else {
                System.out.println("dovresti inserire una scelta valida");
            }
        }
        return escursioni;
    }
}
