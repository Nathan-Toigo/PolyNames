export class MaitreIntuitionService {
    async envoyerCarte(carte) {
        const response = await fetch("http://localhost:8080/devinerMot/"+jeton+"/"+carte, {
            method: "GET"
        });
        if (response.status === 200) {
            const data = await response.json();
            return data;
        }

    }
}