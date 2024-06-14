package modeleClient;

import modele.Joueur;

public class JoueurClient {

    private String jeton;

    public JoueurClient(String jeton) {
        this.jeton = jeton;
    }

    public JoueurClient(Joueur joueur) {
        this.jeton = joueur.getJeton();
    }

}
