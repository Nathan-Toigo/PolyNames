class Grille {
    #id;
    #hauteur;
    #largeur;
    #score;
    #indices;
    #joueur;
    constructor(){
        this.#id = 0;
        this.#hauteur = 0;
        this.#largeur = 0;
        this.#score = 0;
        this.#indices = [];
        this.#joueur = new Joueur();
    }
    hydrate(data){
        this.#id = data.id;
        this.#hauteur = data.hauteur;
        this.#largeur = data.largeur;
        this.#score = data.score;
        this.#indices = data.indices;
        this.#joueur.hydrate(data.joueur);
    }


}