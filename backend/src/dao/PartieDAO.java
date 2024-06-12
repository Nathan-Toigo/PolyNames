package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.Random;
import modele.Partie;

public class PartieDAO extends generiqueDAO<Partie> {

    public PartieDAO(){
        super();
    }

    @Override
    protected Partie genererTDepuisEnregistrement(ResultSet results) throws SQLException {
        final int id_partie = results.getInt("id_partie");
        final String code = results.getString("code");
        
        return new Partie(id_partie,code);
    }

    public Partie recupererPartieDepuisCode(String code) throws SQLException{
        Dictionary<String, String> cles= new Hashtable<>();
        cles.put("code", code);

        var parties = this.recupererParChamp(new Partie(),cles);
        var retour = new Partie(); 
        if(!parties.isEmpty())
        {
            retour = parties.get(0);
        }
        return retour;
    }

    public String creerPartie() throws SQLException{
        Dictionary<String, String> cles= new Hashtable<>();
        String code = genererCode();
        cles.put("code", code);

        this.insérerDonnée(new Partie(),cles);
        return code;
    }

    private String genererCode() throws SQLException{
        ArrayList<Partie> parties = this.trouverTout(new Partie());
        ArrayList<String> codes = new ArrayList<>();
        for(Partie partie : parties){
            codes.add(partie.getCode());
        }
        
        Boolean fin = true;
        String code = "0000000000";

        while(fin){
            int leftLimit = 48; // numeral '0'
            int rightLimit = 122; // letter 'z'
            int targetStringLength = 10;
            Random random = new Random();
            code = random.ints(leftLimit, rightLimit + 1)
            .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
            .limit(targetStringLength)
            .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
            .toString();

            if(!codes.contains(code)){
                fin = false;
            }
        }
        return code;
    }
}
