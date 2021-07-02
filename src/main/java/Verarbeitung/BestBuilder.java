package Verarbeitung;

import Exceptions.VorgAbgException;
import Lists.ProdukteBaum;
import Objects.Lageruebersicht;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class BestBuilder {
    public static Map<String, Integer> bestBuilder() throws VorgAbgException, NoSuchElementException, Exception {
        ProdukteBaum produkteBaum = Lageruebersicht.getAllProdukts();
        Lageruebersicht.productOverview();

        Scanner s = new Scanner(System.in);
        System.out.println("Wie viele verschiedene Waren umfasst die Bestellung?");
        int positionen = Integer.parseInt(s.nextLine());



        Map<String, Integer> bestellung = new HashMap<String, Integer>();
        for (int i = 1; i == positionen; i++) {
            System.out.println("Bitte geben Sie Produkt-ID und Menge mit Leerzeichen getrennt ein. (" + i + "/" + positionen + ")");
            String id;
            int menge;
            id = s.next();
            menge = s.nextInt();

            if (bestellung.containsKey(id)) {
                System.out.println("Produkt-ID " + id + " wurde bereits hinzugefügt. Bitte fahren Sie mit der nächsten ID und Menge fort.");
                continue;
            }

            String finalId = id;
            while (produkteBaum.stream().filter(produkt -> produkt.getId().equals(finalId)).findFirst().orElse(null) == null) {
                System.out.println("Produkt-ID " + id + " existiert nicht. Möchten Sie: \n(1) die ID korrigieren \n(2) mit dem nächsten Produkt fortfahren \n (3) den Bestellvorgang abbrechen");
                int antwort = s.nextInt();

                switch (antwort) {
                    case 1:
                        System.out.println("Bitte korrigierte Produkt-ID eintippen:");
                        id = s.next();
                    case 2:
                        continue;
                    case 3:
                        throw new VorgAbgException("Bestellvorgang wunschgemäß abgebrochen.");
                    default:
                        throw new NoSuchElementException("Ungültige Eingabe.");
                }
            }
            bestellung.put(id, menge);
            Versand.Packen(bestellung);
        }
        s.close();
        return bestellung;
    }

}
