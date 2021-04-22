package Objects;

import Lists.ArrList;

public class Regal {
    /* Eine Produkt-ID pro Regal:*/
    private int id;
    private double kapazitaet;
    private double stueckzahl;
    private ArrList<Produkt> produkte;


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

    public int getId() { return id; }

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
