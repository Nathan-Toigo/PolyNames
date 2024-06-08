package modele;

import java.util.ArrayList;
import java.util.Arrays;

public class Etat extends TableBDD{
    private int id_etat;
    private String etat;

    public Etat(){
        super("Etat",new ArrayList<>(Arrays.asList("id_etat")));
        this.id_etat = 0;
        this.etat = "";
    }

    public Etat(int id_etat, String etat){
        super("Etat",new ArrayList<>(Arrays.asList("id_etat")));
        this.id_etat = id_etat;
        this.etat = etat;
    }

    public int getId_etat() {
        return id_etat;
    }

    public String getEtat() {
        return etat;
    }
}
