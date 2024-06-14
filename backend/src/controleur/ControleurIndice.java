package controleur;

import BaseWebserver.WebServerContext;
import dao.CarteDAO;
import dao.IndiceDAO;
import dao.JoueurDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import modele.Carte;
import modele.Indice;
import modele.Joueur;

public class ControleurIndice {

    public static void envoyerIndice(WebServerContext context) {
        String jetonJoueurCourant = context.getRequest().getParam("jeton");
        String indice = context.getRequest().getParam("indice");
        int nbCarteAssocie = Integer.parseInt(context.getRequest().getParam("nbMotAssocie"));

        try {
            IndiceDAO indiceDAO = new IndiceDAO();
            JoueurDAO joueurDAO = new JoueurDAO();

            Joueur joueurCourant = joueurDAO.recupererJoueurDepuisJeton(jetonJoueurCourant);

            Indice indiceAInserer = new Indice(0, indice, nbCarteAssocie, 0, 0, joueurCourant.getCode_partie());

            Indice nouveauIndice = indiceDAO.insererNouveauIndice(indiceAInserer);

            context.getResponse().ok("");

            //SSE sur le channel_intuition_ + code_partie;
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

            switch (carteCourante.getCouleur()) {
                case 1:
                    
                    break;
                case 2:

                    break;
                case 3:

                    break;
                default:
                    throw new AssertionError();
            }

            //SSE sur le channel_intuition_ + code_partie;
        } catch (SQLException e) {
        }
    }

}
