package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import modele.Joueur;

public class JoueurDAO extends generiqueDAO<Joueur> {

    public JoueurDAO(){
        super();
    }

    @Override
    protected Joueur genererTDepuisEnregistrement(ResultSet results) throws SQLException {
        final int id_joueur = results.getInt("id_joueur");
        final String pseudonyme = results.getString("pseudonyme");
        return new Joueur(id_joueur,pseudonyme);
    }
}
