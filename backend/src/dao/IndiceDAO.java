package dao;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Dictionary;
import java.util.Hashtable;
import modele.Grille;
import modele.Indice;


public class IndiceDAO extends generiqueDAO<Indice>{

    public IndiceDAO(){
        super();
    }
    
    @Override
    protected Indice genererTDepuisEnregistrement(ResultSet results) throws SQLException {
        final int id_indice = results.getInt("id_indice");
        final String indice = results.getString("indice");
        final Byte N = results.getByte("N");
        
        Grille grille = new Grille();
        GrilleDAO grilleDAO = new GrilleDAO();
        Dictionary<String,Integer> idGrille = new Hashtable<>();
        idGrille.put("id_grille",results.getInt("id_grille"));
        grille = grilleDAO.recupererParId(grille, idGrille);
        
        return new Indice(id_indice,indice,N,grille);
    }
}