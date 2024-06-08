package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import modele.Etat;

public class EtatDAO extends generiqueDAO<Etat> {

    public EtatDAO(){
        super();
    }
    
    @Override
    protected Etat genererTDepuisEnregistrement(ResultSet results) throws SQLException {
        final int id_etat = results.getInt("id_etat");
        final String etat = results.getString("etat");
        return new Etat(id_etat,etat);
    }
}
