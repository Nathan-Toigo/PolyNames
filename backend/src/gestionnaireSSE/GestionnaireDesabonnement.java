package gestionnaireSSE;

import BaseWebserver.WebServerSSEEvent;
import BaseWebserver.WebServerSSEEventHandler;

public class GestionnaireDesabonnement implements WebServerSSEEventHandler{

    @Override
    public void run(WebServerSSEEvent event) {
        System.out.println("Désabonné: " + event.clientId());
    }

}
