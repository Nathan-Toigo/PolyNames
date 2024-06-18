import VueAZero from "./VideVue.js";
import { RejoindreVue } from "./RejoindreVue.js";
import { SSEClient } from "../libs/sse-client.js";
import { MaitreMotVue } from "./MaitreMotVue.js";
import { MaitreIntuitionVue } from "./MaitreIntuitionVue.js";
import { URL_SERVEUR, URL_SSE } from "../const.js";

export class AttenteVue {
    #clientSSE
    constructor() {
        this.#clientSSE = new SSEClient(URL_SSE);
    }
    async afficherAttente() {
        VueAZero();
        let jeton = localStorage.getItem("jeton");
        let canal_distant_jeton = "canal_distant_".concat(jeton);
        await this.#clientSSE.connect();

        fetch("Vue/Patron/attente.html").then(response => response.text()).then(text => {
            document.getElementById("principal").innerHTML += text;
            let boutonMenu = document.getElementsByTagName("button")[0];
            boutonMenu.addEventListener("click", async () => {
                let rejoindreVue = new RejoindreVue();
                rejoindreVue.afficherRejoindre();
                this.#clientSSE.unsubscribe(canal_distant_jeton);

            });
        });

        await this.#clientSSE.subscribe(canal_distant_jeton, (donnee) => {

            let role = donnee.role;
            let grille = donnee.grille;
            if (role === 1) {
                let maitreMotVue = new MaitreMotVue();
                maitreMotVue.afficherMaitreMot(grille);
            }
            else if (role === 2) {
                let maitreIntuitionVue = new MaitreIntuitionVue();
                maitreIntuitionVue.afficherMaitreIntuition(grille);
            }
        });
    }
}