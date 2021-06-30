package Objects;

import Exceptions.KapazitaetErreichtException;
import Lists.ArrList;

public class Lager {

    private String id;
    private String name;
    private int groesse;
    private ArrList<Sektor> sektoren;

    public Lager(String id, String name, int groesse){
        this.id = id;
        this.name = name;
        this.groesse = groesse;
        this.sektoren = new ArrList<>();



        try {
            Lageruebersicht.addLager(this);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Lager(String id, String name, int groesse, ArrList<Sektor> sektors){
        new Lager(id, name, groesse);

        this.sektoren.addMany(sektors);
    }

    public String getId() { return id ;}

    public void setName(String name) { this.name = name; }

    public String getName() { return name; }

    public void setGroessee(int groesse) {
        this.groesse = groesse;
    }

    public int getGroessee() {
        return groesse;
    }

    public ArrList<Sektor> getSektoren() {
        return sektoren;
    }

    public void addSektor(Sektor sektor) throws KapazitaetErreichtException {
        int auslastung = 0;

        for (Sektor s : this.getSektoren()){
            auslastung = auslastung + s.getGroesse();
        }
        if (groesse >= auslastung+sektor.getGroesse()){
            this.sektoren.add(sektor);
        } else {
            throw new KapazitaetErreichtException("Lagerkapazität überschritten. \n Zusätzlich benötigte Kapazität: " + (sektor.getGroesse() - ( groesse - auslastung)) + "\n Vorhandene Kapazität: " + (groesse-auslastung));
        }
    }

    public void addSektoren(Sektor... sektoren) {
        this.sektoren.addMany(sektoren);
    }
}
