package Objects;

import java.util.HashMap;
import java.util.Map;

public class Personal {

    private String name;
    private String abteilung;
    private String stelle;

    public Personal(String name, String abteilung, String stelle){
        this.name = name;
        this.abteilung = abteilung;
        this.stelle = stelle;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setAbteilung(String abteilung) {
        this.abteilung = abteilung;
    }

    public String getAbteilung() {
        return abteilung;
    }

    public void setStelle(String stelle) {
        this.stelle = stelle;
    }

    public String getStelle() {
        return stelle;
    }

    //Map
    public void map(){
        Map<String, String> vorgesetzte = new HashMap<>();

        String chef = "Maria";
    }


}

