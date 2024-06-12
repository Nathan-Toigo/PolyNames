
import BaseWebserver.WebServer;
import BaseWebserver.WebServerContext;
import serveurweb.exController;


public class App {
    public static void main(String[] args) throws Exception {

        WebServer webServer = new WebServer();
        exController mc = new exController();
        
        webServer.getRouter().get("/ex", (WebServerContext context) -> {
            mc.findAll(context);
        });
        
        webServer.listen(8081);

    }
}