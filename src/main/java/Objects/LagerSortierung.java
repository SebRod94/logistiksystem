package Objects;

import Exceptions.KapazitaetErreichtException;

import java.util.ArrayList;

public class LagerSortierung {

    public static void sort(Produkt produkt, Lager lager)  {
        int id = produkt.getId();

        for (Sektor sektor : lager.getSektoren().toArray()) {
            if(compare(id, sektor.getId(), 0,1) == true)
            {
                for(Regal regal : sektor.getRegale().toArray())
                {
                    if(compare(id, regal.getId(), 2,3) == true)
                    {
                        try{
                            regal.addProdukte(produkt);
                        }
                        catch (KapazitaetErreichtException ex)
                        {

                        }
                    }
                }
            }
        }
    }
    
    private static boolean compare(int idProdukt, int id, int startIndex, int endIndex)
    {
        char[] idProduktCharArry = Integer.toString(idProdukt).toCharArray();
        char[] idCharArry = Integer.toString(id).toCharArray();

        for(int i = startIndex; i < endIndex; i++)
        {
            if(idCharArry[i] != idProduktCharArry[i])
                return false;
        }
        return true;
    }
}
