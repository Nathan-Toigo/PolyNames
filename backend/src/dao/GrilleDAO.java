package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Hashtable;
import modele.Etat;
import modele.Grille;
import modele.GrilleJoueur;
import modele.Joueur;

public class GrilleDAO extends generiqueDAO<Grille> {

    public GrilleDAO(){
        super();
    }

    @Override
    protected Grille genererTDepuisEnregistrement(ResultSet results) throws SQLException {
        final int id_grille = results.getInt("id_grille");
        final int hauteur_grille = results.getInt("hauteur_grille");
        final int largeur_grille = results.getInt("largeur_grille");
        final byte score = results.getByte("score");

        Etat etat = new Etat();
        EtatDAO etatDAO = new EtatDAO();
        Dictionary<String,Integer> idEtat = new Hashtable<>();
        idEtat.put("id_etat",results.getInt("id_etat"));
        etat = etatDAO.recupererParId(etat, idEtat);

        return new Grille(id_grille,hauteur_grille,largeur_grille,score,etat);
    }

    public ArrayList<Grille> recupererGrilleDepuisJoueur(Joueur joueur) throws SQLException{
        GrilleJoueurDAO grilleJoueurDAO= new GrilleJoueurDAO();
        ArrayList<GrilleJoueur> grilleJoueurs = grilleJoueurDAO.recupererGrilleJoueurDepuisJoueur(joueur);

        ArrayList<Grille> grilles = new ArrayList<Grille>();
        for(GrilleJoueur grilleJoueur : grilleJoueurs)
        {
            Dictionary<String, String> cles = new Hashtable<>();
            cles.put("id_grille", Integer.toString(grilleJoueur.getGrille().getId_grille()));

            grilles.add(this.recupererParChamp(new Grille(), cles).get(0));
        }

        return grilles;
    }

}
