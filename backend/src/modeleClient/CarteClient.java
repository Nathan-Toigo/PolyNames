package modeleClient;

import modele.Carte;

public class CarteClient {
    private String mot;
    private String couleur;

    public CarteClient(String mot, String couleur) {
        this.mot = mot;
        this.couleur = couleur;
    }

    public CarteClient(Carte carte, Boolean maitreInt){
        this.mot = carte.getMot().getMot();
        if(maitreInt)
            this.couleur = "";
        else
            this.couleur = carte.getCouleur().getCouleur();
    }
}
