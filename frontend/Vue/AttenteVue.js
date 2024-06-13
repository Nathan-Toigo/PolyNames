import VueAZero from "./VideVue.js";
import {RejoindreVue} from "./RejoindreVue.js";

export class AttenteVue {
    constructor() {
    }
    afficherAttente() {
        VueAZero();
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