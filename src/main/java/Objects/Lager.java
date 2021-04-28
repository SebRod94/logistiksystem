package Objects;

import Lists.ArrList;

import java.util.NoSuchElementException;

public class Lager {

    private int id;
    private String name;
    private int groesse;
    private ArrList<Sektor> sektoren;

    public Lager(int id, String name, int groesse){
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

    public Lager(int id, String name, int groesse, ArrList<Sektor> sektors){
        this.id = id;
        this.name = name;
        this.groesse = groesse;
        this.sektoren = new ArrList<>();
        this.sektoren.addMany(sektors);
    }

    public int getId() { return id ;}

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

    public void addSektor(Sektor sektor){
        int auslastung = 0;
        for (Sektor s : this.getSektoren().toArray()){
            auslastung = auslastung + s.getGroesse();
        }
        if (groesse>auslastung+sektor.getGroesse()){
            this.sektoren.add(sektor);
        } else {
            throw new NoSuchElementException("Kapazität überschritten. \n Erforderliche Kapazität: "+ sektor.getGroesse() + "\n Vorhandene Kapazität: " + (groesse-auslastung));
        }
    }

    public void addSektoren(Sektor... sektoren) {
        this.sektoren.addMany(sektoren);
    }
}
