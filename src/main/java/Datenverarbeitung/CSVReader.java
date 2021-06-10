package Datenverarbeitung;

import Exceptions.KapazitaetErreichtException;
import Exceptions.KeinRegalException;
import Lists.ArrList;
import Objects.Produkt;

import java.io.*;
import java.util.Properties;

public class CSVReader {

    public ArrList<Produkt> readProdukte(){
        String fileName = "G:\\Meine Ablage\\2. Semester\\OOP\\Test\\src\\ProjektMappe.csv";
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

    public ArrList<Produkt> readRegal(){
        String fileName = "G:\\Meine Ablage\\2. Semester\\OOP\\Test\\src\\ProjektMappe.csv";
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
}
