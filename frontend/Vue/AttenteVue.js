import VueAZero from "./VideVue.js";
import {RejoindreVue} from "./RejoindreVue.js";
import {SSEClient} from "../libs/sse-client.js";

export class AttenteVue {
    #clientSSE
    constructor() {
        this.#clientSSE = new SSEClient("http://localhost:8080");
    }
    afficherAttente() {
        VueAZero();
        let jeton = sessionStorage.getItem("jeton");
        this.#clientSSE.connect();
        this.#clientSSE.subscribe("attente", (reponse) => {
            let donnee = JSON.parse(reponse);
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
        fetch("Vue/Patron/attente.html").then(response => response.text()).then(text => {
            document.getElementById("principal").innerHTML += text;
            let boutonMenu = document.getElementsByTagName("button")[0];
            boutonMenu.addEventListener("click", async () => {
                let rejoindreVue = new RejoindreVue();
                rejoindreVue.afficherRejoindre();

            });
        });
    }
}