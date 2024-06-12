package modele;

import java.util.ArrayList;
import java.util.Arrays;

public class GrilleJoueur extends TableBDD{
    private Grille grille;
    private Joueur joueur;
    private Role role;
    private Partie partie;

    public GrilleJoueur(){
        super("Grille_Joueur",new ArrayList<>(Arrays.asList("id_grille","id_joueur")));
        this.grille = new Grille();
        this.joueur = new Joueur();
        this.role = new Role();
        this.partie = new Partie();
    }

    public GrilleJoueur(Grille grille, Joueur joueur,Role role, Partie partie){
        super("Grille_Joueur",new ArrayList<>(Arrays.asList("id_grille","id_joueur")));
        this.grille = grille;
        this.joueur = joueur;
        this.role = role;
        this.partie = partie;
    }

    public Grille getGrille() {
        return grille;
    }

    public Joueur getJoueur() {
        return joueur;
    }

    public Role getRole() {
        return role;
    }

    public Partie getPartie() {
        return partie;
    }
}
