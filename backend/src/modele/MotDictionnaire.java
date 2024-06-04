package modele;

import java.util.ArrayList;
import java.util.Arrays;

public class MotDictionnaire extends TableBDD{
    private Dictionnaire dictionnaire;
    private Mot mot;

    public MotDictionnaire(){
        super("Mot_Dictionnaire",new ArrayList<>(Arrays.asList("id_dictionnaire","id_mot")));
        this.dictionnaire = new Dictionnaire();
        this.mot = new Mot();
    }

    public MotDictionnaire(Dictionnaire dictionnaire, Mot mot){
        super("Mot_Dictionnaire",new ArrayList<>(Arrays.asList("id_dictionnaire","id_mot")));
        this.dictionnaire = dictionnaire;
        this.mot = mot;
    }

    public Dictionnaire getDictionnaire() {
        return dictionnaire;
    }

    public Mot getMot() {
        return mot;
    }
}
