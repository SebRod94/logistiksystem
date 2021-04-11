package Objects;

import java.util.ArrayList;
import java.util.Collection;

public class Regal {
    /* Eine Produkt-ID pro Regal:*/
    private double kapazitaet;
    private int containedID;
    private int stueckzahl;

    public Regal (double kapazitaet)
    {
    this.kapazitaet = kapazitaet;
    }

    public void setKapazitaet(double kapazitaet) { this.kapazitaet = kapazitaet; }

    public double getKapazitaet() { return kapazitaet; }

    public void setContainedID(int containedID) { this.containedID = containedID; }

    public int getContainedID() { return containedID; }

    public void setStueckzahl(int stueckzahl) { this.stueckzahl = stueckzahl; }

    public int getStueckzahl() { return stueckzahl; }

}
