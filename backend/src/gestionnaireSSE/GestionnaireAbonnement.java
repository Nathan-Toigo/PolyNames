package gestionnaireSSE;

import BaseWebserver.WebServerSSEEvent;
import BaseWebserver.WebServerSSEEventHandler;

public class GestionnaireAbonnement implements WebServerSSEEventHandler{

    @Override
    public void run(WebServerSSEEvent event) {
        System.out.println("Abonné: " + event.clientId());
    }
}
