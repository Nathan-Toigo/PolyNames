package modeleClient;

import dao.CarteDAO;
import dao.GrilleJoueurDAO;
import dao.IndiceDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import modele.Carte;
import modele.Grille;
import modele.Indice;
import modele.Joueur;

public class GrilleClient {
    private int hauteur;
    private int largeur;
    private int score;
    private String etat;
    private ArrayList<JoueurClient> joueurs;
    private String roleJoueurCourant;
    private ArrayList<IndiceClient> indices;
    private ArrayList<CarteClient> cartes;

    public GrilleClient(int hauteur, int largeur, int score, String etat, ArrayList<JoueurClient> joueurs,
            String roleJoueurCourant, ArrayList<IndiceClient> indices, ArrayList<CarteClient> cartes) {
        this.hauteur = hauteur;
        this.largeur = largeur;
        this.score = score;
        this.etat = etat;
        this.joueurs = joueurs;
        this.roleJoueurCourant = roleJoueurCourant;
        this.indices = indices;
        this.cartes = cartes;
    }

    public GrilleClient(Grille grille, Joueur joueurCourant) throws SQLException{
        GrilleJoueurDAO grilleJoueurDAO = new GrilleJoueurDAO();
        IndiceDAO indiceDAO = new IndiceDAO();
        CarteDAO carteDAO = new CarteDAO();

        var grilleJoueurs = grilleJoueurDAO.recupererGrilleJoueurDepuisGrille(grille);
        var indices = indiceDAO.recupererIndicesDepuisGrille(grille);
        var cartes = carteDAO.recupererCartesDepuisGrille(grille);
        
        this.hauteur = grille.getHauteur_grille();
        this.largeur = grille.getLargeur_grille();
        this.score = grille.getScore();
        this.etat = grille.getEtat().getEtat();
        this.joueurs = new ArrayList<JoueurClient>();
        Joueur joueur1 = grilleJoueurs.get(0).getJoueur();
        Joueur joueur2 = grilleJoueurs.get(1).getJoueur();
        this.joueurs.add(new JoueurClient(joueur1));
        this.joueurs.add(new JoueurClient(joueur2));

        if(joueur1 == joueurCourant){
            
            this.roleJoueurCourant = grilleJoueurs.get(0).getRole().getRole();
        }
        else{
            this.roleJoueurCourant = grilleJoueurs.get(1).getRole().getRole();
        }

        this.indices = new ArrayList<IndiceClient>();
        for(Indice i : indices){
            this.indices.add(new IndiceClient(i));
        }

        this.cartes = new ArrayList<CarteClient>();
        for(Carte c : cartes){
            this.cartes.add(new CarteClient(c,this.roleJoueurCourant.equals("Maître des intuitions")));
        }
    }

}
