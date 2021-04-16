package Objects;

import java.util.Date;
import java.text.SimpleDateFormat;

public class Bestellung {
    static private int orderCnt = 1;
    private int bestNr;
    private String orderTime;
    private int[] orderedIDs;
    private boolean stornoStatus = false;

    public Bestellung (int[] orderedIDs){
        this.bestNr = orderCnt;
        ++orderCnt;
        this.orderTime = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss").format(new Date());
        this.orderedIDs = orderedIDs;
    }

    public void storno () {
        this.stornoStatus = true;

    }

    public int getBestNr() { return bestNr; }
    public String getOrderTime() { return orderTime; }
    public int[] getOrderedIDs() { return orderedIDs; }
    public boolean getStornoStatus() { return stornoStatus; }
}
