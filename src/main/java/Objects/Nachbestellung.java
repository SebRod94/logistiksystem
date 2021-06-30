package Objects;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

public class Nachbestellung {
    static private int orderCnt = 1;
    private int NachBestNr;
    private String orderTime;
    private Map<String, Integer> orderedIDs;

    public Nachbestellung (Map<String, Integer> orderedIDs){
        this.NachBestNr = orderCnt;
        ++orderCnt;
        this.orderTime = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss").format(new Date());
        this.orderedIDs = orderedIDs;
    }

    public int getNachBestNr() { return NachBestNr; }
    public String getOrderTime() { return orderTime; }
    public Map<String, Integer> getOrderedIDs() { return orderedIDs; }
}
