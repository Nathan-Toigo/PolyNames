package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Dictionary;
import java.util.Hashtable;
import modele.Grille;
import modele.GrilleJoueur;
import modele.Joueur;

public class GrilleJoueurDAO extends generiqueDAO<GrilleJoueur> {
    
    public GrilleJoueurDAO(){
        super();
    }

    @Override
    protected GrilleJoueur genererTDepuisEnregistrement(ResultSet results) throws SQLException {
        Grille grille = new Grille();
        GrilleDAO grilleDAO = new GrilleDAO(); 
        Dictionary<String,Integer> idGrille = new Hashtable<>();
        idGrille.put("id_grille",results.getInt("id_grille"));
        grille = grilleDAO.recupererParId(grille,idGrille);

        Joueur joueur = new Joueur();
        JoueurDAO joueurDAO = new JoueurDAO();
        Dictionary<String,Integer> idJoueur = new Hashtable<>();
        idJoueur.put("id_joueur",results.getInt("id_joueur"));
        joueur = joueurDAO.recupererParId(joueur, idJoueur);

        return new GrilleJoueur(grille,joueur);
    }
}
