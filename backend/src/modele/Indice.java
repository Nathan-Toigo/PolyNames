package modele;

public class Indice {
    private int id_indice;
    private String indice;
    private int nb_carte_associe;
    private int nb_carte_trouve;
    private int numero_tour_associe;
    private String code_partie;
    
    public Indice(int id_indice, String indice, int nb_carte_associe, int nb_carte_trouve, int numero_tour_associe,
            String code_partie) {
        this.id_indice = id_indice;
        this.indice = indice;
        this.nb_carte_associe = nb_carte_associe;
        this.nb_carte_trouve = nb_carte_trouve;
        this.numero_tour_associe = numero_tour_associe;
        this.code_partie = code_partie;
    }

    public int getId_indice() {
        return id_indice;
    }

    public String getIndice() {
        return indice;
    }

    public int getNb_carte_associe() {
        return nb_carte_associe;
    }

    public int getNb_carte_trouve() {
        return nb_carte_trouve;
    }

    public int getNumero_tour_associe() {
        return numero_tour_associe;
    }

    public String getCode_partie() {
        return code_partie;
    }
    
}
