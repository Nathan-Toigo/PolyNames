package modele;

import java.util.ArrayList;
import java.util.Arrays;

public class Partie extends TableBDD{
    private int id_partie;
    private String code;

    public Partie(){
        super("Partie",new ArrayList<>(Arrays.asList("id_partie")));
        this.id_partie = 0;
        this.code = "0000000000";
    }

    public Partie(int id_partie,String code){
        super("Partie",new ArrayList<>(Arrays.asList("id_partie")));
        this.id_partie = id_partie;
        this.code = code;
    }

    public int getId_partie() {
        return id_partie;
    }

    public String getCode() {
        return code;
    }

}
