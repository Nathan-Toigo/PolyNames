package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Dictionary;
import java.util.Hashtable;
import modele.Carte;
import modele.Couleur;
import modele.Grille;
import modele.Mot;

public class CarteDAO extends generiqueDAO<Carte> {

    public CarteDAO(){
        super();
    }

    @Override
    protected Carte genererTDepuisEnregistrement(ResultSet results) throws SQLException {
        final Boolean face_cachee = results.getBoolean("face_cachee");
        final byte ligne = results.getByte("ligne");
        final byte colonne = results.getByte("colonne");

        Mot mot = new Mot();
        MotDAO motDAO = new MotDAO();
        Dictionary<String,Integer> idMot = new Hashtable<>();
        idMot.put("id_mot",results.getInt("id_mot"));
        mot = motDAO.recupererParId(mot, idMot);

        Couleur couleur = new Couleur();
        CouleurDAO couleurDAO = new CouleurDAO();
        Dictionary<String,Integer> idCouleur = new Hashtable<>();
        idCouleur.put("id_couleur",results.getInt("id_couleur"));
        couleur = couleurDAO.recupererParId(couleur, idCouleur);

        Grille grille = new Grille();
        GrilleDAO grilleDAO = new GrilleDAO();
        Dictionary<String,Integer> idGrille = new Hashtable<>();
        idGrille.put("id_grille",results.getInt("id_grille"));
        grille = grilleDAO.recupererParId(grille, idGrille);

        return new Carte(face_cachee,ligne,colonne,mot,couleur,grille);
    }
}
