class Mot{
    #id;
    #mot;
    constructor(){
        this.#id = 0;
        this.#mot = "";
    }
    hydrate(data){
        this.#id = data.id;
        this.#mot = data.mot;
    }
}