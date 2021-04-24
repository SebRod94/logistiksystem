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

    public Sektor (int groesse, ArrList<Regal> regale, Kategorie kategorie) {
        this.groesse = groesse;
        this.regale = new ArrList<>();
        this.regale.addMany(regale);
        this.kategorie = kategorie;
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

    public void setKategorie(Kategorie kategorie) { this.kategorie = kategorie; }

    public Kategorie getKategorie() { return kategorie; }

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
