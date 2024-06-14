package gestionnaireSSE;

import BaseWebserver.WebServerSSEEvent;
import BaseWebserver.WebServerSSEEventHandler;

public class GestionnaireConnection implements WebServerSSEEventHandler{

    @Override
    public void run(WebServerSSEEvent event) {
        System.out.println("Connecté: " + event.clientId());
    }

}
