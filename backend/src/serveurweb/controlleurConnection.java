package serveurweb;

import BaseWebserver.WebServerContext;
import dao.GrilleDAO;
import dao.JoueurDAO;
import dao.SessionDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Hashtable;
import modele.Grille;
import modele.Joueur;
import modeleClient.GrilleClient;

public class ControlleurConnection {

    public static void seConnecter(WebServerContext context)
    {
        SessionDAO sessionDAO = new SessionDAO();

        Joueur joueurGenerique = new Joueur();
        JoueurDAO joueurDAO = new JoueurDAO();

        
        String pseudoParam = context.getRequest().getParam("pseudonyme");
        try {
            if(!joueurDAO.testerPseudo(pseudoParam))
            {
                if(sessionDAO.testerSession(pseudoParam)){
                    Dictionary<String,String> clesQuery = new Hashtable<String, String>();
                    clesQuery.put("pseudonyme", pseudoParam);
    
                    
    
                    Joueur joueurCourant = joueurDAO.recupererParChamp(joueurGenerique, clesQuery).get(0);
                    String jeton = sessionDAO.creerSession(joueurCourant);
                    
                    GrilleDAO grilleDAO = new GrilleDAO();
                    ArrayList<Grille> grilles = grilleDAO.recupererGrilleDepuisJoueur(joueurCourant);

                    ArrayList<GrilleClient> grillesAEnvoyer = new ArrayList<>();

                    for(Grille grille : grilles){
                        grillesAEnvoyer.add(new GrilleClient(grille, joueurCourant));
                    }

                    Object[] retours = new Object[2];
                    retours[0] = jeton;
                    retours[1] = grillesAEnvoyer;

                    context.getResponse().json(retours);
    
                }
                else{
                    context.getResponse().notFound("Utilisateur déjà connecté");
                }
            }
            else{
                context.getResponse().notFound("Cet utilisateur n'existe pas");
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }


    
}
