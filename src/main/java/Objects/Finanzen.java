package Objects;

import Lists.ArrList;
public class Finanzen {

    private static double kontoguthaben = 5000.00;

    public double finanzFluss(double gesamtpreis){
         kontoguthaben += gesamtpreis;
        return kontoguthaben;
    }


    public void setKontoguthaben(double kontoguthaben){
        kontoguthaben = kontoguthaben;
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

