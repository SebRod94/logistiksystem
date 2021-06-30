package Objects;

import Datenverarbeitung.CSVReader;
import Exceptions.KapazitaetErreichtException;
import Exceptions.KeinRegalException;
import Exceptions.NotFoundException;

import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;


public class Produkt {

    private static int prodCnt = 1;
    private String id;
    private String name;
    private int groesse;
    private double ekPreis;
    private double vkPreis;
    private int menge;

    public Produkt(String name, int groesse, double ekPreis, double vkPreis, int menge) throws IllegalArgumentException, KeinRegalException, KapazitaetErreichtException {
        this.name = name;
        this.ekPreis = ekPreis;
        this.vkPreis = vkPreis;
        this.menge = menge;
        if (groesse<=4){
            this.groesse = groesse;
        } else {
            throw new IllegalArgumentException("Größe darf 4 nicht überschreiten.");
        }

        this.initialize(null);
    }

    public Produkt(String name, int groesse, double ekPreis, double vkPreis, int menge, Kategorie kategorie) throws IllegalArgumentException, KeinRegalException, KapazitaetErreichtException {
        this.name = name;
        this.ekPreis = ekPreis;
        this.vkPreis = vkPreis;
        this.menge = menge;
        if (groesse<=4){
            this.groesse = groesse;
        } else {
            throw new IllegalArgumentException("Größe darf 4 nicht überschreiten.");
        }

        this.initialize(kategorie);
    }

    private void initialize(Kategorie gewaehlteKat) throws KapazitaetErreichtException, KeinRegalException {

        //Einsortieren und ID-Ermittlung

        //Kategorie bestimmen
        if(gewaehlteKat == null){
            System.out.printf("Zu welcher Kategorie gehört das Produkt? Bitte Nummer eintippen:%n%n");
            Kategorie[] kategorien = Kategorie.values();
            for(Kategorie k : kategorien) {
                System.out.println(k.ordinal() + " " + k);
            }
            Scanner scanner = new Scanner(System.in);
            int index = Integer.parseInt(scanner.nextLine());
            gewaehlteKat = kategorien[index];
            scanner.close();
        }

        //Lagerübersicht abrufen
        Lager[] alleLager = new Lager[Lageruebersicht.getAlleLager().length];
        alleLager = Lageruebersicht.getAlleLager();

        String zielLagerID = "0";
        String zielSektorID = "0";
        Sektor zielSektor = null;
        String zielRegalID = "0";
        Regal reg = null;
        boolean regalGefunden = false;

        //Ziellager,-sektor und-regal ermitteln
        Scanner scanner = new Scanner(System.in);
        try {
            outerloop:
            for (Lager l : alleLager) {
                for (Sektor s : l.getSektoren()) {
                    if (s.getKategorie() == gewaehlteKat) {

                        zielLagerID = l.getId();
                        zielSektorID = s.getId();
                        zielSektor = s;
                        
                        for (Regal r : s.getRegale()) {
                            if (r.getKapazitaet() - r.getAuslastung() >= menge * groesse) {
                                zielRegalID = r.getId();
                                r.addProdukt(this);
                                regalGefunden = true;
                                break outerloop;
                            }
                        }
                    }
                }
            }

            if(zielSektor == null)
                throw new NotFoundException("Kein Passender Sektor der Kategorie " + gewaehlteKat + " gefunden");

            //Exception, falls Regale voll
            if (regalGefunden == false) {
                System.out.println("Kein passendes Regal mit genügend Platz für " + CSVReader.removeUmlauts(this.name) +
                        " vorhanden.\nSoll ein neues Regal der Kategorie " + gewaehlteKat + "geschaffen werden? (y / n)");
                String createNew = scanner.nextLine();
                if (createNew.trim().toLowerCase().equals("y") ) {
                    System.out.println("Bitte Kapazität eingeben (min: " + (groesse*menge) + "):");
                    int wunschKapazitaet = scanner.nextInt();

                    reg = new Regal(wunschKapazitaet, gewaehlteKat);
                    zielSektor.addRegal(reg);
                } else {
                    // Kein neues Regal erwünscht -> Abbruch
                    throw new KeinRegalException("Produkt kann nicht hinzugefügt werden, da vorhandene Regale nicht genügend Platz bieten.");
                }

                //Neues Regal erschaffen: Regal-ID beziehen und einsortieren
                zielRegalID = reg.getId();
                reg.addProdukt(this);
            }

            // Produkt-ID-Erstellung
            prodCnt++;
            Integer.toString(prodCnt);

            String strLagerID = zielLagerID;
            String strSektorID = zielSektorID;
            String strRegalID = zielRegalID;

            if(prodCnt < 10)
                id = strLagerID + strSektorID + strRegalID + "0" + prodCnt;
            else
                id = strLagerID + strSektorID + strRegalID + prodCnt;



        } catch (KeinRegalException | NotFoundException e) {
            e.printStackTrace();
        }
    }

    public int getMenge(){
        return menge;
    }

    public void setMenge(int menge){ this.menge = menge; }

    public void setId(String id) { this.id = id; }

    public String getId() { return id; }

    public void setName(String name) { this.name = name; }

    public String getName() { return name; }

    public void setGroesse(int groesse) { this.groesse = groesse; }

    public int getGroesse() {
        return groesse;
    }

    public void setEkPreis(double ekPreis) {
        this.ekPreis = ekPreis;
    }

    public double getEkPreis() {
        return ekPreis;
    }

    public void setVkPreis(double vkPreis) { this.vkPreis = vkPreis; }

    public double getVkPreis() { return vkPreis; }
}
