package modele;

import java.util.ArrayList;
import java.util.Arrays;

public class Dictionnaire extends TableBDD{
    private int id_dictionnaire;
    private String titre;

    public Dictionnaire(){
        super("Dictionnaire",new ArrayList<>(Arrays.asList("id_dictionnaire")));
        this.id_dictionnaire = 0;
        this.titre = "";
    }

    public Dictionnaire(int id_dictionnaire, String titre){
        super("Dictionnaire",new ArrayList<>(Arrays.asList("id_dictionnaire")));
        this.id_dictionnaire = id_dictionnaire;
        this.titre = titre;
    }
}
