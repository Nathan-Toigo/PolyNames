package modeleClient;

import modele.Partie;

public class PartieClient {
    private String code;

    public PartieClient(String code) {
        this.code = code;
    }

    public PartieClient(Partie partie){
        this.code = partie.getCode();
    }
}
