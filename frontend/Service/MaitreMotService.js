export class MaitreMotService {
    async envoyerIndice(jeton, indice, nombre) {
        const reponse = await fetch("/envoyerIndice/".concat(jeton,"/",indice,"/",nombre), {

        });
        if (reponse.status === 200) {
            const data = await reponse.json();
            return data;
        }

    }

}

