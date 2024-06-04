package modele;

import java.util.ArrayList;
import java.util.Arrays;

public class Couleur extends TableBDD {
    private int id_couleur;
    private String couleur;

    public Couleur(){
        super("Couleur",new ArrayList<>(Arrays.asList("id_couleur")));
        this.id_couleur = 0;
        this.couleur = "";
    }

    public Couleur(int id_couleur, String couleur){
        super("Couleur",new ArrayList<>(Arrays.asList("id_couleur")));
        this.id_couleur = id_couleur;
        this.couleur = couleur;
    }
}
