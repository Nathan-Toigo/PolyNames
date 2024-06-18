import { URL_SERVEUR, URL_SSE } from "../const.js";

export class ConnexionService {
    async choisirRole(jeton, role) {
        const url = URL_SERVEUR.concat("choisirRole/".concat(jeton, "/", role));
        let reponse = await fetch(url, {
            method: "GET"
        });
        if (reponse.status === 200) {
            const donnee = await reponse.json();
            return donnee;
        }
        else {
            throw (new Error)
        }

    }
    async menu() {
        const url = URL_SERVEUR.concat("menu/");
        fetch(url, {
            method: "POST"
        });
    }
    async creer() {
        const url = URL_SERVEUR.concat("creerPartie/");
        let reponse = await fetch(url, {
            method: "GET"
        });
        if (reponse.status === 200) {
            const donnee = await reponse.json();
            return donnee;
        }

    }
    async rejoindre(code) {
        const url = URL_SERVEUR.concat("rejoindrePartie/".concat(code));
        let reponse = await fetch(url, {
            method: "GET"
        });
        if (reponse.status === 200) {
            const donnee = await reponse.json();
            return donnee;
        }

    }
}