package Objects;

import Exceptions.KapazitaetErreichtException;
import Lists.ArrList;
import Lists.ProdukteBaum;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class Regal {
    private static int regalCnt = 1;
    private String id;
    private Kategorie kategorie;
    private int kapazitaet;
    private int auslastung;
    private ArrList<Produkt> produkte;

    public Regal (int kapazitaet, Kategorie kategorie) throws KapazitaetErreichtException {
        this.kapazitaet = kapazitaet;
        this.produkte = new ArrList<Produkt>();
        if(regalCnt < 10)
            this.id = "0"+regalCnt;
        else
            this.id = Integer.toString(regalCnt);
        this.kategorie = kategorie;
        regalCnt++;
    }

    public Regal (int kapazitaet, ArrList<Produkt> produkte) throws Exception {
        this.kapazitaet = kapazitaet;
        this.produkte = produkte;
        this.id = Integer.toString(regalCnt);
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
        //Iterator
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

    public Regal (int kapazitaet) throws KapazitaetErreichtException {
        this.kapazitaet = kapazitaet;
        this.produkte = new ArrList<Produkt>();
        this.id = Integer.toString(regalCnt);
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
        //Iterator
        Lager[] lager = Lageruebersicht.getAlleLager();
        ArrList<Sektor> sektoren = new ArrList<Sektor>();
        for (int i = 0; i< lager.length;i++){
            sektoren = lager[i].getSektoren();
        }
        Sektor[] alleSektoren = sektoren.toArray();
        for (int i=0;i<alleSektoren.length;i++) {
            if (alleSektoren[i].getKategorie() == kategorie) {
                alleSektoren[i].addRegal(this);
            }
        }
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

    public Kategorie getKategorie(){
        return this.kategorie;
    }

    public String getId() {
        return id;
    }

    public ArrList<Produkt> getProdukte() {
        return produkte;
    }

    private void swap(ArrList<Produkt> produkte, int i, int j) {
        Produkt hilf = produkte.get(i);
        produkte.replace(i, j);
        produkte.set(j, hilf);
    }

    private void isort(ArrList<Produkt> produkte) {
        for (int i = 1; i < produkte.size(); i++) {

            Produkt x = produkte.get(i);

            int j = i-1;
            while (j >= 0 && produkte.get(j).getMenge() > x.getMenge()) {
                swap(produkte, j, j + 1);
                j--;
            }
            produkte.set(j+1,x);
        }
    }


    public void addProdukt(Produkt produkt){
        if (this.kapazitaet >= (produkt.getMenge()*produkt.getGroesse())) {
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

    public void editAuslastung (String id, int menge, boolean add) {
        ProdukteBaum produkteBaum = Lageruebersicht.getAllProdukts();
        Produkt prod = produkteBaum.stream().filter(produkt -> produkt.getId().equals(id)).findFirst().orElse(null);
        if (add) { this.auslastung += prod.getGroesse() * menge; }
        else { this.auslastung -= prod.getGroesse() * menge;}
    }
}
