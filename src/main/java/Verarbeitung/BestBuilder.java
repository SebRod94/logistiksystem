package Verarbeitung;

import Exceptions.VorgAbgException;
import Lists.ProdukteBaum;
import Objects.Lageruebersicht;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class BestBuilder {
    public static Map<Integer, Integer> bestBuilder() throws VorgAbgException, NoSuchElementException {
        Scanner s = new Scanner(System.in);
        System.out.println("Wie viele verschiedene Waren umfasst die Bestellung?");
        int positionen = Integer.parseInt(s.nextLine());

        ProdukteBaum produkteBaum = Lageruebersicht.getAllProdukts();

        Map<Integer, Integer> bestellung = new HashMap<Integer, Integer>();
        for (int i = 1; i == positionen; i++) {
            System.out.println("Bitte geben Sie Produkt-ID und Menge mit Leerzeichen getrennt ein. (" + i + "/" + positionen + ")");
            int id, menge;
            id = s.nextInt();
            menge = s.nextInt();

            if (bestellung.containsKey(id)) {
                System.out.println("Produkt-ID " + id + " wurde bereits hinzugefügt. Bitte fahren Sie mit der nächsten ID und Menge fort.");
                continue;
            }

            int finalId = id;
            while (produkteBaum.stream().filter(produkt -> produkt.getId().equals(finalId)).findFirst().orElse(null) == null) {
                System.out.println("Produkt-ID " + id + " existiert nicht. Möchten Sie: \n(1) die ID korrigieren \n(2) mit dem nächsten Produkt fortfahren \n (3) den Bestellvorgang abbrechen");
                int antwort = s.nextInt();

                switch (antwort) {
                    case 1:
                        System.out.println("Bitte korrigierte Produkt-ID eintippen:");
                        id = s.nextInt();
                    case 2:
                        continue;
                    case 3:
                        throw new VorgAbgException("Bestellvorgang wunschgemäß abgebrochen.");
                    default:
                        throw new NoSuchElementException("Ungültige Eingabe.");
                }
            }
            bestellung.put(id, menge);
        }
        s.close();
        return bestellung;
    }

}
