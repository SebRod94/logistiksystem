package Objects;

import Lists.ArrList;

public class Lager {

    private String name;
    private int groesse;
    private ArrList<Sektor> sektoren;

    public Lager(String name, int groesse){
        this.name = name;
        this.groesse = groesse;
        this.sektoren = new ArrList<>();
    }

    public Lager(String name, int groesse, ArrList<Sektor> sektors){
        this.name = name;
        this.groesse = groesse;
        this.sektoren = new ArrList<>();
        this.sektoren.addMany(sektors);
    }

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

    public void addSektoren(Sektor... sektoren) {
        this.sektoren.addMany(sektoren);
    }
}
