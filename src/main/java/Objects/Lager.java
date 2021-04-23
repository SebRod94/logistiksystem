package Objects;

import Lists.ArrList;

public class Lager {

    private String lagername;
    private double groesse;
    private ArrList<Sektor> sektoren;

    public Lager(double groesse){
        this.groesse = groesse;
        this.sektoren = new ArrList<>();
    }

    public Lager(double groesse, ArrList<Sektor> sektors){
        this.groesse = groesse;
        this.sektoren = new ArrList<>();
        this.sektoren.addMany(sektors);
    }

    public void setGroessee(double groesse) {
        this.groesse = groesse;
    }

    public double getGroessee() {
        return groesse;
    }

    public ArrList<Sektor> getSektoren() {
        return sektoren;
    }

    public void addSektoren(Sektor... sektoren) {
        this.sektoren.addMany(sektoren);
    }
}
