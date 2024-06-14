export class ConnexionService{
    async choisirRole(jeton, role) {
        let reponse = await fetch("http://localhost:8080/choisirRole/".concat(jeton,"/",role), {
            method: "GET"
        });
        if (reponse.status === 200) {
            const donnee = await reponse.json();
            return donnee;
        }
        else{
            throw(new Error)
        }

    }
    async menu() {
        fetch("http://localhost:8080/menu", {
            method: "POST"
        });
    }
    async creer() {
        let reponse = await fetch("http://localhost:8080/creerPartie", {
            method: "GET"
        });
        if (reponse.status === 200) {
            const donnee = await reponse.json();
            return donnee;
        }
        
    }
    async rejoindre(code) {
        let reponse = await fetch("http://localhost:8080/rejoindrePartie/".concat(code), {
            method: "GET"
        });
        if (reponse.status === 200) {
            const donnee = await reponse.json();
            return donnee;
        }

    }
}