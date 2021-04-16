package Objects;

import java.util.ArrayList;
import java.util.Collection;

public class Regal {
    /* Eine Produkt-ID pro Regal:*/
    private ArrList<Produkt> produkte;
    private double kapazitaet;
    private int id;
    private double stueckzahl;

    public Regal()
    {
        this.produkte = new ArrList<>();
    }

    public Regal (double kapazitaet, ArrList<Produkt> produkte)
    {
        this.kapazitaet = kapazitaet;
        this.produkte = produkte;
    }

    public void setKapazitaet(double kapazitaet) { this.kapazitaet = kapazitaet; }

    public double getKapazitaet() { return kapazitaet; }

    public void setContainedID(int id) { this.id = id; }

    public int getContainedID() { return id; }

    public void setStueckzahl(int stueckzahl) { this.stueckzahl = stueckzahl; }

    public double getStueckzahl() { return stueckzahl; }
    public ArrList<Produkt> getProdukte() {
        return produkte;
    }

    public void addProdukte(Produkt... produkte)
    {
        this.produkte.addMany(produkte);
    }

    public void addProdukte(ArrList<Produkt> produkte)
    {
        this.produkte.addMany(produkte);
    }
}
