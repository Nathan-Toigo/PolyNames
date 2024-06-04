package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import modele.Dictionnaire;

public class DictionnaireDAO extends generiqueDAO<Dictionnaire> {
  
    public DictionnaireDAO(){
        super();
    }

    @Override
    protected Dictionnaire genererTDepuisEnregistrement(ResultSet results) throws SQLException {
        final int id_dictionnaire = results.getInt("id_dictionnaire");
        final String titre = results.getString("titre");
        return new Dictionnaire(id_dictionnaire,titre);
    }
}
