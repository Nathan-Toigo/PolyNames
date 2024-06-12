package modeleClient;

import modele.Indice;

public class IndiceClient {
    private String indice;
    private int n;

    public IndiceClient(String indice, int n) {
        this.indice = indice;
        this.n = n;
    }

    public IndiceClient(Indice indice){
        this.indice = indice.getIndice();
        this.n = indice.getN();
    }
}
