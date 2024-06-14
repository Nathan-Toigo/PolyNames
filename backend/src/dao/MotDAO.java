package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import modele.Joueur;
import modele.Mot;

public class MotDAO extends generiqueDAO{

    public MotDAO(){
        super();
    }

    public Mot generateCardFromResultSet(ResultSet resultat) throws SQLException{
        final int id_mot = resultat.getInt("id_mot");
        final String mot = resultat.getString("mot");
        return new Mot(id_mot,mot);
    }

    public Mot recupererDepuisId(int idMot) throws SQLException {
        PreparedStatement statement = this.pnDatabase.prepareStatement("SELECT * FROM Partie WHERE id_mot=?;");
        statement.setInt(1, idMot);
        ResultSet resultats = statement.executeQuery();
        Mot resultat = new Mot();
        while (resultats.next()) {
            resultat = generateCardFromResultSet(resultats);
        }
        return resultat;
    }

    public ArrayList<Mot> recupererMotsNouvellePartie() throws SQLException {
        PreparedStatement statement = this.pnDatabase.prepareStatement("SELECT * FROM Mot ORDER BY RAND() LIMIT 25;");
        ResultSet resultats = statement.executeQuery();
        ArrayList<Mot> resultat = new ArrayList<Mot>();
        while (resultats.next()) {
            resultat.add(generateCardFromResultSet(resultats));
        }
        return resultat;
    }

}