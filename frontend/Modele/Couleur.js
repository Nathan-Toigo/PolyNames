class Couleur {
    constructor(){
        this.id = 0;
        this.couleur = "";
    }
    hydrate(data){
        this.id = data.id;
        this.couleur = data.couleur;
    }
}