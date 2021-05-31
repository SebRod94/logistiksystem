package Objects;

import Lists.ArrList;
public class Finanzen {

    double kontoguthaben = 5000.00;
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


    private void pruefeGuthaben(){
        if (kontoguthaben >= 1000){
            System.out.println("Kontoguthaben sehr niedrig");
        } else if (kontoguthaben >= 2000){
            System.out.println("Kontoguthaben niedrig");
        } else {
            System.out.println("Genügend Kontoguthaben vorhanden");
        }


    }



}

