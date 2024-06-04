package modele;

import java.util.ArrayList;
import java.util.Arrays;

public class Mot extends TableBDD{

    private int id_mot;
    private String mot;

    public int getId_mot() {
        return this.id_mot;
    }

    public String getMot() {
        return this.mot;
    }

    public Mot(){
        super("Mot",new ArrayList<>(Arrays.asList("id_mot")));
        this.id_mot = 0;
        this.mot = "";
    }

    public Mot(int id_mot, String mot){
        super("Mot",new ArrayList<>(Arrays.asList("id_mot")));
        this.id_mot = id_mot;
        this.mot = mot;
    }
}
