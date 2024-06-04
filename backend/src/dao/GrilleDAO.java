package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import modele.Etat;
import modele.Grille;

public class GrilleDAO extends generiqueDAO<Grille> {

    public GrilleDAO(){
        super();
    }

    @Override
    protected Grille genererTDepuisEnregistrement(ResultSet results) throws SQLException {
        final int id_grille = results.getInt("id_grille");
        final int hauteur_grille = results.getInt("hauteur_grille");
        final int largeur_grille = results.getInt("largeur_grille");
        final byte score = results.getByte("score");
        final Etat etat = new Etat();
        return new Grille(id_grille,hauteur_grille,largeur_grille,score,etat);
    }
}
