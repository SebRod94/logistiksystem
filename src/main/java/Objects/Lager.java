package Objects;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class Lager {

    private double groesse;
    private Collection<Sektor> sektoren;

    public Lager(double groesse){
        this.groesse = groesse;
        this.sektoren = new ArrayList<>();
    }

    public Lager(double groesse, Collection<Sektor> sektors){
        this.groesse = groesse;
        this.sektoren = new ArrayList<>();
        this.sektoren.addAll(sektors);
    }

    public void setGroessee(double groesse) {
        this.groesse = groesse;
    }

    public double getGroessee() {
        return groesse;
    }

    public Collection<Sektor> getSektoren() {
        return sektoren;
    }

    public void addSektoren(Sektor... sektoren) {
        this.sektoren.addAll(Arrays.asList(sektoren));
    }
}
