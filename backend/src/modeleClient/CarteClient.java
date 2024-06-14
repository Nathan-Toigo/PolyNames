package modeleClient;

import modele.Carte;

public class CarteClient {
    private String mot;
    private int couleur;
    private Boolean face_cachee;

    public CarteClient(String mot, int couleur, Boolean face_cachee) {
        this.mot = mot;
        this.couleur = couleur;
        this.face_cachee = face_cachee;
    }

    public CarteClient(Carte carte, int role) {
        this.mot = carte.getMot().getMot();
        this.face_cachee = carte.getFace_cachee();

        if (role == 1) {
            this.couleur = carte.getCouleur();
        } else {
            this.couleur = 0;
        }
    }
}
