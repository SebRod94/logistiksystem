package Objects;

public class Regal {
    private ArrList<Produkt> produkte;

    public Regal()
    {
        this.produkte = new ArrList<>();
    }

    public Regal(ArrList<Produkt> produkte)
    {
        this.produkte = produkte;
    }

    public void setProdukte(ArrList<Produkt> produkte) {
        this.produkte = produkte;
    }

    public ArrList<Produkt> getProdukte() {
        return produkte;
    }

    public void addProdukte(Produkt... produkte)
    {
        this.produkte.addMany(produkte);
    }

    public void addProdukte(ArrList<Produkt> produkte)
    {
        this.produkte.addMany(produkte);
    }
}
