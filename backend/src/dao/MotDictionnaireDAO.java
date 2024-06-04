package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import modele.Dictionnaire;
import modele.Mot;
import modele.MotDictionnaire;

public class MotDictionnaireDAO extends generiqueDAO<MotDictionnaire> {

    public MotDictionnaireDAO(){
        super();
    }

    @Override
    protected MotDictionnaire genererTDepuisEnregistrement(ResultSet results) throws SQLException {
        final Dictionnaire id_etat = new Dictionnaire();
        final Mot etat = new Mot();
        return new MotDictionnaire(id_etat,etat);
    }
}
