package modele;

import java.util.ArrayList;

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
