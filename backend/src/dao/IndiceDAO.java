package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import modele.Indice;

public class IndiceDAO extends generiqueDAO{

    public IndiceDAO(){
        super();
    }

    public Indice generateCardFromResultSet(ResultSet resultat) throws SQLException{
        final int id_indice = resultat.getInt("id_indice");
        final String indice = resultat.getString("indice");
        final int nb_carte_associe = resultat.getInt("nb_carte_associe");
        final int nb_carte_trouve = resultat.getInt("nb_carte_trouve");
        final int numero_tour_associe = resultat.getInt("numero_tour_associe");
        final String code_partie = resultat.getString("code_partie");
        return new Indice(id_indice,indice,nb_carte_associe,nb_carte_trouve,numero_tour_associe,code_partie);
    }

    public int recupererNbIndiceDansPartie(String code_partie) throws SQLException {
        PreparedStatement statement = this.pnDatabase.prepareStatement("SELECT COUNT(*) AS nbIndice FROM Indice WHERE code_partie=?");
        statement.setString(1, code_partie);
        ResultSet resultats = statement.executeQuery();
        int nbIndiceDansPartie  = 0;
        while (resultats.next()) {
            nbIndiceDansPartie = resultats.getInt("nbIndice");
        }

        return nbIndiceDansPartie;
    }

    public Indice recupererDernierIndice(String code_partie) throws SQLException {
        PreparedStatement statement = this.pnDatabase.prepareStatement("SELECT * FROM Indice WHERE numero_tour_associe = (SELECT Max(numero_tour_associe) FROM Indice WHERE code_partie=?);");
        statement.setString(1, code_partie);
        ResultSet resultats = statement.executeQuery();
        Indice dernierIndice = new Indice(0, code_partie, 0, 0, 0, code_partie);
        while (resultats.next()) {
            dernierIndice = generateCardFromResultSet(resultats);
        }
        return dernierIndice;
    }

    public Indice insererNouveauIndice(Indice indice) throws SQLException {
        int numTour = this.recupererNbIndiceDansPartie(indice.getCode_partie()) + 1;
        PreparedStatement statement = this.pnDatabase.prepareStatement("UPDATE Indice SET indice = ? ,nb_carte_associe = ? ,nb_carte_trouve = ?,numero_tour_associe = ?,code_partie = ? WHERE id_indice = ?;");
        statement.setString(1, indice.getIndice());
        statement.setInt(2, indice.getNb_carte_associe());
        statement.setInt(3, numTour);
        statement.setString(4, indice.getCode_partie());
        statement.executeUpdate();

        return new Indice(0,indice.getIndice(),indice.getNb_carte_associe(),indice.getNb_carte_trouve(),numTour,indice.getCode_partie());
    }

    public void rafraichirIndice(String jeton, int role) throws SQLException {
        PreparedStatement statement = this.pnDatabase.prepareStatement("UPDATE Joueur SET role = ? WHERE jeton=?");
        statement.setInt(1, role);
        statement.setString(2, jeton);
        statement.executeUpdate();
    }
    
}