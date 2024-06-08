
import dao.MotDictionnaireDAO;
import java.util.Dictionary;
import java.util.Hashtable;
import modele.MotDictionnaire;


public class App {
    public static void main(String[] args) throws Exception {

        MotDictionnaireDAO carteDAO = new MotDictionnaireDAO();
        MotDictionnaire carte = new MotDictionnaire();
        Dictionary<String,Integer> idCarte = new Hashtable<>();
        idCarte.put("id_mot",43);
        idCarte.put("id_dictionnaire",1);
        var carteResult = carteDAO.recupererParId(carte, idCarte);
        System.out.println(carteResult.getDictionnaire().getTitre());

    }
}