package modeleClient;

import modele.Joueur;

public class JoueurClient {
    private String pseudonyme;

    public JoueurClient(String pseudonyme) {
        this.pseudonyme = pseudonyme;
    }

    public JoueurClient(Joueur joueur){
        this.pseudonyme = joueur.getPseudonyme();
    }
    
}
