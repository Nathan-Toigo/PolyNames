package dao;

import database.PolyNamesDatabase;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Dictionary;

import modele.TableBDD;


public abstract class generiqueDAO<T extends TableBDD> {
    
    PolyNamesDatabase pnDatabase;


    public generiqueDAO(){
        try{
            this.pnDatabase = new PolyNamesDatabase();
        }
        catch(SQLException e)
        {
            System.err.println(e);
        }
    }

    /**
     * 
     * @param instanceTable Instance générique
     * @return ArrayList<T> de toutes les instances de la table. Si aucune instance, ArrayList<T> est vide.
     * @throws SQLException
     */
    public ArrayList<T> trouverTout(T instanceTable) throws SQLException{
        String requete = String.format("SELECT * FROM %s;", instanceTable.getNomTable());
        PreparedStatement ps = this.pnDatabase.prepareStatement(requete);
        ResultSet resultats = ps.executeQuery();
        ArrayList<T> plusieursT = new ArrayList<T>();
        while (resultats.next()) {
            plusieursT.add(genererTDepuisEnregistrement(resultats));
        }
        return plusieursT;
    }

    /**
     * 
     * @param instanceTable Instance générique
     * @param ids Dictionnaire d'instance : "pk_table.s" = id_table.s
     * @return Objet T correspondant à l'ID. Si il n'existe pas, retourne l'objet instanceTable passé en paramètre.
     * @throws SQLException
     */
    public T recupererParId(T instanceTable, Dictionary<String, Integer> ids) throws SQLException{
        var clesPrimaires = instanceTable.getClesPrimaires();
        String requete = String.format("SELECT * FROM %s WHERE ", instanceTable.getNomTable());

        //vérifie les champs d'ids primaires et ajoute leur clé à leur valeur recherché
        for (int i = 0; i < clesPrimaires.size(); i++) {
            requete+= String.format("%s = %s AND ", clesPrimaires.get(i), ids.get(clesPrimaires.get(i)));
        }
        requete = requete.substring(0, requete.length() - 4) + ";"; // enlève le dernier "AND" et ajoute un ; 

        PreparedStatement ps = this.pnDatabase.prepareStatement(requete);
        ResultSet resultat = ps.executeQuery();
        T unSeulT = instanceTable;
        if(resultat.next()){
            unSeulT = genererTDepuisEnregistrement(resultat);
        }
        return unSeulT;
    }

    /**
     * 
     * @param results Objet 
     * @return
     * @throws SQLException
     */
    protected abstract T genererTDepuisEnregistrement(ResultSet results) throws SQLException;
}