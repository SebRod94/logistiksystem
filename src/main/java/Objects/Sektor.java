package Objects;

import Lists.ArrList;

public class Sektor {

    private int id;
    private int groesse;
    private Kategorie kategorie;
    private ArrList<Regal> regale;

    public Sektor(int groesse) {
        this.groesse = groesse;
        this.regale = new ArrList<>();
    }

    public Sektor(int groesse, ArrList<Regal> regale) {
        this.groesse = groesse;
        this.regale = new ArrList<>();
        this.regale.addMany(regale);
    }

    public int getId() {
        return id;
    }

    public void setGroesse(int groesse) {
        this.groesse = groesse;
    }

    public int getGroesse() {
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
