package modele;

public class Partie {
    private String code_partie;
    private int score;
    private Boolean est_complete;
    private Boolean est_initialisee;

    public Partie() {
        this.code_partie = "";
        this.score = 0;
        this.est_complete = false;
    }
    
    public Partie(String code_partie, int score, Boolean est_complete, Boolean est_initialisee) {
        this.code_partie = code_partie;
        this.score = score;
        this.est_complete = est_complete;
        this.est_initialisee = est_initialisee;
    }

    public String getCode_partie() {
        return code_partie;
    }

    public int getScore() {
        return score;
    }

    public Boolean getEst_complete() {
        return est_complete;
    }

    public Boolean getEst_initialisee() {
        return est_initialisee;
    }

}
