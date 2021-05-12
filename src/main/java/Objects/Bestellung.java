package Objects;

import java.util.Date;
import java.text.SimpleDateFormat;

public class Bestellung {
    static private int orderCnt = 1;
    private int bestNr;
    private String orderTime;
    private int[] orderedIDs;
    int auslastung;
    int id;

    public Bestellung (int[] orderedIDs){
        this.bestNr = orderCnt;
        ++orderCnt;
        this.orderTime = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss").format(new Date());
        this.orderedIDs = orderedIDs;
    }

    public int getBestNr() { return bestNr; }
    public String getOrderTime() { return orderTime; }
    public int[] getOrderedIDs() { return orderedIDs; }

    public int getAuslastung() {
        return auslastung;
    }
    public int getId(){return id; }

    public void Nachbestellung(Bestellung bestellung){
        auslastung = getAuslastung();
        id = getId();
        if (auslastung<=5){

        }
        }
    }




