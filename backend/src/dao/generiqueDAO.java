package dao;

import database.PolyNamesDatabase;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Enumeration;

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
     * @param instanceTable Instance générique
     * @param champsARechercher Dictionnaire des champs à rechercher : "table.clé" = "valeurCherchée"
     * @return Liste d'objet T correspondant aux résultats de la recherche.
     * @throws SQLException
     */
    public ArrayList<T> recupererParChamp(T instanceTable, Dictionary<String, String> champsARechercher) throws SQLException{
        String requete = String.format("SELECT * FROM %s WHERE ", instanceTable.getNomTable());

        Enumeration colonnes = champsARechercher.keys();
        while (colonnes.hasMoreElements()){ // on ajoute le combo clé/valeur dans la recherche
            var cle = colonnes.nextElement();
            requete+= String.format("%s = '%s' AND ", cle, champsARechercher.get(cle));
        }
        requete = requete.substring(0, requete.length() - 4) + ";"; // enlève le dernier "AND" et ajoute un ; 

        PreparedStatement ps = this.pnDatabase.prepareStatement(requete);
        ResultSet resultats = ps.executeQuery();
        ArrayList<T> plusieursT = new ArrayList<T>();
        while(resultats.next()) {
            plusieursT.add(genererTDepuisEnregistrement(resultats));
        }
        return plusieursT;
    }

    public int compterParChamp(T instanceTable, Dictionary<String, String> champsARechercher) throws SQLException{
        String requete = String.format("SELECT COUNT(*) AS compte FROM %s WHERE ", instanceTable.getNomTable());

        Enumeration colonnes = champsARechercher.keys();
        while (colonnes.hasMoreElements()){ // on ajoute le combo clé/valeur dans la recherche
            var cle = colonnes.nextElement();
            requete+= String.format("%s = '%s' AND ", cle, champsARechercher.get(cle));
        }
        requete = requete.substring(0, requete.length() - 4) + ";"; // enlève le dernier "AND" et ajoute un ; 

        PreparedStatement ps = this.pnDatabase.prepareStatement(requete);
        ResultSet nbLignes = ps.executeQuery();
        nbLignes.next();
        int compte = nbLignes.getInt("compte");
        return compte;
    }

    /**
     * 
     * @param instanceTable Instance générique
     * @param champsAInserer Dictionnaire des champs insérer : "table.clé" = "valeurAInserer"
     * @return void
     * @throws SQLException
     */
    public void insérerDonnée(T instanceTable, Dictionary<String, String> champsAInserer) throws SQLException{
        String requete = String.format("INSERT INTO %s(", instanceTable.getNomTable());

        Enumeration colonnes = champsAInserer.keys();
        while (colonnes.hasMoreElements()){ // on ajoute toutes les clés dans la requête
            var cle = colonnes.nextElement();
            requete+= String.format("%s,", cle);
        }

        requete = requete.substring(0, requete.length() - 1) + ") VALUES("; // enlève la derniere , et ajoute ") VALUES("

        colonnes = champsAInserer.keys();
        while (colonnes.hasMoreElements()){
            var cle = colonnes.nextElement();
            requete+= String.format("'%s',",champsAInserer.get(cle));
        }

        requete = requete.substring(0, requete.length() - 1) + ");"; // enlève la derniere , et ajoute "):"

        PreparedStatement ps = this.pnDatabase.prepareStatement(requete);
        ps.executeUpdate();
    }

    /**
     * 
     * @param instanceTable Instance générique
     * @param champsAInserer Dictionnaire des champs insérer : "table.clé" = "Identifiant.s de.s la table.s à supprimer"
     * @return void
     * @throws SQLException
     */
    public void supprimerDonnée(T instanceTable, Dictionary<String, String> cleASupprimer) throws SQLException{
        String requete = String.format("DELETE FROM %s WHERE ", instanceTable.getNomTable());

        Enumeration colonnes = cleASupprimer.keys();
        while (colonnes.hasMoreElements()){
            var cle = colonnes.nextElement();
            requete+= String.format("%s = %s AND", cle, cleASupprimer.get(cle));
        }

        requete = requete.substring(0, requete.length() - 4) + ");";
        PreparedStatement ps = this.pnDatabase.prepareStatement(requete);
        ps.executeUpdate();
    }

    /**
     * 
     * @param results Résultats d'une requête SQL 
     * @return Objet T initialisé
     * @throws SQLException
     */
    protected abstract T genererTDepuisEnregistrement(ResultSet results) throws SQLException;
}