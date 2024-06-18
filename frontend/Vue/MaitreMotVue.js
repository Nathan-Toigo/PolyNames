import { MaitreMotService } from "../Service/MaitreMotService.js";
import VueAZero from "./VideVue.js";

export class MaitreMotVue {
    constructor() {
    }

    afficherMaitreMot(liste_cartes) {
        VueAZero();
        fetch("Vue/Patron/maitreMot.html").then(response => response.text()).then(text => {
            document.getElementById("principal").innerHTML += text;
            let grille = document.getElementById("cartes");

            liste_cartes.forEach((carte) => {
                let carte_div = this.creerCarte(carte);
                let entreeIndice = document.getElementById("entree-indice");
                let entreeNombre = document.getElementById("entree-nombre");
                let boutonEnvoyer = document.getElementById("bouton-envoyer");
                boutonEnvoyer.addEventListener("click", async () => {
                    let indice = entreeIndice.value;
                    let nombre = entreeNombre.value;
                    let jeton = localStorage.getItem("jeton");
                    let maitreMotService = new MaitreMotService;
                    await maitreMotService.envoyerIndice(jeton, indice, nombre);
                });
                // simulation requête sse score
                let score = 58;
                let score_div = document.getElementsByClassName("score-entree")[0];
                score_div.innerHTML = score;
                // simulation requête sse score

                grille.appendChild(carte_div);
            });
        });
    }
    creerCarte(carte) {
        let carte_div = document.createElement("div");
        carte_div.classList.add("carte");
        carte_div.classList.add("glass");
        carte_div.innerHTML = carte.mot;
        if (carte.couleur === 2)
            carte_div.classList.add("bleue");
        else if (carte.couleur === 3)
            carte_div.classList.add("noire");
        else if (carte.couleur === 1)
            carte_div.classList.add("neutre");
        return carte_div;
    }
}


