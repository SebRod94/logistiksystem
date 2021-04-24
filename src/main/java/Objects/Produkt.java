package Objects;

import Lists.ArrList;

import java.util.Scanner;

public class Produkt {

    private static int prodCnt = 0;
    private int id;
    private String name;
    private int groesse;
    private double ekPreis;
    private double vkPreis;
    private int menge;

    public Produkt(String name, int groesse, double ekPreis, double vkPreis, int menge)
    {
        this.name = name;
        this.groesse = groesse;
        this.ekPreis = ekPreis;
        this.vkPreis = vkPreis;
        this.menge = menge;

        Scanner scanner = new Scanner(System.in);
        System.out.printf("Zu welcher Kategorie gehört das Produkt? Bitte Nummer eintippen:%n%n");
        Kategorie[] kategorien = Kategorie.values();
        for(Kategorie k : kategorien) {
            System.out.println(k.ordinal() + " " + k);
        }
        int index = Integer.parseInt(scanner.nextLine());
        scanner.close();
        Kategorie gewaehlteKat = kategorien[index];

        Lager[] alleLager = new Lager[Lageruebersicht.getAlleLager().length];
        alleLager = Lageruebersicht.getAlleLager();

        int zielLagerID = 0;
        int zielSektorID = 0;
        int zielRegalID = 0;

        for(Lager l : alleLager) {
            for (Sektor s : l.getSektoren().toArray()) {
                if (s.getKategorie() == gewaehlteKat) {
                    for (Regal r : s.getRegale().toArray()) {
                        if (r.getKapazitaet() - r.getAuslastung() >= menge) {
                            zielLagerID = l.getId();
                            zielSektorID = s.getId();
                            zielRegalID = r.getId();
                            break;
                        }
                    }
                    break;
                }
            }
            break;
        }
        prodCnt ++;

        String strLagerID = Integer.toString(zielLagerID);
        String strSektorID = Integer.toString(zielSektorID);
        String strRegalID = Integer.toString(zielRegalID);
        String strProdCnt = Integer.toString(prodCnt);

        String strProduktID = strLagerID + strSektorID + strRegalID + strProdCnt;

        this.id = Integer.parseInt(strProduktID);
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
