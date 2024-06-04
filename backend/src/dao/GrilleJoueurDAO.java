package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import modele.Grille;
import modele.GrilleJoueur;
import modele.Joueur;

public class GrilleJoueurDAO extends generiqueDAO<GrilleJoueur> {
    
    public GrilleJoueurDAO(){
        super();
    }

    @Override
    protected GrilleJoueur genererTDepuisEnregistrement(ResultSet results) throws SQLException {
        final Grille id_etat = new Grille();
        final Joueur etat = new Joueur();
        return new GrilleJoueur(id_etat,etat);
    }
}
