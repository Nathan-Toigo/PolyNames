package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import modele.Indice;

public class IndiceDAO extends generiqueDAO{

    public IndiceDAO(){
        super();
    }

    public Indice generateCardFromResultSet(ResultSet resultat) throws SQLException{
        final int id_indice = resultat.getInt("id_indice");
        final String indice = resultat.getString("indice");
        final int nb_carte_associe = resultat.getInt("nb_carte_associe");
        final int nb_carte_trouve = resultat.getInt("nb_carte_trouve");
        final int numero_tour_associe = resultat.getInt("numero_tour_associe");
        final String code_partie = resultat.getString("code_partie");
        return new Indice(id_indice,indice,nb_carte_associe,nb_carte_trouve,numero_tour_associe,code_partie);
    }
    
}