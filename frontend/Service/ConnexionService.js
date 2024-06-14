export class ConnexionService{
    async choisirRole(jeton, role) {
        let reponse = fetch("http://localhost:8080//choisirRole//" + jeton + "//" + role + "//", {
            method: "GET"
        });
        if (reponse.status === 200) {
            const donnee = await reponse.json();
            return donnee;
        }
        if (role === 1) return [
            {
                mot: "Bateau",
                couleur: "bleu",
                face_cachee: false,
            },
            {
                mot: "Étoile",
                couleur: "noir",
                face_cachee: false,
            },
            {
                mot: "Reine",
                couleur: "gris",
                face_cachee: false,
            },
            {
                mot: "Souris",
                couleur: "bleu",
                face_cachee: false,
            },
            {
                mot: "Château",
                couleur: "gris",
                face_cachee: false,
            },
            {
                mot: "Plume",
                couleur: "gris",
                face_cachee: false,
            },
            {
                mot: "Aigle",
                couleur: "gris",
                face_cachee: false,
            },
            {
                mot: "Banane",
                couleur: "bleu",
                face_cachee: false,
            },
            {
                mot: "Magie",
                couleur: "gris",
                face_cachee: false,
            },
            {
                mot: "Océan",
                couleur: "gris",
                face_cachee: false,
            },
            {
                mot: "Trompette",
                couleur: "bleu",
                face_cachee: false,
            },
            {
                mot: "Fusée",
                couleur: "noir",
                face_cachee: false,
            },
            {
                mot: "Diamant",
                couleur: "gris",
                face_cachee: false,
            },
            {
                mot: "Forêt",
                couleur: "bleu",
                face_cachee: false,
            },
            {
                mot: "Drôle",
                couleur: "gris",
                face_cachee: false,
            },
            {
                mot: "Fantôme",
                couleur: "gris",
                face_cachee: false,
            },
            {
                mot: "Galaxie",
                couleur: "bleu",
                face_cachee: false,
            },
            {
                mot: "Horloge",
                couleur: "gris",
                face_cachee: false,
            },
            {
                mot: "Montagne",
                couleur: "gris",
                face_cachee: false,
            },
            {
                mot: "Lune",
                couleur: "bleu",
                face_cachee: false,
            },
            {
                mot: "Piano",
                couleur: "gris",
                face_cachee: false,
            },
            {
                mot: "Robot",
                couleur: "gris",
                face_cachee: false,
            },
            {
                mot: "Sirène",
                couleur: "bleu",
                face_cachee: false,
            },
            {
                mot: "Tigre",
                couleur: "gris",
                face_cachee: false,
            },
            {
                mot: "Voleur",
                couleur: "gris",
                face_cachee: false,
            },
        ];
        if (role === 2) return [
            {
                word: "Bateau",
                face_cachee: true,
                couleur: "gris",
            },
            {
                word: "Étoile",
                face_cachee: true,
                couleur: "bleu",
            },
            {
                word: "Reine",
                face_cachee: true,
                couleur: "noir",
            },
            {
                word: "Souris",
                face_cachee: false,
            },
            {
                word: "Château",
                face_cachee: false,
            },
            {
                word: "Plume",
                face_cachee: false,
            },
            {
                word: "Aigle",
                face_cachee: false,
            },
            {
                word: "Banane",
                face_cachee: false,
            },
            {
                word: "Magie",
                face_cachee: false,
            },
            {
                word: "Océan",
                face_cachee: false,
            },
            {
                word: "Trompette",
                face_cachee: false,
            },
            {
                word: "Fusée",
                face_cachee: false,
            },
            {
                word: "Diamant",
                face_cachee: false,
            },
            {
                word: "Forêt",
                face_cachee: false,
            },
            {
                word: "Drôle",
                face_cachee: false,
            },
            {
                word: "Fantôme",
                face_cachee: false,
            },
            {
                word: "Galaxie",
                face_cachee: false,
            },
            {
                word: "Horloge",
                face_cachee: false,
            },
            {
                word: "Montagne",
                face_cachee: false,
            },
            {
                word: "Lune",
                face_cachee: false,
            },
            {
                word: "Piano",
                face_cachee: false,
            },
            {
                word: "Robot",
                face_cachee: false,
            },
            {
                word: "Sirène",
                face_cachee: false,
            },
            {
                word: "Tigre",
                face_cachee: false,
            },
            {
                word: "Voleur",
                face_cachee: false,
            },
        ];
    }
    async menu() {
        fetch("http://localhost:8080/menu", {
            method: "POST"
        });
    }
    async creer() {
        // fetch("http://localhost:8080/creerPartie", {
        //     method: "GET"
        // });
        // if (response.status === 200) {
        //     const donnee = await response.json();
        //     return donnee;
        // }
        return {jeton: 8625632456, codePartie: "code35352"};
    }
    async rejoindre(code) {
        // fetch("http://localhost:8080/rejoindrePartie/" + code, {
        //     method: "GET"
        // });
        // if (response.status === 200) {
        //     const donnee = await response.json();
        //     return donnee;
        // }
        return {jeton : 75};
    }
}