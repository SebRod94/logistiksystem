import Datenverarbeitung.CSVReader;
import Lists.ArrList;
import Objects.*;

import javax.naming.spi.DirectoryManager;
import java.io.File;
import java.net.URL;
import java.nio.file.FileSystem;
import java.nio.file.Path;

public class Main {

    public static void main(String[] args) {
        String path = System.getProperty("user.dir");
        ArrList<Lager> lager = CSVReader.read(path + "\\src\\main\\java\\Mappen\\LagerMappe.csv");
        ArrList<Sektor> sektoren = CSVReader.read(path + "\\src\\main\\java\\Mappen\\SektorMappe.csv");
        lager.get(0).addSektoren(sektoren.get(0), sektoren.get(1), sektoren.get(2));
        lager.get(1).addSektoren(sektoren.get(3), sektoren.get(4), sektoren.get(5));
        lager.get(2).addSektoren(sektoren.get(6), sektoren.get(7), sektoren.get(8));
        //var regale = CSVReader.read(path + "\\src\\main\\java\\Mappen\\RegalMappe.csv");
        ArrList<Produkt> produkte = CSVReader.read(path + "\\src\\main\\java\\Mappen\\ProduktMappe.csv");
    }
}
