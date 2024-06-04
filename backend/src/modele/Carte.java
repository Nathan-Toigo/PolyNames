package modele;

import java.util.ArrayList;
import java.util.Arrays;

public class Carte extends TableBDD{
   
   private Boolean face_cachee;
   private byte ligne;
   private byte colonne;
   private Mot mot;
   private Couleur couleur;
   private Grille grille;

   public Carte(){
      super("Carte",new ArrayList<>(Arrays.asList("id_grille", "id_mot")));
      this.face_cachee = false;
      this.ligne = 0;
      this.colonne = 0;
      this.mot = new Mot();
      this.couleur = new Couleur();
      this.grille = new Grille();
   }

   public Carte(Boolean face_cachee, byte ligne, byte colonne, Mot mot, Couleur couleur, Grille grille){
      super("Carte",new ArrayList<>(Arrays.asList("id_grille", "id_mot")));
      this.face_cachee = face_cachee;
      this.ligne = ligne;
      this.colonne = colonne;
      this.mot = mot;
      this.couleur = couleur;
      this.grille = grille;
   }
}
