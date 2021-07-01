package Objects;

import Exceptions.KapazitaetErreichtException;
import Lists.ArrList;
import Lists.ProdukteBaum;

import java.util.Arrays;

public class Lageruebersicht {
    private static Lager[] alleLager = new Lager[3];

    public static void addLager(Lager lager) throws Exception {
        if (alleLager[alleLager.length - 1] != null) {
            throw new KapazitaetErreichtException("Maximale Zahl an Lagern bereits erreicht.");
        } else {
            for (int i = 0; i < alleLager.length; i++ ) {
                if (alleLager[i] == null) {
                    alleLager[i] = lager;
                    return;
                }
            }
        }
    }

    public static Lager[] getAlleLager(){ return alleLager; }

    public static ArrList<Sektor> getAllSektors(){
        ArrList<Sektor> sektors = new ArrList<>();
        Arrays.stream(alleLager).forEach(lager -> sektors.addMany(lager.getSektoren()));
        return sektors;
    }

    public static ProdukteBaum getAllProdukts()
    {
        ProdukteBaum produkteBaum = new ProdukteBaum();

        for(Lager lager : alleLager)
            for(Sektor sektor : lager.getSektoren())
                for(Regal regal : sektor.getRegale())
                {
                    produkteBaum.addMany(regal.getProdukte());
                }

        return produkteBaum;
    }
}