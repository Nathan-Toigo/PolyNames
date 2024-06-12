package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Hashtable;
import modele.Grille;
import modele.GrilleJoueur;
import modele.Joueur;
import modele.Partie;
import modele.Role;

public class GrilleJoueurDAO extends generiqueDAO<GrilleJoueur> {
    
    public GrilleJoueurDAO(){
        super();
    }

    @Override
    protected GrilleJoueur genererTDepuisEnregistrement(ResultSet results) throws SQLException {
        Grille grille = new Grille();
        GrilleDAO grilleDAO = new GrilleDAO(); 
        Dictionary<String,Integer> idGrille = new Hashtable<>();
        idGrille.put("id_grille",results.getInt("id_grille"));
        grille = grilleDAO.recupererParId(grille,idGrille);

        Joueur joueur = new Joueur();
        JoueurDAO joueurDAO = new JoueurDAO();
        Dictionary<String,Integer> idJoueur = new Hashtable<>();
        idJoueur.put("id_joueur",results.getInt("id_joueur"));
        joueur = joueurDAO.recupererParId(joueur, idJoueur);

        Role role = new Role();
        RoleDAO roleDAO = new RoleDAO();
        Dictionary<String,Integer> idRole = new Hashtable<>();
        idRole.put("id_role",results.getInt("id_role"));
        role = roleDAO.recupererParId(role, idRole);

        Partie partie = new Partie();
        PartieDAO partieDAO = new PartieDAO();
        Dictionary<String,Integer> idPartie = new Hashtable<>();
        idJoueur.put("id_partie",results.getInt("id_partie"));
        partie = partieDAO.recupererParId(partie, idPartie);

        return new GrilleJoueur(grille,joueur,role,partie);
    }

    public ArrayList<GrilleJoueur> recupererGrilleJoueurDepuisJoueur(Joueur joueur) throws SQLException{
        Dictionary<String, String> cles= new Hashtable<>();
        cles.put("id_joueur", Integer.toString(joueur.getId_joueur()));
        
        return this.recupererParChamp(new GrilleJoueur(),cles);
    }

    public ArrayList<GrilleJoueur> recupererGrilleJoueurDepuisGrille(Grille grille) throws SQLException{
        Dictionary<String, String> cles= new Hashtable<>();
        cles.put("id_grille", Integer.toString(grille.getId_grille()));
        
        return this.recupererParChamp(new GrilleJoueur(),cles);
    }

    public ArrayList<GrilleJoueur> recupererGrilleJoueurDepuisPartie(Partie partie) throws SQLException{
        Dictionary<String, String> cles= new Hashtable<>();
        cles.put("id_partie", Integer.toString(partie.getId_partie()));
        return this.recupererParChamp(new GrilleJoueur(),cles);
    }

    public int recupererNombrePartieDepuisJoueur(Joueur joueur) throws SQLException{
        Dictionary<String, String> cles= new Hashtable<>();
        cles.put("id_joueur", Integer.toString(joueur.getId_joueur()));
        return this.compterParChamp(new GrilleJoueur(),cles);
    }
}
