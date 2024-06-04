package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import modele.Couleur;

public class CouleurDAO extends generiqueDAO<Couleur>{

    public CouleurDAO(){
        super();
    }

    @Override
    protected Couleur genererTDepuisEnregistrement(ResultSet results) throws SQLException {
        final int id_couleur = results.getInt("id_couleur");
        final String couleur = results.getString("couleur");
        return new Couleur(id_couleur,couleur);
    }
}

