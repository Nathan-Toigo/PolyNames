import { Couleur } from "./Couleur.js";
import { Mot } from "./Mot.js";
class Carte {
    #mot;
    #couleur;
    #face_cachee;
    #ligne;
    #colonne;

    constructor(){
        this.#mot = new Mot();
        this.#couleur = new Couleur();
        this.#face_cachee = true;
        this.#ligne = 0;
        this.#colonne = 0;
    }
    hydrate(data){
        this.#mot.hydrate(data.mot);
        this.#couleur.hydrate();
        this.#face_cachee = data.face_cachee;
        this.#ligne = data.ligne;
        this.#colonne = data.colonne;
    }
}