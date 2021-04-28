package Objects;

import Lists.ArrList;

import java.util.NoSuchElementException;

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

    public void setKapazitaet(int kapazitaet) {
        this.kapazitaet = kapazitaet;
    }

    public int getKapazitaet() {
        return kapazitaet;
    }

    public void setAuslastung(int auslastung) {
        this.auslastung = auslastung;
    }

    public int getAuslastung() {
        return auslastung;
    }

    public int getId() {
        return id;
    }

    public ArrList<Produkt> getProdukte() {
        return produkte;
    }

    public void addProdukt(Produkt produkt){
        this.produkte.add(produkt);
        auslastung = getAuslastung()+(produkt.getMenge()*produkt.getGroesse());
    }

    public void addProdukte(Produkt... produkte)
    {
        for(Produkt produkt : produkte)
            addProdukt(produkt);
    }

    public void addProdukte(ArrList<Produkt> produkte)
    {
        this.produkte.addMany(produkte);
    }
}
