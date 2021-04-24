package Objects;

import Lists.ArrList;

public class Regal {
    private int id;
    private int kapazitaet;
    private int auslastung;
    private ArrList<Produkt> produkte;


    public Regal()
    {
        this.produkte = new ArrList<>();
    }

    public Regal (int kapazitaet, ArrList<Produkt> produkte)
    {
        this.kapazitaet = kapazitaet;
        this.produkte = produkte;
    }

    public void setKapazitaet(int kapazitaet) { this.kapazitaet = kapazitaet; }

    public int getKapazitaet() { return kapazitaet; }

    public void setAuslastung(int auslastung) { this.auslastung = auslastung; }

    public int getAuslastung() { return auslastung; }

    public int getId() { return id; }

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
