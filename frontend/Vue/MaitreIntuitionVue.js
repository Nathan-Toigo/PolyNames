import VueAZero from "./VideVue.js";
import { MaitreIntuitionService } from "../Service/MaitreIntuitionService.js";

export class MaitreIntuitionVue {
    constructor() {
    }

    afficherMaitreIntuition(liste_cartes) {
        VueAZero();
        fetch("Vue/Patron/maitreIntuition.html").then(response => response.text()).then(text => {
            document.getElementById("principal").innerHTML += text;
            let grille = document.getElementById("cartes");

            liste_cartes.forEach((carte) => {
                let carte_div = this.creerCarte(carte);
                grille.appendChild(carte_div);
            });
            // simulation requête sse score
            let score = 58;
            let score_div = document.getElementsByClassName("score-entree")[0];
            score_div.innerHTML = score;
            // simulation requête sse score

            // simulation requête sse indice
            let indice ="Soleil"
            let nombre = 2;
            let indices = document.getElementsByClassName("sous-indices")[0];
            indices.appendChild(this.creerIndice(indice, nombre));
            let indice_entree = document.getElementsByClassName("indice-entree")[0];
            indice_entree.innerHTML = indice;
            let nombre_entree = document.getElementsByClassName("nombre-entree")[0];
            nombre_entree.innerHTML = nombre;
            // simulation requête sse indice

            // simulation 2eme requête sse indice
            let indice2 ="Lune"
            let nombre2 = 3;
            indices.appendChild(this.creerIndice(indice2, nombre2));
            let indice_entree2 = document.getElementsByClassName("indice-entree")[0];
            indice_entree2.innerHTML = indice2;
            let nombre_entree2 = document.getElementsByClassName("nombre-entree")[0];
            nombre_entree2.innerHTML = nombre2;
            // simulation 2eme requête sse indice
        });
    }
    creerIndice(indice, nombre) {
        let indice_div = document.createElement("div");
        let indice_p = document.createElement("p");
        let nombre_p = document.createElement("p");
        indice_p.innerHTML = indice;
        nombre_p.innerHTML = nombre;
        nombre_p.classList.add("nombre");
        nombre_p.classList.add("glass");
        indice_div.classList.add("indice");
        indice_div.appendChild(indice_p);
        indice_div.appendChild(nombre_p);
        return indice_div;
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
