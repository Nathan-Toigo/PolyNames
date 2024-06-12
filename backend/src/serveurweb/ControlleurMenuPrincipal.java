package serveurweb;

import BaseWebserver.WebServerContext;
import dao.GrilleJoueurDAO;
import dao.JoueurDAO;
import dao.PartieDAO;
import dao.SessionDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Hashtable;
import modele.GrilleJoueur;
import modele.Joueur;
import modele.Partie;

public class ControlleurMenuPrincipal {

    public static void rejoindre(WebServerContext context)
    {
        String code = context.getRequest().getParam("code");
        String jeton = context.getRequest().getParam("jeton");

        //Vérifier si la partie est complete/réservée/existe
        PartieDAO partieDAO = new PartieDAO();
        GrilleJoueurDAO grilleJoueurDAO = new GrilleJoueurDAO();
        SessionDAO sessionDAO = new SessionDAO();
        JoueurDAO joueurDAO = new JoueurDAO();

        try {
            if(!sessionDAO.testerSession(jeton)){ // Le jeton  correspond à une session
                Partie partieCode = partieDAO.recupererPartieDepuisCode(code);
                if(partieCode.getId_partie() != 0){ //La partie existe
                    ArrayList<GrilleJoueur> grilleJoueurCodes = grilleJoueurDAO.recupererGrilleJoueurDepuisPartie(partieCode);
                    if(grilleJoueurCodes.size() == 1){ //La partie n'est pas réservée
                        Joueur joueurCourant = joueurDAO.recupererJoueurDepuisJeton(jeton);

                        Dictionary<String,String> cles = new Hashtable<>();
                        cles.put("id_joueur", Integer.toString(joueurCourant.getId_joueur()));
                        cles.put("id_partie", Integer.toString(partieCode.getId_partie()));
                        //ajouter la grille
                        //ajouter le role
                        context.getResponse().ok("Partie rejoint");
                    }
                    else{ // La partie est réservée (complète)
                        context.getResponse().notFound("La partie est réservée");
                    }
                }
                else{ // la partie n'existe pas
                    context.getResponse().notFound("La partie n'existe pas");
                }
            }
            else{ //Le jeton ne correspond à aucune session
                context.getResponse().notFound("Mauvais jeton");
            }
        } catch (SQLException e) {
        }

    }

    public static void creer(WebServerContext context)
    {
        String jeton = context.getRequest().getParam("jeton");

        //Vérifier si le joueur a trop de parties
        PartieDAO partieDAO = new PartieDAO();
        GrilleJoueurDAO grilleJoueurDAO = new GrilleJoueurDAO();
        SessionDAO sessionDAO = new SessionDAO();
        JoueurDAO joueurDAO = new JoueurDAO();

        try {
            if(!sessionDAO.testerSession(jeton)){ // Le jeton  correspond à une session
                Joueur joueurCourant = joueurDAO.recupererJoueurDepuisJeton(jeton);
                int nbPartieEnCours = 0;
                for(GrilleJoueur grilleJoueur:grilleJoueurDAO.recupererGrilleJoueurDepuisJoueur(joueurCourant) ){
                    if(grilleJoueur.getGrille().getEtat().getEtat() == "En cours"){
                        nbPartieEnCours++;
                    }
                }

                if(nbPartieEnCours < 10){ //Pas trop de parties
                    String codeNouvellePartie = partieDAO.creerPartie();
                    Partie nouvellePartie = partieDAO.recupererPartieDepuisCode(codeNouvellePartie);

                    Dictionary<String,String> cles = new Hashtable<>();
                    cles.put("id_joueur", Integer.toString(joueurCourant.getId_joueur()));
                    cles.put("id_partie", Integer.toString(nouvellePartie.getId_partie()));
                    //ajouter la grille
                    //ajouter le role
                    context.getResponse().ok("Partie Créée");

                }
                else{ // Trop de parties en cours
                    context.getResponse().notFound("Vous avez trop de parties en cours");
                }
            }
            else{ //Le jeton ne correspond à aucune session
                context.getResponse().notFound("Mauvais jeton");
            }
        } catch (SQLException e) {
        }

    }

    public static void supprimer(WebServerContext context)
    {
        String jeton = context.getRequest().getParam("jeton");

        //Vérifier si le joueur a trop de parties
        PartieDAO partieDAO = new PartieDAO();
        GrilleJoueurDAO grilleJoueurDAO = new GrilleJoueurDAO();
        SessionDAO sessionDAO = new SessionDAO();
        JoueurDAO joueurDAO = new JoueurDAO();

        try {
            if(!sessionDAO.testerSession(jeton)){ // Le jeton  correspond à une session
                Joueur joueurCourant = joueurDAO.recupererJoueurDepuisJeton(jeton);

                if(grilleJoueurDAO.recupererNombrePartieDepuisJoueur(joueurCourant) < 10){ //Pas trop de parties
                    String codeNouvellePartie = partieDAO.creerPartie();
                    Partie nouvellePartie = partieDAO.recupererPartieDepuisCode(codeNouvellePartie);

                    Dictionary<String,String> cles = new Hashtable<>();
                    cles.put("id_joueur", Integer.toString(joueurCourant.getId_joueur()));
                    cles.put("id_partie", Integer.toString(nouvellePartie.getId_partie()));
                    //ajouter la grille
                    //ajouter le role
                    context.getResponse().ok("Partie Créée");

                }
                else{ // Trop de parties en cours
                    context.getResponse().notFound("Vous avez trop de parties en cours");
                }
            }
            else{ //Le jeton ne correspond à aucune session
                context.getResponse().notFound("Mauvais jeton");
            }
        } catch (SQLException e) {
        }

    }
}
