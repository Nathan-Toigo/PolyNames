package dao;

import java.lang.reflect.Array;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import modele.Partie;

public class PartieDAO extends generiqueDAO {

    public PartieDAO() {
        super();
    }

    public ArrayList<Partie> recupererTout() throws SQLException {
        PreparedStatement statement = this.pnDatabase.prepareStatement("SELECT * FROM Partie;");
        ResultSet resultats = statement.executeQuery();
        ArrayList<Partie> resultat = new ArrayList<Partie>();
        while (resultats.next()) {
            resultat.add(generateCardFromResultSet(resultats));
        }
        return resultat;
    }

    public Partie recupererDepuisCodePartie(String codePartie) throws SQLException {
        PreparedStatement statement = this.pnDatabase.prepareStatement("SELECT * FROM Partie WHERE code_partie=?;");
        statement.setString(1, codePartie);
        ResultSet resultats = statement.executeQuery();
        Partie resultat = new Partie();
        while (resultats.next()) {
            resultat = generateCardFromResultSet(resultats);
        }
        return resultat;
    }

    public Partie genererNouvellePartie() throws SQLException {
        String nouveauCodePartie = genererCodePartie();
        PreparedStatement statement = this.pnDatabase.prepareStatement("INSERT INTO Partie(code_partie,score) VALUES(?,0);");
        statement.setString(1, nouveauCodePartie);
        statement.executeUpdate();

        return new Partie(nouveauCodePartie,0,false,false);
    }

    public void rendrePartieComplete(String codePartie) throws SQLException {
        PreparedStatement statement = this.pnDatabase.prepareStatement("UPDATE Partie SET est_complete = True WHERE code_partie=?");
        statement.setString(1, codePartie);
        statement.executeUpdate();
    }

    public void rendrePartieInitialisee(String codePartie) throws SQLException {
        PreparedStatement statement = this.pnDatabase.prepareStatement("UPDATE Partie SET est_initialisee = True WHERE code_partie=?");
        statement.setString(1, codePartie);
        statement.executeUpdate();
    }

    public Partie generateCardFromResultSet(ResultSet resultat) throws SQLException {
        final int score = resultat.getInt("score");
        final String code_partie = resultat.getString("code_partie");
        final Boolean est_complet = resultat.getBoolean("est_complete");
        final Boolean est_initialisee = resultat.getBoolean("est_initialisee");
        return new Partie(code_partie, score, est_complet,est_initialisee);
    }

    private String genererCodePartie() throws SQLException {
        ArrayList<Partie> parties = this.recupererTout();
        ArrayList<String> code_parties = new ArrayList<>();
        for (Partie partie : parties) {
            code_parties.add(partie.getCode_partie());
        }

        Boolean fin = true;
        String code = "0000000000";

        while (fin) {
            int leftLimit = 48; // numeral '0'
            int rightLimit = 122; // letter 'z'
            int targetStringLength = 10;
            Random random = new Random();
            code = random.ints(leftLimit, rightLimit + 1)
                    .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
                    .limit(targetStringLength)
                    .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                    .toString();

            if (!code_parties.contains(code)) {
                fin = false;
            }
        }
        return code;
    }

    public void rafraichirScore(String codePartie, int score) throws SQLException {
        PreparedStatement statement = this.pnDatabase.prepareStatement("UPDATE Joueur SET score = ? WHERE code_partie=?");
        statement.setInt(1, score);
        statement.setString(2, codePartie);
        statement.executeUpdate();
    }
}
