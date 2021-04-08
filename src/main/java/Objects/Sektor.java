package Objects;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class Sektor {

    private double groesse;
    private Collection<Regal> regale;

    public Sektor(double groesse)
    {
        this.groesse = groesse;
        this.regale = new ArrayList<>();
    }

    public Sektor(double groesse, Collection<Regal> regale)
    {
        this.groesse = groesse;
        this.regale = new ArrayList<>();
        this.regale.addAll(regale);
    }

    public void setGroesse(double groesse) {
        this.groesse = groesse;
    }

    public double getGroesse() {
        return groesse;
    }

    public Collection<Regal> getRegale() {
        return regale;
    }

    public void addRegal(Regal... regals){
        this.regale.addAll(Arrays.asList(regals));
    }
}
