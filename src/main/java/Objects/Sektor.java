package Objects;

import Lists.ArrList;

public class Sektor {

    private int id;
    private double groesse;
    private ArrList<Regal> regale;

    public Sektor(double groesse)
    {
        this.groesse = groesse;
        this.regale = new ArrList<>();
    }

    public Sektor(double groesse, ArrList<Regal> regale)
    {
        this.groesse = groesse;
        this.regale = new ArrList<>();
        this.regale.addMany(regale);
    }

    public int getId() {
        return id;
    }

    public void setGroesse(double groesse) {
        this.groesse = groesse;
    }

    public double getGroesse() {
        return groesse;
    }

    public ArrList<Regal> getRegale() {
        return regale;
    }

    public void addRegal(Regal... regals){
        this.regale.addMany(regals);
    }

    public void addRegale(ArrList<Regal> regale) {
        this.regale.addMany(regale);
    }
}
