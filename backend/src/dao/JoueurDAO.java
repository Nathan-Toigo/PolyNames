package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;
import modele.Joueur;
import modele.Partie;

public class JoueurDAO extends generiqueDAO {

    public JoueurDAO() {
        super();
    }

    public ArrayList<Joueur> recupererTout() throws SQLException {
        PreparedStatement statement = this.pnDatabase.prepareStatement("SELECT * FROM Joueur;");
        ResultSet resultats = statement.executeQuery();
        ArrayList<Joueur> resultat = new ArrayList<Joueur>();
        while (resultats.next()) {
            resultat.add(generateCardFromResultSet(resultats));
        }
        return resultat;
    }

    public void insererJoueur(Joueur joueur) {

    }

    public Joueur genererNouveauJoueur(Partie partie, Boolean est_hote) throws SQLException {
        String nouveauJeton = this.genererJetonJoueur();
        PreparedStatement statement = this.pnDatabase.prepareStatement("INSERT INTO Joueur(jeton,est_hote,role,code_partie) VALUES(?,?,0,?);");
        statement.setString(1, nouveauJeton);
        statement.setBoolean(2, est_hote);
        statement.setString(3, partie.getCode_partie());
        statement.executeUpdate();

        return new Joueur(nouveauJeton, est_hote, 0, partie.getCode_partie());
    }

    private String genererJetonJoueur() throws SQLException {
        ArrayList<Joueur> tousJoueurs = this.recupererTout();
        ArrayList<String> jetons_joueurs = new ArrayList<>();
        for (Joueur joueur : tousJoueurs) {
            jetons_joueurs.add(joueur.getJeton());
        }

        Boolean fin = true;
        String nouveauJeton = "000000000000000000000000000000";

        while (fin) {
            int leftLimit = 48; // numeral '0'
            int rightLimit = 122; // letter 'z'
            int targetStringLength = 30;
            Random random = new Random();
            nouveauJeton = random.ints(leftLimit, rightLimit + 1)
                    .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
                    .limit(targetStringLength)
                    .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                    .toString();

            if (!jetons_joueurs.contains(nouveauJeton)) {
                fin = false;
            }
        }
        return nouveauJeton;
    }

    public Joueur recupererJoueurDepuisJeton(String jeton) throws SQLException {
        PreparedStatement statement = this.pnDatabase.prepareStatement("SELECT * FROM Joueur WHERE jeton=?;");
        statement.setString(1, jeton);
        ResultSet resultats = statement.executeQuery();
        Joueur resultat = new Joueur();
        while (resultats.next()) {
            resultat = generateCardFromResultSet(resultats);
        }
        return resultat;
    }

    public ArrayList<Joueur> recupererJoueurDepuisPartie(String codePartie) throws SQLException {
        PreparedStatement statement = this.pnDatabase.prepareStatement("SELECT * FROM Joueur WHERE code_partie=?;");
        statement.setString(1, codePartie);
        ResultSet resultats = statement.executeQuery();
        ArrayList<Joueur> resultat = new ArrayList<Joueur>();
        while (resultats.next()) {
            resultat.add(generateCardFromResultSet(resultats));
        }
        return resultat;
    }

    public void rafraichirRoleJoueur(String jeton, int role) throws SQLException {
        PreparedStatement statement = this.pnDatabase.prepareStatement("UPDATE Joueur SET role = ? WHERE jeton=?");
        statement.setInt(1, role);
        statement.setString(2, jeton);
        statement.executeUpdate();
    }

    public Joueur generateCardFromResultSet(ResultSet resultat) throws SQLException {
        final int role = resultat.getInt("role");
        final Boolean est_hote = resultat.getBoolean("est_hote");
        final String code_partie = resultat.getString("code_partie");
        final String jeton = resultat.getString("jeton");
        return new Joueur(jeton, est_hote, role, code_partie);
    }

}
