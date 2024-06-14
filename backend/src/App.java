
import BaseWebserver.WebServer;
import BaseWebserver.WebServerContext;
import controleur.ControleurIndice;
import controleur.ControleurPartie;


public class App {
    public static void main(String[] args) throws Exception {

        WebServer webServer = new WebServer();
        

        webServer.getRouter().get("/creerPartie", (WebServerContext context) -> {
            ControleurPartie.creerPartie(context);
        });

        webServer.getRouter().get("/rejoindrePartie/:code_partie", (WebServerContext context) -> {
            ControleurPartie.rejoindrePartie(context);
        });

        webServer.getRouter().get("/choisirRole/:jeton/:role", (WebServerContext context) -> {
            ControleurPartie.choisirRole(context);
        });

        webServer.getRouter().get("/envoyerIndice/:jeton/:indice/:nbMotAssocie", (WebServerContext context) -> {
            ControleurIndice.envoyerIndice(context);
        });

        webServer.getRouter().get("/devinerMot/:jeton/:mot", (WebServerContext context) -> {
            ControleurIndice.devinerMot(context);
        });
        
        webServer.listen(8080);

        

    }
}