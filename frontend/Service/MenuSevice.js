export class MenuService {

    static async TrouverTout()
    {
        const response = await fetch("http://localhost:8080/menu");
        if(response.status === 200)
        {
            const data = await response.json();
            return data;
        }
    }
}