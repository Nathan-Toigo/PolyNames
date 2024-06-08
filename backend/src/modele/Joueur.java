package modele;

import java.util.ArrayList;
import java.util.Arrays;

public class Joueur extends TableBDD{
    private int id_joueur;
    private String pseudonyme;

    public Joueur(){
        super("Joueur",new ArrayList<>(Arrays.asList("id_joueur")));
        this.id_joueur = 0;
        this.pseudonyme = "";
    }

    public Joueur(int id_joueur, String pseudonyme){
        super("Joueur",new ArrayList<>(Arrays.asList("id_joueur")));
        this.id_joueur = id_joueur;
        this.pseudonyme = pseudonyme;
    }

    public int getId_joueur() {
        return id_joueur;
    }

    public String getPseudonyme() {
        return pseudonyme;
    }
}
