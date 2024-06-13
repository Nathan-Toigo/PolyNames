import VueAZero from "./VideVue.js";
import { MaitreIntuitionService } from "../Service/MaitreIntuitionService.js";

export class MaitreIntuitionVue {
    constructor() {
    }

    afficherMaitreIntuition(liste_cartes) {
        VueAZero();
        fetch("/PolyNames/frontend/Vue/Patron/maitreIntuition.html").then(response => response.text()).then(text => {
            document.getElementById("principal").innerHTML += text;
            let grille = document.getElementById("cartes");

            liste_cartes.forEach((carte) => {
                let carte_div = this.creerCarte(carte);
                grille.appendChild(carte_div);
            });
        });
    }
    creerCarte(carte) {
        let carte_div = document.createElement("button");
        carte_div.classList.add("carte");
        carte_div.classList.add("glass");
        carte_div.classList.add("cliquable");

        if(carte.couleur === "bleu")
            carte_div.classList.add("face-cachee-bleue");
        else if(carte.couleur === "gris")
            carte_div.classList.add("face-cachee-neutre");
        else if(carte.couleur === "noir")
            carte_div.classList.add("face-cachee-noire");

        if(carte.face_cachee) {
            carte_div.classList.remove("cliquable");
            carte_div.disabled = true;

        }

        carte_div.innerHTML = carte.word;
        carte_div.addEventListener("click", async () => {
            let maitreIntuitionService = new MaitreIntuitionService();
            let nouvelleCarte = await maitreIntuitionService.envoyerCarte(carte.word);
            carte_div.replaceWith(this.creerCarte(nouvelleCarte));
        });
        return carte_div;

    }

}
