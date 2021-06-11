package Datenverarbeitung;

import Exceptions.KapazitaetErreichtException;
import Exceptions.KeinRegalException;
import Lists.ArrList;
import Objects.*;

import java.io.*;
import java.util.Properties;

public class CSVReader {

    public ArrList<Produkt> readProdukte(String fileName){
        File file = new File(fileName);
        String line = "";
        ArrList<Produkt> produkte = new ArrList<>();

        try {
            FileReader inputStream = new FileReader(file);
            BufferedReader br = new BufferedReader(inputStream);
            br.readLine();
            while ((line = br.readLine()) != null) {
                String[] values = line.split(";");
                Produkt produkt = new Produkt(values[1], Integer.parseInt(values[2]), Double.parseDouble(values[3].replace(',','.')), Double.parseDouble(values[4].replace(',','.')), Integer.parseInt(values[5]));
                produkte.add(produkt);
                System.out.println(values[0]);
            }
            inputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException | KeinRegalException | KapazitaetErreichtException e) {
            e.printStackTrace();
        }

        return produkte;
    }

    public ArrList<Regal> readRegal(String fileName){
        File file = new File(fileName);
        String line = "";
        ArrList<Regal> regale = new ArrList<>();

        try {
            FileReader inputStream = new FileReader(file);
            BufferedReader br = new BufferedReader(inputStream);
            br.readLine();
            while ((line = br.readLine()) != null) {
                String[] values = line.split(";");
                Regal regal = new Regal(Integer.parseInt(values[0].replace(',','.')));
                regale.add(regal);
                System.out.println(values[0]);
            }
            inputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException | KapazitaetErreichtException e) {
            e.printStackTrace();
        }

        return regale;
    }

    public ArrList<Sektor> readSektor(String fileName){
        File file = new File(fileName);
        String line = "";
        ArrList<Sektor> sektors = new ArrList<>();

        try {
            FileReader inputStream = new FileReader(file);
            BufferedReader br = new BufferedReader(inputStream);
            br.readLine();
            while ((line = br.readLine()) != null) {
                String[] values = line.split(";");
                Kategorie kategorie = getKategorie(removeUmlauts(values[1].trim().toLowerCase()));
                Sektor sektor = new Sektor(Integer.parseInt(values[0].replace(',','.')), kategorie);
                sektors.add(sektor);
                System.out.println(values[0]);
            }
            inputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException | KapazitaetErreichtException e) {
            e.printStackTrace();
        }

        return sektors;
    }

    public ArrList<Lager> readLager(String fileName) {
        File file = new File(fileName);
        String line = "";
        ArrList<Lager> lagers = new ArrList<>();

        try {
            FileReader inputStream = new FileReader(file);
            BufferedReader br = new BufferedReader(inputStream);
            br.readLine();
            while ((line = br.readLine()) != null) {
                String[] values = line.split(";");
                Lager lager = new Lager(Integer.parseInt(values[0].replace(',','.')), values[1], Integer.parseInt(values[2].replace(',','.')));
                lagers.add(lager);
                System.out.println(values[0]);
            }
            inputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

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
