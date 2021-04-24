package Objects;

public class Produkt {

    private int id;
    private String name;
    private int groesse;
    private double ekPreis;
    private double vkPreis;
    private int menge;

    public Produkt(int id, String name, int groesse, double ekPreis, double vkPreis, int menge)
    {
        this.id = id;
        this.name = name;
        this.groesse = groesse;
        this.ekPreis = ekPreis;
        this.vkPreis = vkPreis;
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
