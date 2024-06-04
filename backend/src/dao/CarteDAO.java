package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
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
        final Mot mot = new Mot();
        final Couleur couleur = new Couleur();
        final Grille grille = new Grille();
        return new Carte(face_cachee,ligne,colonne,mot,couleur,grille);
    }
}
