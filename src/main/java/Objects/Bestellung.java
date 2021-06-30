package Objects;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Map;

public class Bestellung {
    static private int orderCnt = 1;
    private int bestNr;
    private String orderTime;
    private Map<String, Integer> orderedIDs;

    public Bestellung (Map<String, Integer> orderedIDs){
        this.bestNr = orderCnt;
        ++orderCnt;
        this.orderTime = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss").format(new Date());
        this.orderedIDs = orderedIDs;

    }


    public int getBestNr() { return bestNr; }
    public String getOrderTime() { return orderTime; }
    public Map<String, Integer> getOrderedIDs() { return orderedIDs; }
}
