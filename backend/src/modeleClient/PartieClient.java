package modeleClient;

import modele.Partie;

public class PartieClient {
    private String code_partie;
    private int score;

    public PartieClient(String code_partie, int score) {
        this.code_partie = code_partie;
        this.score = score;
    }

    public PartieClient(Partie partie) {
        this.code_partie = partie.getCode_partie();
        this.score = partie.getScore();
    }
}
