class Joueur {
    #id;
    #pseudonyme;
    constructor() {
        this.#id = 0;
        this.#pseudonyme = "";
    }
    hydrate(data) {
        this.#id = data.id;
        this.#pseudonyme = data.pseudonyme;
    }
}