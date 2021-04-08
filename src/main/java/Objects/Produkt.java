package Objects;

public class Produkt {

    private int id;
    private String name;
    private double gewicht;
    private double preis;

    public Produkt(int id, String name, double gewicht, double preis)
    {
        this.id = id;
        this.name = name;
        this.gewicht = gewicht;
        this.preis = preis;
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

    public void setGewicht(double gewicht) {
        this.gewicht = gewicht;
    }

    public double getGewicht() {
        return gewicht;
    }

    public void setPreis(double preis) {
        this.preis = preis;
    }

    public double getPreis() {
        return preis;
    }
}
