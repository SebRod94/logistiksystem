import Objects.*;

public class Main {

    public static void main(String[] args) {
        Lager lager1 = new Lager(1,"Hauptlager", 80);
        Lager lager2 = new Lager(2,"Nebenlager", 55);
        Lager lager3 = new Lager(3,"Kellerlager", 40);

        for (Lager l: Lageruebersicht.getAlleLager()) { System.out.println(l); }
    }
}
