package modele;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;

public class Session extends TableBDD {

    private int id_session;
    private Timestamp creation;
    private String jeton;
    private Joueur joueur;

    public Session(){
        super("Session",new ArrayList<>(Arrays.asList("id_session")));
        this.id_session = 0;
        this.creation = new Timestamp(0);
        this.joueur = new Joueur();
        this.jeton = "";
    }

    public Session(int id_session,Timestamp creation, String jeton,Joueur joueur){
        super("Session",new ArrayList<>(Arrays.asList("id_session")));
        this.id_session = id_session;
        this.creation = creation;
        this.joueur = joueur;
        this.jeton = jeton;
    }

    public int getId_session() {
        return id_session;
    }

    public Timestamp getCreation() {
        return creation;
    }

    public String getJeton() {
        return jeton;
    }

    public Joueur getJoueur() {
        return joueur;
    }
}
