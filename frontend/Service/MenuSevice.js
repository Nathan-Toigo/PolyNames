import { URL_SERVEUR, URL_SSE } from "../const.js";

export class MenuService {

    static async TrouverTout() {
        const url = URL_SERVEUR.concat("menu/");
        const response = await fetch(url);
        if (response.status === 200) {
            const data = await response.json();
            return data;
        }
    }
}