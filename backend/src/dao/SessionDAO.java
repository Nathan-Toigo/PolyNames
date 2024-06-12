package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.Random;
import modele.Joueur;
import modele.Session;

public class SessionDAO extends generiqueDAO<Session> {

    public SessionDAO(){
        super();
    }
    
    @Override
    protected Session genererTDepuisEnregistrement(ResultSet results) throws SQLException {
        final int id_session = results.getInt("id_session");
        final Timestamp creation = results.getTimestamp("creation");
        final String jeton = results.getString("jeton");
        
        Joueur joueur = new Joueur();
        JoueurDAO joueurDAO = new JoueurDAO();
        Dictionary<String,Integer> idJoueur = new Hashtable<>();
        idJoueur.put("id_joueur",results.getInt("id_joueur"));
        joueur = joueurDAO.recupererParId(joueur, idJoueur);
        
        return new Session(id_session,creation,jeton,joueur);
    }

    public Session recupererSessionDepuisJeton(String jeton) throws SQLException{
        Dictionary<String, String> cles= new Hashtable<>();
        cles.put("jeton", jeton);
        
        return this.recupererParChamp(new Session(),cles).get(0);
    }

    public String creerSession(Joueur joueur) throws SQLException{
        String requete = "INSERT INTO Session(creation, jeton, id_joueur) VALUES (NOW(), '%s', %s);";
        String jeton = genererJeton();
        requete = String.format(requete,jeton ,Integer.toString(joueur.getId_joueur()));

        PreparedStatement ps = this.pnDatabase.prepareStatement(requete);
        ps.executeUpdate();
        return jeton;
    }

    public void supprimerSession(String jeton) throws SQLException{
        Dictionary<String, String> cles = new Hashtable<>();
        cles.put("jeton", jeton);
        this.supprimerDonnée(new Session(), cles);;
    }

    /**
     * @param pseudonyme
     * @return true si la session est vide, false sinon.
     * @throws SQLException
     */
    public Boolean testerSession(String pseudonyme) throws SQLException{
        Dictionary<String, String> cles = new Hashtable<>();
        cles.put("pseudonyme", pseudonyme);

        JoueurDAO joueurDAO = new JoueurDAO();
        Joueur joueur = joueurDAO.recupererParChamp(new Joueur(), cles).get(0);

        cles = new Hashtable<>();
        cles.put("id_joueur", Integer.toString(joueur.getId_joueur()));
        var sessions = this.recupererParChamp(new Session(), cles);
        return sessions.isEmpty();
    }

    private String genererJeton() throws SQLException{
        ArrayList<Session> sessions = this.trouverTout(new Session());
        ArrayList<String> tokens = new ArrayList<>();
        for(Session session : sessions){
            tokens.add(session.getJeton());
        }
        
        Boolean fin = true;
        String jeton = "000000000000000";

        while(fin){
            int leftLimit = 48; // numeral '0'
            int rightLimit = 122; // letter 'z'
            int targetStringLength = 15;
            Random random = new Random();
            jeton = random.ints(leftLimit, rightLimit + 1)
            .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
            .limit(targetStringLength)
            .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
            .toString();

            if(!tokens.contains(jeton)){
                fin = false;
            }
        }
        return jeton;
    }
}
