package Objects;

import Exceptions.KapazitaetErreichtException;
import Lists.ArrList;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class Sektor {

    private static int sektorCnt = 1;
    private int id;
    private int groesse;
    private Kategorie kategorie;
    private ArrList<Regal> regale;

    public Sektor (int groesse, Kategorie kategorie) throws KapazitaetErreichtException {
        this.groesse = groesse;
        this.regale = new ArrList<>();
        this.kategorie = kategorie;
        this.id = sektorCnt;

        Regal regal1 = new Regal(10, kategorie);

        this.addRegal(regal1);
    }

    public int getId() {
        return id;
    }

    public void setGroesse(int groesse) {
        this.groesse = groesse;
    }

    public int getGroesse() {
        return groesse;
    }

    public void setKategorie(Kategorie kategorie) { this.kategorie = kategorie; }

    public Kategorie getKategorie() { return kategorie; }

    public ArrList<Regal> getRegale() {
        return regale;
    }

    public void addRegal(Regal regal) throws KapazitaetErreichtException {
        int auslastung=0;
        for (Regal r : this.getRegale()){
            auslastung= auslastung + r.getKapazitaet();
        }
        if (groesse>auslastung+regal.getKapazitaet()) {
            this.regale.add(regal);
        } else {
            throw new KapazitaetErreichtException("Sektorkapazität überschritten. \n Zusätzlich benötigte Kapazität: " + (regal.getKapazitaet() - (groesse-auslastung)) + "\n Vorhandene Kapazität: " + (groesse-auslastung));
        }

        }

    public void addRegale(ArrList<Regal> regale) {
        this.regale.addMany(regale);
    }
}
