
import BaseWebserver.WebServer;
import BaseWebserver.WebServerContext;
import dao.GrilleJoueurDAO;
import dao.JoueurDAO;
import java.util.Dictionary;
import java.util.Hashtable;
import modele.Joueur;
import serveurweb.ControlleurConnection;
import serveurweb.ControlleurCreationCompte;
import serveurweb.ControlleurMenuPrincipal;


public class App {
    public static void main(String[] args) throws Exception {

        WebServer webServer = new WebServer();
        
        webServer.getRouter().get("/creer/:pseudonyme", (WebServerContext context) -> {
            ControlleurCreationCompte.creerCompte(context);
        });

        webServer.getRouter().get("/seConnecter/:pseudonyme", (WebServerContext context) -> {
            ControlleurConnection.seConnecter(context);
        });

        webServer.getRouter().get("/rejoindrePartie/:jeton/:code", (WebServerContext context) -> {
            ControlleurMenuPrincipal.rejoindre(context);
        });

        webServer.getRouter().get("/creerPartie/:jeton", (WebServerContext context) -> {
            ControlleurMenuPrincipal.creer(context);
        });

        webServer.getRouter().get("/supprimerPartie/:jeton/", (WebServerContext context) -> {
            ControlleurMenuPrincipal.supprimer(context);
        });
        
        webServer.listen(8080);

        GrilleJoueurDAO grilleJoueurDAO = new GrilleJoueurDAO();
        JoueurDAO joueurDAO = new JoueurDAO();
        Dictionary<String,Integer> cles = new Hashtable<>();
        cles.put("id_joueur",1);

        Joueur joueur = joueurDAO.recupererParId(new Joueur(), cles);
        System.out.println(grilleJoueurDAO.recupererNombrePartieDepuisJoueur(joueur));

    }
}