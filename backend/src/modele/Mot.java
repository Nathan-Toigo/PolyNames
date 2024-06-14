package modele;

public class Mot {
    private int id_mot;
    private String mot;

    public Mot(int id_mot, String mot) {
        this.id_mot = id_mot;
        this.mot = mot;
    }

    public Mot() {
        this.id_mot = 0;
        this.mot = "";
    }

    public int getId_mot() {
        return id_mot;
    }

    public String getMot() {
        return mot;
    }
}
