
import dao.MotDAO;
import java.util.ArrayList;
import java.util.Arrays;
import modele.Mot;


public class App {
    public static void main(String[] args) throws Exception {
        // MotDictionnaireDAO motdao = new MotDictionnaireDAO();
        // MotDictionnaire motdico = new MotDictionnaire();
        // var ids = new ArrayList<>(Arrays.asList(1,12));
        // var mots = motdao.recupererParId(motdico, ids);
        
        // System.out.println(mots.getMot());
        MotDAO motdao = new MotDAO();
        Mot motdico = new Mot();
        var ids = new ArrayList<>(Arrays.asList(13));
        //var mots = motdao.recupererParId(motdico, ids);
        var mots = motdao.recupererParId(motdico, ids);
        System.out.println(mots.getMot());
    }
}