package modele;

import java.util.ArrayList;
import java.util.Arrays;

public class GrilleJoueur extends TableBDD{
    private Grille grille;
    private Joueur joueur;

    public GrilleJoueur(){
        super("Grille_Joueur",new ArrayList<>(Arrays.asList("id_grille","id_joueur")));
        this.grille = new Grille();
        this.joueur = new Joueur();
    }

    public GrilleJoueur(Grille grille, Joueur joueur){
        super("Grille_Joueur",new ArrayList<>(Arrays.asList("id_grille","id_joueur")));
        this.grille = grille;
        this.joueur = joueur;
    }

    public Grille getGrille() {
        return grille;
    }

    public Joueur getJoueur() {
        return joueur;
    }
}
