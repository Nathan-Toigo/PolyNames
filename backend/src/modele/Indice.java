package modele;

import java.util.ArrayList;
import java.util.Arrays;

public class Indice extends TableBDD{
    private int id_indice;
    private String indice;
    private byte N;
    private Grille grille;

    public Indice(){
        super("Indice",new ArrayList<>(Arrays.asList("id_indice")));
        this.id_indice = 0;
        this.indice = "";
        this.N = 0;
        this.grille = new Grille();
    }

    public Indice(int id_indice, String indice,byte N, Grille grille){
        super("Indice",new ArrayList<>(Arrays.asList("id_indice")));
        this.id_indice = id_indice;
        this.indice = indice;
        this.N = N;
        this.grille = grille;
    }

    public int getId_indice() {
        return id_indice;
    }

    public String getIndice() {
        return indice;
    }

    public byte getN() {
        return N;
    }

    public Grille getGrille() {
        return grille;
    }
}
