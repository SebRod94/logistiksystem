package Objects;

public class Lageruebersicht {
    private static Lager[] alleLager = new Lager[3];

    public static void addLager(Lager lager1) throws Exception {
        if (alleLager[alleLager.length - 1] != null) {
            throw new Exception("Maximale Zahl an Lagern bereits erreicht.");
        } else {
            for (Lager l : alleLager) {
                if (l == null) {
                    l = lager1;
                    break;
                }
            }
        }
    }

    public static Lager[] getAlleLager(){ return alleLager; }
}