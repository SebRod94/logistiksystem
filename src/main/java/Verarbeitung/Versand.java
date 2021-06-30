package Verarbeitung;

import Objects.*;
import Lists.ProdukteBaum;

import java.util.Map;

public class Versand {
    public void Packen (Map<Integer, Integer> orderedIds) throws Exception {

        String produktId = "0";
        int bestellteMenge = 0;
        int groesse;
        int vorhandeneMenge;
        int paketgroesse = 0;
        int versandkosten = 0;
        double gesamtpreis = 0;

        for( var key : orderedIds.keySet()){
            produktId = String.valueOf(key);
            bestellteMenge = orderedIds.get(key);



            for(Lager lager : Lageruebersicht.getAlleLager())
                for(Sektor sektor : lager.getSektoren())
                    for(Regal regal : sektor.getRegale())
                        for(Produkt produkt : regal.getProdukte()){
                            if (produkt.getId() == produktId){
                                groesse = produkt.getGroesse();
                                vorhandeneMenge = produkt.getMenge();
                                if(vorhandeneMenge < bestellteMenge){
                                    CheckNB.checkRM( produkt,  regal);
                                    throw new Exception("Kann nicht in vollem Umfang geliefert werden.");

                                }
                                else{
                                    produkt.setMenge(vorhandeneMenge - bestellteMenge);
                                    CheckNB.checkRM(produkt, regal);
                                    regal.editAuslastung(produktId, bestellteMenge, false);
                                }
                                paketgroesse += groesse * bestellteMenge;
                            }
                        }

            ProdukteBaum produkteBaum = Lageruebersicht.getAllProdukts();
            String Id = key.toString();
            Produkt prod = produkteBaum.stream().filter(produkt -> produkt.getId().equals(Id)).findFirst().orElse(null);
            gesamtpreis = (prod.getEkPreis() * bestellteMenge);
        }
        if (paketgroesse <= 10) {
            versandkosten = 5;
        }
        else if(paketgroesse> 10 && paketgroesse <= 20) {
            versandkosten = 15;
        }
        else if(paketgroesse>20 && paketgroesse <= 35) {
            versandkosten = 25;
        }
        else if(paketgroesse > 35){
            versandkosten = 55;

        }
        gesamtpreis += versandkosten;

    }

}
