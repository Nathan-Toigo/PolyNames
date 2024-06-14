package controleur;

import BaseWebserver.WebServerContext;
import dao.CarteDAO;
import dao.JoueurDAO;
import dao.MotDAO;
import dao.PartieDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import modele.Carte;
import modele.Joueur;
import modele.Mot;
import modele.Partie;
import modeleClient.CarteClient;
import modeleClient.EnvoieCartesJoueur;
import modeleClient.JoueurClient;
import modeleClient.PartieClient;
import modeleClient.RequeteConnection;

public class ControleurPartie {

    public static void creerPartie(WebServerContext context) {
        try {
            PartieDAO partieDAO = new PartieDAO();
            Partie nouvellePartie = partieDAO.genererNouvellePartie();

            JoueurDAO joueurDAO = new JoueurDAO();
            Joueur nouveauJoueur = joueurDAO.genererNouveauJoueur(nouvellePartie, true);

            RequeteConnection reponse = new RequeteConnection(new JoueurClient(nouveauJoueur), new PartieClient(nouvellePartie));
            context.getResponse().json(reponse);

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    public static void rejoindrePartie(WebServerContext context) {
        String codePartie = context.getRequest().getParam("code_partie");

        try {
            PartieDAO partieDAO = new PartieDAO();
            Partie partieCourante = partieDAO.recupererDepuisCodePartie(codePartie);

            JoueurDAO joueurDAO = new JoueurDAO();
            Joueur nouveauJoueur = joueurDAO.genererNouveauJoueur(partieCourante, false);

            if (partieCourante.getEst_complete()) {
                context.getResponse().notFound("Partie complète");
                return;
            }

            partieDAO.rendrePartieComplete(codePartie);
            context.getResponse().json(new JoueurClient(nouveauJoueur));
            
            context.getSSE().emit("canal_hote_" + codePartie, "ok");

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    public static void choisirRole(WebServerContext context) {
        String jeton = context.getRequest().getParam("jeton");
        int role = Integer.parseInt(context.getRequest().getParam("role"));

        try {
            JoueurDAO joueurDAO = new JoueurDAO();
            Joueur joueurHote = joueurDAO.recupererJoueurDepuisJeton(jeton);
            if(!joueurHote.getEst_hote()){
                context.getResponse().notFound("Mauvais droits");
                return;
            }
            PartieDAO partieDAO = new PartieDAO();
            Partie partieCourante = partieDAO.recupererDepuisCodePartie(joueurHote.getCode_partie());

            if(partieCourante.getEst_initialisee()){
                context.getResponse().notFound("Partie déjà initialisée");
                return;
            }

            if(!partieCourante.getEst_complete()){
                context.getResponse().notFound("Pas assez de joueur dans la partie");
                return;
            }

            ArrayList<Joueur> joueursDePartieCourante = joueurDAO.recupererJoueurDepuisPartie(joueurHote.getCode_partie());
            Joueur joueurDistant = new Joueur();

            for(Joueur joueur : joueursDePartieCourante){
                if(!joueur.getEst_hote()){
                    joueurDistant = joueur;
                }
            }
            String codePartieCourante = joueurHote.getCode_partie();

            if(role == 1)
            {
                joueurDAO.rafraichirRoleJoueur(joueurHote.getJeton(), 1);
                joueurDAO.rafraichirRoleJoueur(joueurDistant.getJeton(), 2);
            }
            else{
                joueurDAO.rafraichirRoleJoueur(joueurHote.getJeton(), 2);
                joueurDAO.rafraichirRoleJoueur(joueurDistant.getJeton(), 1);
            }

            CarteDAO carteDAO = new CarteDAO();
            MotDAO motDAO = new MotDAO();
            ArrayList<Mot> mots = motDAO.recupererMotsNouvellePartie();
            ArrayList<Carte> nouvelleCartes = carteDAO.genererCartesPartie(mots, codePartieCourante);
            
            partieDAO.rendrePartieInitialisee(codePartieCourante);

            ArrayList<CarteClient> cartesAEnvoyerMaitreMot = new ArrayList<>();
            ArrayList<CarteClient> cartesAEnvoyerMaitreIntuition = new ArrayList<>();
            for(Carte carte : nouvelleCartes){
                CarteClient carteClientHote = new CarteClient(carte, 1);
                cartesAEnvoyerMaitreMot.add(carteClientHote);
                CarteClient carteClientDistant = new CarteClient(carte, 2);
                cartesAEnvoyerMaitreIntuition.add(carteClientDistant);
            }

            EnvoieCartesJoueur reponseMaitreMot = new EnvoieCartesJoueur(cartesAEnvoyerMaitreMot, 1);
            EnvoieCartesJoueur reponseMaitreIntuition = new EnvoieCartesJoueur(cartesAEnvoyerMaitreIntuition, 2);

            if(role == 1){
                context.getResponse().json(reponseMaitreMot);
                context.getSSE().emit("canal_distant_" + joueurDistant.getJeton(), reponseMaitreIntuition);
            }
            else{
                context.getResponse().json(reponseMaitreIntuition);
                context.getSSE().emit("canal_distant_" + joueurDistant.getJeton(), reponseMaitreMot);
            }

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

    }
}
