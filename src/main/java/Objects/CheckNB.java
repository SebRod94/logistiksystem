package Objects;

import Exceptions.KapazitaetErreichtException;
import Lists.ArrList;

import java.util.HashMap;
import java.util.Map;


public class CheckNB {

    public static void checkRM(Produkt s, Regal regal) throws Exception {
        s.setMenge(3);
        //Nachbestellung 3x das Produkt(Menge)


        if (mengenvergleich(s, regal)<=3) {
            if (platzabgleich(s, regal) == true){
                System.out.println("Nachbestellung ausgelöst");
                Map<Integer, Integer> nachbest = new HashMap<Integer, Integer>();
                nachbest.put(s.getId(), 5);
                new Nachbestellung(nachbest);
            }
            else {
                throw new Exception("Platz im Regal nicht ausreichend");
                    //Neues Regal hinzufügen?
            }
        }
        else {
            throw new Exception("Nachbestellung nicht nötig");
        }
    }




// platzabgleich regal
    private static boolean platzabgleich(Produkt s, Regal regal){
        if (regal.getAuslastung()<= 7){
           return true;
        }else {
            return false;
        }
    }
// mengenvergleich regal
    private static int mengenvergleich(Produkt s, Regal regal){
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


// konto änderungen mit ek/vk preis
    private static double einkaufspreis(Produkt s){
        double einkaufspreis = s.getMenge()*s.getEkPreis();
        return einkaufspreis*3;
        //*3, da 3 Mengeneinheiten nachbestellt
    }
}