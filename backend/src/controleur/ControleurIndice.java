package controleur;

import BaseWebserver.WebServerContext;
import dao.CarteDAO;
import dao.IndiceDAO;
import dao.JoueurDAO;
import dao.PartieDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import modele.Carte;
import modele.Indice;
import modele.Joueur;
import modele.Partie;
import modeleClient.EnvoieReponseCarte;
import modeleClient.IndiceClient;

public class ControleurIndice {

    public static void envoyerIndice(WebServerContext context) {
        try {
            String jetonJoueurCourant = context.getRequest().getParam("jeton");
            String indice = context.getRequest().getParam("indice");
            int nbCarteAssocie = Integer.parseInt(context.getRequest().getParam("nbMotAssocie"));
            JoueurDAO joueurDAO = new JoueurDAO();
            Joueur joueurCourant = joueurDAO.recupererJoueurDepuisJeton(jetonJoueurCourant);

            var joueursPartie = joueurDAO.recupererJoueurDepuisPartie(joueurCourant.getCode_partie());
            var joueurDistant = new Joueur();
            for (Joueur joueur : joueursPartie) {
                if (joueurCourant != joueur) {
                    joueurDistant = joueur;
                }
            }

            IndiceDAO indiceDAO = new IndiceDAO();

            Indice indiceAInserer = new Indice(0, indice, nbCarteAssocie, 0, 0, joueurCourant.getCode_partie());
            Indice nouveauIndice = indiceDAO.insererNouveauIndice(indiceAInserer);

            IndiceClient reponse = new IndiceClient(indice, nbCarteAssocie);
            context.getSSE().emit("canal_intuition_" + joueurDistant.getJeton(), reponse);

        } catch (SQLException e) {
        }
    }

    public static void devinerMot(WebServerContext context) {
        String jetonJoueurCourant = context.getRequest().getParam("jeton");
        String motDevine = context.getRequest().getParam("mot");

        try {
            CarteDAO carteDAO = new CarteDAO();
            JoueurDAO joueurDAO = new JoueurDAO();

            Joueur joueurCourant = joueurDAO.recupererJoueurDepuisJeton(jetonJoueurCourant);
            ArrayList<Carte> cartesPartieCourante = carteDAO.recupererCartesDepuisCodePartie(joueurCourant.getCode_partie());

            Carte carteCourante = new Carte(null, motDevine, 0, null);
            for (Carte carte : cartesPartieCourante) {
                if (carte.getMot().getMot().equals(motDevine)) {
                    carteCourante = carte;
                }
            }

            PartieDAO partieDAO = new PartieDAO();
            Partie partieCourante = partieDAO.recupererDepuisCodePartie(joueurCourant.getCode_partie());

            var joueursPartie = joueurDAO.recupererJoueurDepuisPartie(joueurCourant.getCode_partie());
            var joueurDistant = new Joueur();
            for (Joueur joueur : joueursPartie) {
                if (joueurCourant != joueur) {
                    joueurDistant = joueur;
                }
            }
            EnvoieReponseCarte reponse = new EnvoieReponseCarte(0, true, false);
            IndiceDAO indiceDAO = new IndiceDAO();
            int scoreActuel = partieCourante.getScore();
            switch (carteCourante.getCouleur()) {
                case 1:
                    reponse = new EnvoieReponseCarte(scoreActuel, true, false);
                    context.getResponse().json(reponse);
                    context.getSSE().emit("canal_mot_" + joueurDistant.getJeton(), reponse);

                    break;
                case 2:
                    Indice dernierIndice = indiceDAO.recupererDernierIndice(joueurCourant.getCode_partie());

                    dernierIndice.setNb_carte_trouve(dernierIndice.getNb_carte_trouve() + 1);

                    int nouveauScore = scoreActuel;
                    int nb_carte_associe = dernierIndice.getNb_carte_associe();
                    int nb_carte_supp = nb_carte_associe + 1;
                    reponse = new EnvoieReponseCarte(nouveauScore, false, false);

                    if (dernierIndice.getNb_carte_trouve() <= nb_carte_associe) {
                        nouveauScore += dernierIndice.getNb_carte_trouve();

                        partieCourante.setScore(scoreActuel);
                    } else if (dernierIndice.getNb_carte_trouve() == nb_carte_supp) {
                        nouveauScore += nb_carte_supp * nb_carte_supp;
                        reponse = new EnvoieReponseCarte(nouveauScore, true, false);
                    }

                    partieDAO.rafraichirScore(partieCourante.getCode_partie(), nouveauScore);

                    context.getResponse().json(reponse);
                    context.getSSE().emit("canal_mot_" + joueurDistant.getJeton(), reponse);
                    break;

                case 3:
                    reponse = new EnvoieReponseCarte(0, true, true);
                    context.getResponse().json(reponse);
                    context.getSSE().emit("canal_mot_" + joueurDistant.getJeton(), reponse);

                    break;
                default:
                    throw new AssertionError();
            }

            //SSE sur le channel_intuition_ + code_partie;
        } catch (SQLException e) {
        }
    }

}
