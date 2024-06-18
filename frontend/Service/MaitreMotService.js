import { URL_SERVEUR, URL_SSE } from "../const.js";

export class MaitreMotService {
    async envoyerIndice(jeton, indice, nombre) {
        const url = URL_SERVEUR.concat("envoyerIndice/".concat(jeton, "/", indice, "/", nombre));
        const reponse = await fetch(url, {

        });
        if (reponse.status === 200) {
            const data = await reponse.json();
            return data;
        }

    }

}

