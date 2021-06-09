package Objects;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

public class Nachbestellung {
    static private int orderCnt = 1;
    private int nachBestNr;
    private String orderTime;
    private Map<Integer, Integer> orderedIDs;

    public Nachbestellung (Map<Integer, Integer> orderedIDs){
        this.nachBestNr = orderCnt;
        ++orderCnt;
        this.orderTime = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss").format(new Date());
        this.orderedIDs = orderedIDs;
    }

    public int getNachBestNr() { return nachBestNr; }
    public String getOrderTime() { return orderTime; }
    public Map<Integer, Integer> getOrderedIDs() { return orderedIDs; }
}
