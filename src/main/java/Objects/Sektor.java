package Objects;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class Sektor {

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
}
