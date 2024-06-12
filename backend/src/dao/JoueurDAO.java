package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Hashtable;

import modele.Grille;
import modele.GrilleJoueur;
import modele.Joueur;
import modele.Session;

public class JoueurDAO extends generiqueDAO<Joueur> {

    public JoueurDAO(){
        super();
    }

    @Override
    protected Joueur genererTDepuisEnregistrement(ResultSet results) throws SQLException {
        final int id_joueur = results.getInt("id_joueur");
        final String pseudonyme = results.getString("pseudonyme");
        return new Joueur(id_joueur,pseudonyme);
    }

    public Joueur recupererJoueurDepuisJeton(String jeton) throws SQLException{
        SessionDAO sessionDAO= new SessionDAO();
        Session session = sessionDAO.recupererSessionDepuisJeton(jeton);

        Dictionary<String, String> cles= new Hashtable<>();
        cles.put("id_joueur", Integer.toString(session.getJoueur().getId_joueur()));
        
        return this.recupererParChamp(new Joueur(),cles).get(0);
    }

    public ArrayList<Joueur> recupererJoueursDepuisGrille(Grille grille) throws SQLException{
        GrilleJoueurDAO grilleJoueurDAO= new GrilleJoueurDAO();
        ArrayList<GrilleJoueur> grilleJoueurs = grilleJoueurDAO.recupererGrilleJoueurDepuisGrille(grille);

        ArrayList<Joueur> joueurs = new ArrayList<Joueur>();
        for(GrilleJoueur grilleJoueur : grilleJoueurs)
        {
            Dictionary<String, String> cles = new Hashtable<>();
            cles.put("id_joueur", Integer.toString(grilleJoueur.getJoueur().getId_joueur()));

            joueurs.add(this.recupererParChamp(new Joueur(), cles).get(0));
        }

        return joueurs;
    }

    /**
     * @param pseudonyme
     * @return True si le pseudo ne correspond à aucun compte, false sinon
     * @throws SQLException
     */
    public Boolean testerPseudo(String pseudonyme) throws SQLException{
        Dictionary<String, String> cles = new Hashtable<>();
        cles.put("pseudonyme", pseudonyme);

        var sessions = this.recupererParChamp(new Joueur(), cles);
        return sessions.isEmpty();
    }
}
