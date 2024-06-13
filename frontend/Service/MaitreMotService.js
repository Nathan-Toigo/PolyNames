export class MaitreMotService {
    async envoyerIndice(jeton, indice, nombre) {
        const response = await fetch("/envoyerIndice/"+jeton+"/"+indice+"/"+nombre, {

        });
        if (response.status === 200) {
            const data = await response.json();
            return data;
        }

    }

    }

