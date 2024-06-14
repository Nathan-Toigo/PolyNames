package modele;

public class Carte {
    private Mot mot;
    private String code_partie;
    private int couleur;
    private Boolean face_cachee;
    
    public Carte(Mot mot, String code_partie, int couleur, Boolean face_cachee) {
        this.mot = mot;
        this.code_partie = code_partie;
        this.couleur = couleur;
        this.face_cachee = face_cachee;
    }

    public Mot getMot() {
        return mot;
    }

    public String getCode_partie() {
        return code_partie;
    }

    public int getCouleur() {
        return couleur;
    }

    public Boolean getFace_cachee() {
        return face_cachee;
    }

}
