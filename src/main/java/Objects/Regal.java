package Objects;

import Lists.ArrList;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class Regal {
    private static int regalCnt = 1;
    private int id;
    private Kategorie kategorie;
    private int kapazitaet;
    private int auslastung;
    private ArrList<Produkt> produkte;


    public Regal (int kapazitaet, ArrList<Produkt> produkte) throws Exception {
        this.kapazitaet = kapazitaet;
        this.produkte = produkte;
        this.id = regalCnt;
        regalCnt++;

        System.out.printf("Zu welcher Kategorie gehört das Regal? Bitte Nummer eintippen:%n%n");
        Kategorie[] kategorien = Kategorie.values();
        for(Kategorie k : kategorien) {
            System.out.println(k.ordinal() + " " + k);
        }
        Scanner scanner = new Scanner(System.in);
        int index = Integer.parseInt(scanner.nextLine());
        this.kategorie = kategorien[index];
        scanner.close();
        Lager[] lager = Lageruebersicht.getAlleLager();
        ArrList<Sektor> sektoren = new ArrList<Sektor>();
        for (int i = 0; i< lager.length;i++){
            sektoren = lager[i].getSektoren();
        }
        Sektor[] alleSektoren = sektoren.toArray();
        for (int i=0;i<alleSektoren.length;i++){
            if (alleSektoren[i].getKategorie() == kategorie){
                alleSektoren[i].addRegal(this);
            }
        }



    }

    public Regal (int kapazitaet) {
        this.kapazitaet = kapazitaet;
        this.produkte = new ArrList<Produkt>();
        this.id = regalCnt;
        regalCnt++;
    }

    public static int getRegalCnt() { return regalCnt; }

    public void setKapazitaet(int kapazitaet) {
        this.kapazitaet = kapazitaet;
    }

    public int getKapazitaet() {
        return kapazitaet;
    }

    public void setAuslastung(int auslastung) {
        this.auslastung = auslastung;
    }

    public int getAuslastung() {
        return auslastung;
    }

    public int getId() {
        return id;
    }

    public ArrList<Produkt> getProdukte() {
        return produkte;
    }

    public void addProdukt(Produkt produkt){
        if (this.auslastung< (produkt.getMenge()*produkt.getGroesse())) {
            this.produkte.add(produkt);
            this.auslastung = getAuslastung() + (produkt.getMenge() * produkt.getGroesse());
        }else {
            throw new NoSuchElementException("Regalkapazität überschritten. \n Erforderliche Kapazität: " + (produkt.getGroesse()*produkt.getMenge() - (kapazitaet-auslastung)) + "\n Vorhandene Kapazität: " + (kapazitaet-auslastung));
        }
    }

    public void addProdukte (Produkt... produkte)
    {
        for(Produkt produkt : produkte)
            addProdukt(produkt);
    }

    public void addProdukte(ArrList<Produkt> produkte)
    {
        this.produkte.addMany(produkte);
    }
}
