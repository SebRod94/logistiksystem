package Verarbeitung;

import Objects.*;
import Lists.ProdukteBaum;

import java.util.Map;

public class Versand {
    public static void Packen (Map<String, Integer> orderedIds) throws Exception {

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


            outerloop:
            for(Lager lager : Lageruebersicht.getAlleLager())
                for(Sektor sektor : lager.getSektoren())
                    for(Regal regal : sektor.getRegale())
                        for(Produkt produkt : regal.getProdukte()){
                            if (produkt.getId().equals(produktId)){
                                groesse = produkt.getGroesse();
                                vorhandeneMenge = produkt.getMenge();
                                if(vorhandeneMenge < bestellteMenge){
                                    CheckNB.checkRM( produkt,  regal, vorhandeneMenge - bestellteMenge + 3);
                                    throw new Exception("Kann nicht in vollem Umfang geliefert werden.");
                                }
                                else{
                                    produkt.setMenge(vorhandeneMenge - bestellteMenge);
                                    regal.editAuslastung(produktId, bestellteMenge, false);
                                    if(produkt.getMenge() < 3)
                                        CheckNB.checkRM(produkt, regal, 3 - produkt.getMenge());

                                }
                                paketgroesse += groesse * bestellteMenge;
                                break outerloop;
                            }
                        }

            ProdukteBaum produkteBaum = Lageruebersicht.getAllProdukts();
            String Id = key.toString();
            Produkt prod = produkteBaum.stream().filter(produkt -> produkt.getId().equals(Id)).findFirst().orElse(null);
            gesamtpreis = (prod.getVkPreis() * bestellteMenge);
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
        Finanzen.finanzFluss(gesamtpreis);

    }

}
