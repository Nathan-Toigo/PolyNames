import VueAZero from "./VideVue.js";
import { ConnexionService } from "../Service/ConnexionService.js";
import { RoleVue } from "./RoleVue.js";
import {AttenteVue} from "./AttenteVue.js";
export class RejoindreVue{
    constructor() {
    }

    afficherRejoindre() {
        VueAZero();
        fetch("/PolyNames/frontend/Vue/Patron/rejoindre.html").then(response => response.text()).then(text => {
            document.getElementById("principal").innerHTML += text;
            let codePartie = document.getElementsByTagName("input")[0];
            let boutonRejoindre = document.getElementsByTagName("button")[0];
            let boutonCreer = document.getElementsByTagName("button")[1];
            boutonRejoindre.addEventListener("click", async () => {
                let code = codePartie.value;
                let connexionService = new ConnexionService();
                let donnee = await connexionService.rejoindre(code);
                sessionStorage.setItem("token", donnee.token);
                let attendreVue = new AttenteVue();
                attendreVue.afficherAttente();

            });
            boutonCreer.addEventListener("click", async () => {
                let connexionService = new ConnexionService();
                let donnee = await connexionService.creer();
                let token = donnee.token;
                sessionStorage.setItem("token", token);
                let codePartie = donnee.codePartie;
                let roleVue = new RoleVue();
                roleVue.afficherRole(token, codePartie);

            });
        });

    }
}