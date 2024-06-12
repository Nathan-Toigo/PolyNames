package serveurweb;

import BaseWebserver.WebServerContext;
import dao.JoueurDAO;
import dao.SessionDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Hashtable;
import modele.Joueur;
import modeleClient.GrilleClient;

public class ControlleurCreationCompte {

    public static void creerCompte(WebServerContext context)
    {
        Joueur joueur = new Joueur();
        JoueurDAO joueurDAO = new JoueurDAO();
        
        String pseudoParam = context.getRequest().getParam("pseudonyme");
        Dictionary<String,String> champs = new Hashtable<String, String>();
        champs.put("pseudonyme", pseudoParam);
        try{
            var listeJoueur = joueurDAO.recupererParChamp(joueur, champs);
            if(listeJoueur.isEmpty()){
                Dictionary<String,String> clesQuery = new Hashtable<String, String>();
                clesQuery.put("pseudonyme", pseudoParam);
                joueurDAO.insérerDonnée(joueur, clesQuery);

                ArrayList<GrilleClient> grilleClients = new ArrayList<GrilleClient>();
                context.getResponse().json(grilleClients);

                Joueur nouveauJoueur = joueurDAO.recupererParChamp(joueur, clesQuery).get(0);
                SessionDAO sessionDAO = new SessionDAO();

                String jeton = sessionDAO.creerSession(nouveauJoueur);
                context.getResponse().json(grilleClients);
                context.getResponse().json(jeton);
            }
            else{
                context.getResponse().notFound("Pseudonyme déjà utilisé");
            }

        }
        catch(SQLException e){
            context.getResponse().serverError("Une erreur est survenue lors de la création du compte");
            System.err.println(e.getMessage());
        }
    }
}
