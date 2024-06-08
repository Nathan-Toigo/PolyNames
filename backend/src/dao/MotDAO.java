package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import modele.Mot;

public class MotDAO extends generiqueDAO<Mot> {

    public MotDAO(){
        super();
    }

    @Override
    protected Mot genererTDepuisEnregistrement(ResultSet results) throws SQLException {
        final int id_mot = results.getInt("id_mot");
        final String mot = results.getString("mot");
        return new Mot(id_mot,mot);
    }
}