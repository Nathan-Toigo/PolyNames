import { URL_SERVEUR, URL_SSE } from "../const.js";

export class MaitreIntuitionService {
    async envoyerCarte(carte) {
        const url = URL_SERVEUR.concat("devinerMot/".concat(jeton, "/", carte));
        const response = await fetch(url, {
            method: "GET"
        });
        if (response.status === 200) {
            const data = await response.json();
            return data;
        }

    }
}