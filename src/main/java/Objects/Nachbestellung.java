package Objects;

import Exceptions.KapazitaetErreichtException;
import Lists.ArrList;

public class Nachbestellung {

    public Nachbestellung(Produkt s, Regal regal) throws Exception {
        s.setMenge(3);
        //Nachbestellung 3x das Produkt(Menge)

        if (mengeBestellungVergleich() == true){
            if (mengenvergleich(s, regal)<=3) {
                if (platzabgleich(s, regal) == true){
                    System.out.println("Nachbestellung ausgelöst");
                    regal.addProdukt(s);
                } else {
                    throw new Exception("Platz im Regal nicht ausreichend");
                    //Neues Regal hinzufügen?
                }
            } else {
                throw new Exception("Menge hat keinen Platz im Regal");
            }
        } else {
            throw new Exception("Lagerbestand für Bestellung nicht ausreichend");
        }

    }

// platzabgleich regal
    private boolean platzabgleich(Produkt s, Regal regal){
        if (regal.getAuslastung()<= 7){
           return true;
        }else {
            return false;
        }
    }
// mengenvergleich regal
    private int mengenvergleich(Produkt s, Regal regal){
        String name = s.getName();
        ArrList<Produkt> produkteregal1 = regal.getProdukte();
        Produkt[] produkteregal= produkteregal1.toArray();
        int menge = 0;
        for (int i=0; i< produkteregal.length;i++){
            if (produkteregal[i].getName().equals(name)){
                menge += produkteregal[i].getMenge();
            }
        }
        menge=menge*s.getGroesse();
        return menge;
    }
// mengenvergleich Bestellung - warte auf Methode Bestellung...
    private boolean mengeBestellungVergleich(){
        return true;
    }


// konto änderungen mit ek/vk preis
    private double einkaufspreis(Produkt s){
        double einkaufspreis = s.getMenge()*s.getEkPreis();
        return einkaufspreis*3;
        //*3, da 3 Mengeneinheiten nachbestellt
    }
}