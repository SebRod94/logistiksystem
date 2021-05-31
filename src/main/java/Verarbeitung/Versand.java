package Verarbeitung;

import Objects.Produkt;
import Objects.Lager;
import Objects.Lageruebersicht;
import Objects.Regal;
import Objects.Sektor;

public class Versand {
    public void Packen (int[][] orderedIds) throws Exception {
        int produktId = 0;
        int bestellteMenge = 0;
        int groesse;
        int vorhandeneMenge;
        int paketgroesse = 0;
        int versandkosten;

        for( int i =0; i< orderedIds.length ; i++){
                orderedIds[i][0] = produktId;
                orderedIds[i][1] = bestellteMenge;


            for(Lager lager : Lageruebersicht.getAlleLager())
                for(Sektor sektor : lager.getSektoren().toArray())
                    for(Regal regal : sektor.getRegale().toArray())
                        for(Produkt produkt : regal.getProdukte().toArray()){
                            if (produkt.getId() == produktId){
                                groesse = produkt.getGroesse();
                                vorhandeneMenge = produkt.getMenge();
                                if(vorhandeneMenge < bestellteMenge){
                                    throw new Exception("Kann nicht in vollem Umfang geliefert werden.");
                                }
                                else{
                                    produkt.setMenge(vorhandeneMenge - bestellteMenge);
                                }
                                paketgroesse += groesse * bestellteMenge;
                            }
                        }
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

    }
}
