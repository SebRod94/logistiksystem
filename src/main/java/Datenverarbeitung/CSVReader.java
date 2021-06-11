package Datenverarbeitung;

import Exceptions.KapazitaetErreichtException;
import Exceptions.KeinRegalException;
import Lists.ArrList;
import Objects.*;

import java.io.*;

public class CSVReader {

    public <T> ArrList<T> read(String fileName){

        String[] splittetPath = fileName.split("\\\\");
        String object = splittetPath[splittetPath.length-1].toLowerCase();

        try {
            if (object.contains("produkt"))
                return (ArrList<T>) readProdukte(fileName);
            else if (object.contains("regal"))
                return (ArrList<T>) readRegal(fileName);
            else if (object.contains("sektor"))
                return (ArrList<T>) readSektor(fileName);
            else if (object.contains("Lager"))
                return (ArrList<T>) readLager(fileName);
            else
                throw new FileNotFoundException("Dateiname entspricht nicht den Vorgaben!");
        }
        catch (IOException | KapazitaetErreichtException | KeinRegalException e) {
            e.printStackTrace();
        }

        return null;
    }

    public ArrList<Produkt> readProdukte(String fileName) throws IOException, KeinRegalException, KapazitaetErreichtException {
        File file = new File(fileName);
        String line = "";
        ArrList<Produkt> produkte = new ArrList<>();

        FileReader inputStream = new FileReader(file);
        BufferedReader br = new BufferedReader(inputStream);
        br.readLine();
        while ((line = br.readLine()) != null) {
            String[] values = line.split(";");
            produkte.add(new Produkt(values[1], Integer.parseInt(values[2]), Double.parseDouble(values[3].replace(',','.')), Double.parseDouble(values[4].replace(',','.')), Integer.parseInt(values[5])));
        }
        inputStream.close();

        return produkte;
    }

    public ArrList<Regal> readRegal(String fileName) throws IOException, KapazitaetErreichtException {
        File file = new File(fileName);
        String line = "";
        ArrList<Regal> regale = new ArrList<>();

        FileReader inputStream = new FileReader(file);
        BufferedReader br = new BufferedReader(inputStream);
        br.readLine();
        while ((line = br.readLine()) != null) {
            String[] values = line.split(";");
            regale.add(new Regal(Integer.parseInt(values[0].replace(',','.'))));
        }
        inputStream.close();

        return regale;
    }

    public ArrList<Sektor> readSektor(String fileName) throws IOException, KapazitaetErreichtException {
        File file = new File(fileName);
        String line = "";
        ArrList<Sektor> sektors = new ArrList<>();

        FileReader inputStream = new FileReader(file);
        BufferedReader br = new BufferedReader(inputStream);
        br.readLine();
        while ((line = br.readLine()) != null) {
            String[] values = line.split(";");
            Kategorie kategorie = getKategorie(removeUmlauts(values[1].trim().toLowerCase()));
            sektors.add(new Sektor(Integer.parseInt(values[0].replace(',','.')), kategorie));
        }
        inputStream.close();

        return sektors;
    }

    public ArrList<Lager> readLager(String fileName) throws IOException {
        File file = new File(fileName);
        String line = "";
        ArrList<Lager> lagers = new ArrList<>();

        FileReader inputStream = new FileReader(file);
        BufferedReader br = new BufferedReader(inputStream);
        br.readLine();
        while ((line = br.readLine()) != null) {
            String[] values = line.split(";");
            lagers.add(new Lager(Integer.parseInt(values[0].replace(',','.')), values[1], Integer.parseInt(values[2].replace(',','.'))));
        }
        inputStream.close();

        return lagers;
    }

    private String removeUmlauts(String input)
    {
        input.replace("ä", "ae");
        input.replace("ö", "oe");
        input.replace("ü", "ue");
        return input;
    }

    private Kategorie getKategorie(String kategorie)
    {
        switch (kategorie){
            case "werkzeuge":
                return Kategorie.Werkzeuge;
            case "kleidung":
                return Kategorie.Kleidung;
            case "sportgeraete":
                return Kategorie.Sportgeraete;
            case "elektronik":
                return Kategorie.Elektronik;
            case "lebensmittel":
                return Kategorie.Lebensmittel;
            case "buerobedarf":
                return Kategorie.Buerobedarf;
            case "beleuchtung":
                return Kategorie.Beleuchtung;
            case "moebel":
                return Kategorie.Moebel;
            case "verpackungen":
                return Kategorie.Verpackungen;
        }

        return null;
    }
}
