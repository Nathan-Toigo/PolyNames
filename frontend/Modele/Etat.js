class Etat {
    #id;
    #etat;
    constructor() {
        this.#id = 0;
        this.#etat = "";
    }
    hydrate(data) {
        this.#id = data.id;
        this.#etat = data.etat;
    }
}
