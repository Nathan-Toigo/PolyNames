package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Dictionary;
import java.util.Hashtable;
import modele.Dictionnaire;
import modele.Mot;
import modele.MotDictionnaire;

public class MotDictionnaireDAO extends generiqueDAO<MotDictionnaire> {

    public MotDictionnaireDAO(){
        super();
    }

    @Override
    protected MotDictionnaire genererTDepuisEnregistrement(ResultSet results) throws SQLException {
        Dictionnaire dictionnaire = new Dictionnaire();
        DictionnaireDAO dictionnaireDAO = new DictionnaireDAO();
        Dictionary<String,Integer> idDictionnaire = new Hashtable<>();
        idDictionnaire.put("id_dictionnaire",results.getInt("id_dictionnaire"));
        dictionnaire = dictionnaireDAO.recupererParId(dictionnaire, idDictionnaire);

        Mot mot = new Mot();
        MotDAO motDAO = new MotDAO();
        Dictionary<String,Integer> idMot = new Hashtable<>();
        idMot.put("id_mot",results.getInt("id_mot"));
        mot = motDAO.recupererParId(mot, idMot);

        return new MotDictionnaire(dictionnaire,mot);
    }
}
