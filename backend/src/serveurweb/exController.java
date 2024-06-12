package serveurweb;

import BaseWebserver.WebServerContext;
import dao.MotDAO;
import java.sql.SQLException;
import modele.Mot;

public class exController
{
    public static void findAll(WebServerContext context)
    {
        MotDAO motDAO = new MotDAO();
        Mot m = new Mot();

        try {
            var mots = motDAO.trouverTout(m);
            context.getResponse().json(mots);
        } catch (SQLException e) {
            context.getResponse().serverError("Erreur SQL");
            System.err.println(e.getMessage());
        }
    }

    public static void exParam(WebServerContext context)
    {
        String exParam = context.getRequest().getParam("exParam");
        context.getResponse().json(exParam + " est un caca");
    }
}