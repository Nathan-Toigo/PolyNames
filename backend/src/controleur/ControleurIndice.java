package controleur;

import BaseWebserver.WebServerContext;
import dao.CarteDAO;
import dao.IndiceDAO;
import dao.JoueurDAO;
import java.sql.SQLException;
import java.util.ArrayList;
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

            ArrayList<Carte> cartesPartieCourante = carteDAO.

            //SSE sur le channel_intuition_ + code_partie;
        } catch (SQLException e) {
        }
    }

}
