package Objects;

public class Lageruebersicht {
    private static Lager[] alleLager = new Lager[3];

    public static void addLager(Lager lager) throws Exception {
        if (alleLager[alleLager.length - 1] != null) {
            throw new Exception("Maximale Zahl an Lagern bereits erreicht.");
        } else {
            for (int i = 0; i < alleLager.length; i++ ) {
                if (alleLager[i] == null) {
                    alleLager[i] = lager;
                    return;
                }
            }
        }
    }

    public static Lager[] getAlleLager(){ return alleLager; }
}