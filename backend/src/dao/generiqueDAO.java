package dao;

import database.PolyNamesDatabase;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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

    public T recupererParId(T instanceTable, ArrayList<Integer> ids) throws SQLException{
        var clesPrimaires = instanceTable.getClesPrimaires();
        String requete = String.format("SELECT * FROM %s WHERE ", instanceTable.getNomTable());
        for (int i = 0; i < clesPrimaires.size(); i++) {
            requete+= String.format("%s = %s AND ", clesPrimaires.get(i), ids.get(i));
        }
        requete = requete.substring(0, requete.length() - 4) + ";";

        PreparedStatement ps = this.pnDatabase.prepareStatement(requete);
        ResultSet resultat = ps.executeQuery();
        resultat.next();
        T unSeulT = genererTDepuisEnregistrement(resultat);
        
        return unSeulT;
    }

    protected abstract T genererTDepuisEnregistrement(ResultSet results) throws SQLException;
}