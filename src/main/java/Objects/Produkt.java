package Objects;

import Exceptions.KapazitaetErreichtException;
import Exceptions.KeinRegalException;

import java.util.Scanner;


public class Produkt {

    private static int prodCnt = 0;
    private int id;
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
            throw new IllegalArgumentException("Größe darf nicht größer als Vier sein!");
        }

        this.initialize();
    }

    private void initialize() throws KapazitaetErreichtException, KeinRegalException {

        //ID-Ermittlung und Produkt zu Regal hinzufügen

        System.out.printf("Zu welcher Kategorie gehört das Produkt? Bitte Nummer eintippen:%n%n");
        Kategorie[] kategorien = Kategorie.values();
        for(Kategorie k : kategorien) {
            System.out.println(k.ordinal() + " " + k);
        }
        Scanner scanner = new Scanner(System.in);
        int index = Integer.parseInt(scanner.nextLine());
        Kategorie gewaehlteKat = kategorien[index];
        scanner.close();

        Lager[] alleLager = new Lager[Lageruebersicht.getAlleLager().length];
        alleLager = Lageruebersicht.getAlleLager();

        int zielLagerID = 0;
        int zielSektorID = 0;
        Sektor zielSektor = null;
        int zielRegalID = 0;
        Regal reg = null;
        boolean regalGefunden = false;
        
        try {
            for (Lager l : alleLager) {
                for (Sektor s : l.getSektoren().toArray()) {
                    if (s.getKategorie() == gewaehlteKat) {

                        zielLagerID = l.getId();
                        zielSektorID = s.getId();
                        zielSektor = s;
                        
                        for (Regal r : s.getRegale().toArray()) {
                            if (r.getKapazitaet() - r.getAuslastung() >= menge * groesse) {
                                zielRegalID = r.getId();
                                r.addProdukt(this);
                                regalGefunden = true;
                                break;
                            }
                        }
                        break;
                    }
                }
                break;
            }

            if (regalGefunden == false) {
                throw new KapazitaetErreichtException("Kein Regalplatz verfügbar.");
            }

        } catch (KapazitaetErreichtException e) {
            e.printStackTrace();

            Scanner s = new Scanner(System.in);
            String createNew = s.nextLine();
            System.out.println("Soll ein neues Regal geschaffen werden? (y / n)");

            if (createNew == "y" ) {
                System.out.println("Bitte Kapazität eingeben:");
                int wunschKapazitaet = s.nextInt();
                s.close();
                Regal r = new Regal(wunschKapazitaet);
                zielSektor.addRegal(r);
            } else {
                throw new KeinRegalException("Produkt kann nicht hinzugefügt werden, da vorhandene Regale nicht genügend Platz bieten.");
            }

            zielRegalID = reg.getId();
            reg.addProdukt(this);

        } finally {

            prodCnt++;

            String strLagerID = Integer.toString(zielLagerID);
            String strSektorID = Integer.toString(zielSektorID);
            String strRegalID = Integer.toString(zielRegalID);
            String strProdCnt;
            if (prodCnt < 10) {
                strProdCnt = "0" + Integer.toString(prodCnt);
            } else {
                strProdCnt = Integer.toString(prodCnt);
            }

            String strProduktID = strLagerID + strSektorID + strRegalID + strProdCnt;

            this.id = Integer.parseInt(strProduktID);
        }
    }

    public int getMenge(){
        return menge;
    }

    public void setMenge(int menge){
        this.menge = menge;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setGroesse(int groesse) {
        this.groesse = groesse;
    }

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
