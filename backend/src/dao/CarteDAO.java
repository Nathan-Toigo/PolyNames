package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modele.Carte;
import modele.Mot;

public class CarteDAO extends generiqueDAO {

    public CarteDAO() {
        super();
    }

    public Carte generateCardFromResultSet(ResultSet resultat) throws SQLException {
        final Boolean face_cachee = resultat.getBoolean("face_cachee");
        final int couleur = resultat.getInt("couleur");
        final String code_partie = resultat.getString("code_partie");

        final int id_mot = resultat.getInt("id_mot");
        MotDAO motDAO = new MotDAO();
        final Mot mot = motDAO.recupererDepuisId(id_mot);

        return new Carte(mot, code_partie, couleur, face_cachee);
    }

    public void insererCarte(Carte carte) throws SQLException {
        PreparedStatement statement = this.pnDatabase.prepareStatement("INSERT INTO Carte(id_mot,code_partie,couleur,face_cachee) VALUES(?,?,?,?)");
        statement.setInt(1, carte.getMot().getId_mot());
        statement.setString(2, carte.getCode_partie());
        statement.setInt(3, carte.getCouleur());
        statement.setBoolean(4, carte.getFace_cachee());
        statement.executeUpdate();
    }

    public ArrayList<Carte> genererCartesPartie(ArrayList<Mot> mots, String codePartie) throws SQLException {
        ArrayList<Mot> gris = new ArrayList<Mot>();
        for (Mot word : mots) {
            gris.add(word);
        }
        ArrayList<Mot> noir = new ArrayList<Mot>();
        ArrayList<Mot> bleu = new ArrayList<Mot>();

        for (int i = 0; i < 8; i++) {
            int index = (int) (Math.random() * gris.size());
            bleu.add(gris.get(index));
            gris.remove(index);
        }
        for (int i = 0; i < 2; i++) {
            int index = (int) (Math.random() * gris.size());
            noir.add(gris.get(index));
            gris.remove(index);
        }

        ArrayList<Carte> listeCarte = new ArrayList<>();

        for (int i = 0; i < 25; i++) {
            Mot mot = mots.get(i);
            int couleur = 1;
            if (noir.contains(mot)) {
                couleur = 3;
            } else if (bleu.contains(mot)) {
                couleur = 2;
            }

            Carte nouvelleCarte = new Carte(mot, codePartie, couleur, true);
            this.insererCarte(nouvelleCarte);
            listeCarte.add(nouvelleCarte);
        }
        return listeCarte;
    }

    
}
