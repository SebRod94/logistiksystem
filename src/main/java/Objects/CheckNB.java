package Objects;

import Exceptions.KapazitaetErreichtException;
import Exceptions.KeinRegalException;
import Exceptions.NotFoundException;
import Lists.ArrList;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class CheckNB {

    public static void checkRM(Produkt produkt, Regal regal, int menge) throws Exception {

        if (regal.getAuslastung() + produkt.getGroesse()*menge <= regal.getKapazitaet()){
            nachbestellen(produkt, regal, menge);
        }
        else {
            System.out.println("Platz im Regal nicht ausreichend");
            System.out.println("Soll ein neues Regal der Kategorie " + regal.getKategorie() + " geschaffen werden? (y / n)");
            Scanner scanner = new Scanner(System.in);

            if (scanner.next().trim().toLowerCase().equals("y") ) {
                System.out.println("Bitte Kapazität eingeben (min: " + (produkt.getGroesse()*menge) + "):");
                int wunschKapazitaet = scanner.nextInt();

                Sektor zielSektor = null;
                for(Sektor sek : Lageruebersicht.getAllSektors())
                    if(sek.getRegale().stream().filter(r -> r.getId() == regal.getId()).findFirst().orElse(null) != null){
                        zielSektor = sek;
                        break;
                    }

                if(zielSektor == null)
                    throw new NotFoundException("Kein Passender Sektor der Kategorie " + regal.getKategorie() + " gefunden");

                Regal newRegal = new Regal(wunschKapazitaet, regal.getKategorie());
                zielSektor.addRegal(newRegal);
                nachbestellen(produkt, newRegal, menge);

            }
            else
                throw new KeinRegalException("Produkt kann nicht hinzugefügt werden, da vorhandene Regale nicht genügend Platz bieten.");


        }
    }


    private static void nachbestellen(Produkt produkt, Regal regal, int menge)
    {
        System.out.println("Nachbestellung ausgelöst");
        Map<String, Integer> nachbest = new HashMap<String, Integer>();
        nachbest.put(produkt.getId(), 5);
        new Nachbestellung(nachbest);

        regal.editAuslastung (produkt.getId(), menge, true);

        double gesamtpreis;
        gesamtpreis = produkt.getEkPreis() * menge;
        gesamtpreis = gesamtpreis * -1;
        Finanzen.finanzFluss(gesamtpreis);
    }

}