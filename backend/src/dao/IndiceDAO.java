package dao;


import java.sql.ResultSet;
import java.sql.SQLException;
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
        final Grille grille = new Grille();
        return new Indice(id_indice,indice,N,grille);
    }
}