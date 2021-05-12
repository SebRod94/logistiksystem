package Objects;

public class Finanzen {

    double kontoguthaben;
    char waehrung;



    public void setWaehrung(char waehrung){
        this.waehrung = waehrung;
    }

    public double getWaehrung(){
        return waehrung;
    }

    public void setKontoguthaben(double kontoguthaben){
        this.kontoguthaben = kontoguthaben;
    }

    public double getKontoguthaben(){
        return kontoguthaben;
    }
}

