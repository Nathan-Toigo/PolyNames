package modele;

import java.util.ArrayList;

/** 
 * Classe représentant toutes les tables de la BDD. Stock le nom et les clés primaires de la table quelle représentent. 
*/
public abstract class TableBDD {
    private  String nomTable;
    private ArrayList<String> clesPrimaires;

    public TableBDD(String nomTable,ArrayList<String> clesPrimaires){
        this.nomTable = nomTable;
        this.clesPrimaires = clesPrimaires;
    }

    public String getNomTable() {
        return nomTable;
    }

    public ArrayList<String> getClesPrimaires() {
        return clesPrimaires;
    }
}
