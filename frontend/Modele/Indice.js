class Indice {
    #id;
    #indice;
    #N;
    constructor() {
        this.#id = 0;
        this.#indice = "";
        this.#N = 0;
    }

    hydrate(data) {
        this.#id = data.id;
        this.#indice = data.mot_indice;
        this.#N = data.N;
    }
}