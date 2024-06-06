package modele;

import java.util.ArrayList;
import java.util.Arrays;

public class Grille extends TableBDD{

    private int id_grille;
    private int hauteur_grille;
    private int largeur_grille;
    private byte score;
    private Etat etat;

    public Grille(){
        super("Grille",new ArrayList<>(Arrays.asList("id_grille")));
        this.id_grille = 0;
        this.hauteur_grille = 0;
        this.largeur_grille = 0;
        this.score = 0;
        this.etat = new Etat();
    }

    public Grille(int id_grille,int hauteur_grille,int largeur_grille,byte score, Etat etat){
        super("Grille",new ArrayList<>(Arrays.asList("id_grille")));
        this.id_grille = id_grille;
        this.hauteur_grille = hauteur_grille;
        this.largeur_grille = largeur_grille;
        this.score = score;
        this.etat = etat;
    }

    public int getId_grille() {
        return id_grille;
    }

    public int getHauteur_grille() {
        return hauteur_grille;
    }

    public int getLargeur_grille() {
        return largeur_grille;
    }

    public byte getScore() {
        return score;
    }

    public Etat getEtat() {
        return etat;
    }

}
