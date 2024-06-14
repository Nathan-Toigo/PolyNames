import VueAZero from "./VideVue.js";
import { ConnexionService } from "../Service/ConnexionService.js";
import { RejoindreVue } from "./RejoindreVue.js";
import { MaitreMotVue } from "./MaitreMotVue.js";
import { MaitreIntuitionVue } from "./MaitreIntuitionVue.js";

export class RoleVue {
    constructor() {
    }

    afficherRole(codePartie) {
        VueAZero();
        fetch("/PolyNames/frontend/Vue/Patron/role.html").then(response => response.text()).then(text => {
            document.getElementById("principal").innerHTML += text;

            let boutonCopie = document.getElementsByTagName("button")[0];
            let boutonMaitreMot = document.getElementsByTagName("button")[1];
            let boutonMaitreIntuition = document.getElementsByTagName("button")[2];
            let boutonMenu = document.getElementsByTagName("button")[3];
            let codePartieElement = document.getElementById("code-partie");
            codePartieElement.innerHTML = codePartie;
            boutonCopie.addEventListener("click", async () => {
                boutonCopie.innerHTML = this.copier();
            });
            let jeton = sessionStorage.getItem("jeton");
            boutonMaitreMot.addEventListener("click", async () => {
                let connexionService = new ConnexionService();
                let grille = await connexionService.choisirRole(jeton,1);
                let maitreMotVue = new MaitreMotVue();
                maitreMotVue.afficherMaitreMot(grille);
            });
            boutonMaitreIntuition.addEventListener("click", async () => {
                let connexionService = new ConnexionService();
                let grille = await connexionService.choisirRole(jeton,2);
                let maitreIntuitionVue = new MaitreIntuitionVue();
                maitreIntuitionVue.afficherMaitreIntuition(grille);

            });
            boutonMenu.addEventListener("click", async () => {
                let connexionService = new ConnexionService();
                await connexionService.menu();
                let rejoindreVue = new RejoindreVue();
                rejoindreVue.afficherRejoindre();
            });
        });
    }
    copier() {
        let code = document.getElementById("code-partie").innerText;
        navigator.clipboard.writeText(code);
        return "copié!"
    }
}